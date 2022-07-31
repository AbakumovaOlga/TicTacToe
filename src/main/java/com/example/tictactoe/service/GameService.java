package com.example.tictactoe.service;


import org.springframework.stereotype.Service;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.model.Game.Status;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.repository.GameUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameService {

    private final GameUserRepository gameUserRepository;
    private final GameRepository gameRepository;

    public void createGame(GameUser player) {
        var newGame = new Game(Status.INPROCESS);
        player.getGames().add(newGame);
        gameUserRepository.save(player);
    }

    public void joinGame(GameUser player, int id) throws Exception {
        var joinGame=gameRepository.findById(id);
        if(joinGame.getGameUsers().size()>1){
            throw new Exception("there are no available seats");
        }
        player.getGames().add(joinGame);
        gameUserRepository.save(player);
    }

}
