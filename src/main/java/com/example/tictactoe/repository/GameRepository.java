package com.example.tictactoe.repository;

import java.util.List;


import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;

public interface GameRepository {
    void save(Game game);

    List<Game> findAll();

    Game findById(int id);

    Game findByGameUser(GameUser user);

}
