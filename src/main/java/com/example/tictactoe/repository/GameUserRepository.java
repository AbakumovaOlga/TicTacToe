package com.example.tictactoe.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.tictactoe.dto.GameUserTableDto;
import com.example.tictactoe.model.GameUser;

@Repository
public interface GameUserRepository {
    void save(GameUser user);

    List<GameUser> findAll();

    GameUser findById(int id);

    GameUser authorization(String login, String password);

    List<GameUserTableDto> tableGameUsers();
}