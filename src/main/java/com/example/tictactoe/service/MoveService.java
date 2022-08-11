package com.example.tictactoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.tictactoe.dto.MoveCreateDto;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.model.Game.Status;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.repository.GameUserRepository;
import com.example.tictactoe.repository.MoveRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MoveService {

    @Value("${myConfig.map-size}")
    private int MAP_SIZE;

    private int winner = -1;
    private final MoveRepository moveRepository;
    private final GameRepository gameRepository;
    private final GameUserRepository gameUserRepository;

    public String createMove(GameUser player, MoveCreateDto body) {

        Game game = gameRepository.findById(body.getGameId());
        if (game == null) {
            return "error: no game";
        }

        if (!game.getGameUsers().contains(player)) {
            return "error: it's not your game";
        }

        Move move = moveRepository.findLast(game);
        if (move != null && move.getUser().getId() == player.getId()) {
            return "error: it's not your turn";
        }

        if (game.getStatus() == Status.FINISHED) {
            return "error: it is finished game";
        }
        var moveNew = new Move(game, player, body.getX(), body.getY());

        if (game.getMoves().contains(moveNew)) {
            return "error: the cage is occupied";
        }

        moveRepository.save(moveNew);

        List<Move> moves = moveRepository.findAll(game);

        int[][] res = printMoves(moves);

        if (isFinish(res)) {
            String resString = "winner is ";
            game.setStatus(Status.FINISHED);
            gameRepository.save(game);
            for (GameUser gameUser : game.getGameUsers()) {
                if (gameUser.getId() == winner) {
                    gameUser.setWin(gameUser.getWin() + 1);
                    gameUserRepository.save(gameUser);
                    resString += gameUser.getFio();
                } else {
                    gameUser.setDefeat(gameUser.getDefeat() + 1);
                    gameUserRepository.save(gameUser);
                }
            }
            return resString;
        }

        if (moves.size() == Math.pow(MAP_SIZE, 2)) {
            game.setStatus(Status.FINISHED);
            gameRepository.save(game);
            return "game is over";
        }
        // return gameRepository.checkfinish(moveRepository.findAll(game));

        return "ok";
    }

    private boolean isFinish(int[][] res) {
        return checkWinnerHorizontal(res) ||
                checkWinnerVertical(res) ||
                checkWinnerDiagonals(res);

    }

    private boolean checkWinnerHorizontal(int[][] field) {
        for (int i = 0; i < MAP_SIZE; i++) {
            boolean isWIn = true;
            int winnerId = -1;
            if (field[i][0] == -1) {
                continue;
            }
            for (int j = 1; j < MAP_SIZE && isWIn; j++) {

                isWIn = field[i][j] == field[i][0];
                winnerId = field[i][j];
            }
            if (isWIn) {
                System.out.println("horiz " + winnerId);
                winner = winnerId;
                return true;
            }
        }
        System.out.println("horiz no winner");
        return false;
    }

    private boolean checkWinnerVertical(int[][] field) {
        for (int i = 0; i < MAP_SIZE; i++) {

            boolean isWIn = true;
            int winnerId = -1;
            if (field[0][i] == -1) {
                continue;
            }
            for (int j = 1; j < MAP_SIZE && isWIn; j++) {
                isWIn = field[j][i] == field[0][i];
                winnerId = field[j][i];
            }
            if (isWIn) {
                System.out.println("vert " + winnerId);
                winner = winnerId;
                return true;
            }
        }
        System.out.println("vert no winner");
        return false;
    }

    private boolean checkWinnerDiagonals(int[][] field) {
        boolean isWIn = true;
        int winnerId = -1;
        for (int i = 1; i < MAP_SIZE && isWIn; i++) {
            if (field[0][0] == -1) {
                isWIn = false;
                continue;
            }
            isWIn = field[i][i] == field[0][0];
            winnerId = field[i][i];
        }
        if (isWIn) {
            System.out.println("diag" + winnerId);
            winner = winnerId;
            return true;
        }
        isWIn = true;
        winnerId = -1;
        for (int i = 1; i < MAP_SIZE && isWIn; i++) {
            if (field[MAP_SIZE - i - 1][0] == -1) {
                isWIn = false;
                continue;
            }
            isWIn = field[MAP_SIZE - i - 1][i] == field[MAP_SIZE - 1][0];
            winnerId = field[MAP_SIZE - i - 1][i];
        }
        if (isWIn) {
            System.out.println("diag" + winnerId);
            winner = winnerId;
            return true;
        }
        System.out.println("diag no winner");
        return false;
    }

    private int[][] printMoves(List<Move> moves) {
        int[][] res = new int[MAP_SIZE][MAP_SIZE];
        for (int x = 0; x < MAP_SIZE; x++) {
            for (int y = 0; y < MAP_SIZE; y++) {
                res[x][y] = -1;
            }
        }

        for (Move moveRes : moves) {
            res[moveRes.getX()][moveRes.getY()] = moveRes.getUser().getId();
        }

        for (int x = 0; x < MAP_SIZE; x++) {
            for (int y = 0; y < MAP_SIZE; y++) {
                System.out.print(res[x][y] + " ");
            }
            System.out.println();
        }
        return res;
    }

}
