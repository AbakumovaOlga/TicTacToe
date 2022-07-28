package com.example.tictactoe.dto;

import lombok.Getter;

@Getter
public class GameUserTableDto {
        
    private final String fio;

    private final int win;

    private final int defeat;

    public GameUserTableDto(String fio,
            int win,
            int defeat) {
        this.fio = fio;
        this.defeat = defeat;
        this.win = win;
    }
}
