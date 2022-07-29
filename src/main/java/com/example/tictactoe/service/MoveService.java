package com.example.tictactoe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tictactoe.dto.MoveCreateDto;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.model.Game.Status;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.repository.MoveRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MoveService {

    private final MoveRepository moveRepository;
    private final GameRepository gameRepository;

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
        moveRepository.save(new Move(game, player, body.getX(), body.getY()));

        return "ok";
    }

}
