package com.example.tictactoe.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.GameUser;
import com.example.tictactoe.repository.GameRepository;

@Repository
@Transactional
public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Game game) {
        entityManager.persist(game);
    }

    @Override
    public List<Game> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Game findById(int id) {
        return entityManager.find(Game.class, id);

    }

    @Override
    public List<Game> findByGameUser(GameUser GameUser) {
        // TODO Auto-generated method stub
        return null;
    }

}
