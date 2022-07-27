package com.example.tictactoe.repository;

import java.util.List;

import com.example.tictactoe.model.Move;


public interface MoveRepository {
    void save(Move game);

    List<Move> findAll();

    Move findById(int id);

}
