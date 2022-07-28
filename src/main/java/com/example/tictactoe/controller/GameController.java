package com.example.tictactoe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.dto.GameDto;
import com.example.tictactoe.model.*;
import com.example.tictactoe.service.GameService;
import com.example.tictactoe.service.GameUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;
    private final GameUserService gameUserService;

    @PostMapping("/create")
    public void createGameUser(@RequestHeader("login") String login, @RequestHeader("password") String password) {
        GameUser player = gameUserService.authorization(login, password);
        if (player != null) {
            System.out.println("200");
            gameService.createGame(player);
        } else {
            System.out.println("401");
        }
    }

    @GetMapping
    @ResponseBody
    public List<GameDto> getGames(@RequestHeader("login") String login, @RequestHeader("password") String password) {
        GameUser player = gameUserService.authorization(login, password);
        if (player != null) {
            System.out.println("200");
            System.out.println(player.getGames().size());
            List<GameDto> gameCreateDtos=new ArrayList<GameDto>();
            for (Game game : player.getGames()) {
                gameCreateDtos.add(new GameDto(game.getStatus(), game.getId(), game.getGameUsers()));
            }
            return gameCreateDtos;
        } else {
            System.out.println("401");
            return null;
        }

    }
}
