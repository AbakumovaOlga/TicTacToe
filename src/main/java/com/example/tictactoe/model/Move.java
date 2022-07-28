package com.example.tictactoe.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gameUser_id")
    private GameUser user;

    // position
    private int x;
    private int y;
}
