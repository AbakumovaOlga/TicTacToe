package com.example.tictactoe.dto;

import lombok.Getter;

@Getter
public class MoveCreateDto {
    private final int x;
    private final int y;

    private final int gameId;

    public MoveCreateDto(int x, int y, int gameId) {
        this.x = x;
        this.y = y;
        this.gameId = gameId;
    }
}
