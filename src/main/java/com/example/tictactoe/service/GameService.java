package com.example.tictactoe.service;


import org.springframework.stereotype.Service;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.model.Game.Status;
import com.example.tictactoe.repository.GameUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameService {

    private final GameUserRepository gameUserRepository;

    public void createGame(GameUser player) {
        var newGame = new Game(Status.INPROCESS);
        player.getGames().add(newGame);
        gameUserRepository.save(player);
    }

}
