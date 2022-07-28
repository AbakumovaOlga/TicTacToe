package com.example.tictactoe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tictactoe.dto.GameUserCreateDto;
import com.example.tictactoe.dto.GameUserTableDto;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.repository.GameUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameUserService {
    private final GameUserRepository gameUserRepository;

    public void createGameUser(GameUserCreateDto body) {
        var newGameUser = new GameUser(
                body.getFio(), body.getLogin(), body.getPassword(), 0, 0);

        gameUserRepository.save(newGameUser);
    }

    public GameUser authorization(String login, String password) {

        return gameUserRepository.authorization(login, password);
    }

    public List<GameUserTableDto> findAll() {
        return gameUserRepository.findAll();
    }


}
