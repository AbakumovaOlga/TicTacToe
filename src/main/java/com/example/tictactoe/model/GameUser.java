package com.example.tictactoe.model;


import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class GameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    private String login;
    
    private String password;

    private int win;
    
    private int defeat;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Move> moves;

}
