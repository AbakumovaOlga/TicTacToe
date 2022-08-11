package com.example.tictactoe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GameUserCreateDto {


    private final String fio;

    private final String login;
    
    private final String password;

    private final int win;
    
    private final int defeat;

    public GameUserCreateDto(@JsonProperty("fio") String fio,
                         @JsonProperty("login") String login,
                         @JsonProperty("password") String password) {
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.defeat=0;
        this.win=0;
    }

    
}
