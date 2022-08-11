package com.example.tictactoe.model;


import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class GameUser {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    @Column(unique=true)
    private String login;
    
    private String password;

    private int win;
    
    private int defeat;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "GameUser_Game", 
        joinColumns = { @JoinColumn(name = "gameUser_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "game_id") }
    )
    private List<Game> games;

    @OneToMany(mappedBy = "user")
    private List<Move> moves;

    public GameUser( String fio, String login, String password, int win, int defeat) {
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.win = win;
        this.defeat = defeat;
    }
    

}
