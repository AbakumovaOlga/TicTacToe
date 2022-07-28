package com.example.tictactoe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.dto.GameUserCreateDto;
import com.example.tictactoe.service.GameUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gameUser")
public class GameUserController {

    private final GameUserService gameUserService;
    
    @PostMapping("/create")
    public void createGameUser(@RequestBody GameUserCreateDto body) {
        gameUserService.createGameUser(body);
    }

}
