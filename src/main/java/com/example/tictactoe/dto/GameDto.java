package com.example.tictactoe.dto;

import java.util.List;

import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.model.Game.Status;

import lombok.Getter;

@Getter
public class GameDto {
    private final Status status;
    private final int id;
    private final String player1;
    private final String player2;
    //private final List<GameUser> players;

    public GameDto(Status status, int id, List<GameUser> players) {
        this.status = status;
        this.id=id;
        this.player1=players.get(0).getFio();
        this.player2=players.size()>1 ? players.get(1).getFio() : null;
    }

    
}
