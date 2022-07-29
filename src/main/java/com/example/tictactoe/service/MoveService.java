package com.example.tictactoe.service;

import org.springframework.stereotype.Service;

import com.example.tictactoe.dto.MoveCreateDto;
import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.repository.GameRepository;
import com.example.tictactoe.repository.MoveRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MoveService {

    private final MoveRepository moveRepository;
    private final GameRepository gameRepository;

    public String createMove(GameUser player, MoveCreateDto body) {
        // if(moveRepository.isYourMove(body.getGameId(), player.)){

        // }
        Game game=gameRepository.findById(body.getGameId());
        System.out.println(game.getId());
        return null;
    }
    
}
