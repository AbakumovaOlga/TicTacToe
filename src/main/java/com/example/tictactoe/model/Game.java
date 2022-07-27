package com.example.tictactoe.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Status status;

    public static enum Status {

        INPROCESS, FINISHED

    }

    private int player1_id;

    private int player2_id;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Move> moves;
}
