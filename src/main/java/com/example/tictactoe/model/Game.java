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
    @ManyToMany(mappedBy = "games")
    private List<GameUser> gameUsers;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Move> moves;

    public Game(Status status) {
        this.status = status;
    }

    public Game() {
    }
    

    
}
