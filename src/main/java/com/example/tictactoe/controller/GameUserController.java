package com.example.tictactoe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.dto.GameUserCreateDto;
import com.example.tictactoe.dto.GameUserTableDto;
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

    @GetMapping
    @ResponseBody
    public List<GameUserTableDto> findAll() {
        return gameUserService.findAll();
    }

}
