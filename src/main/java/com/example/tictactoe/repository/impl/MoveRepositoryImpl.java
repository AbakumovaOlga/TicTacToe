package com.example.tictactoe.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.tictactoe.model.Move;
import com.example.tictactoe.repository.MoveRepository;
@Repository
@Transactional
public class MoveRepositoryImpl implements MoveRepository {

    @Override
    public void save(Move move) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Move> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Move findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
