package com.example.tictactoe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tictactoe.dto.MoveCreateDto;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.service.GameUserService;
import com.example.tictactoe.service.MoveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/move")
public class MoveController {
    private final MoveService moveService;
    private final GameUserService gameUserService;

    @PostMapping
    @ResponseBody
    public String createMove(@RequestHeader("login") String login, @RequestHeader("password") String password, @RequestBody MoveCreateDto body) {
        GameUser player = gameUserService.authorization(login, password);
        if (player != null) {
            System.out.println("200");
            return moveService.createMove(player, body);
        } else {
            System.out.println("401");
            return "error 401";
        }
    }
}
