package com.example.tictactoe.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Move;
import com.example.tictactoe.repository.MoveRepository;

@Repository
@Transactional
public class MoveRepositoryImpl implements MoveRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Move save(Move move) {
        entityManager.persist(move);
        return move;
    }

    @Override
    public List<Move> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Move findById(int id) {
        return entityManager.find(Move.class, id);
    }

    @Override
    public Move findLast(Game game) {
        List<Move> moves = entityManager
                .createQuery(
                        "SELECT Move from Move Move where Move.game=?1 order by id desc",
                        Move.class)
                .setParameter(1, game)
                .setMaxResults(1).getResultList();
        return moves.size() == 0 ? null : moves.get(0);
    }

    @Override
    public List<Move> findAll(Game game) {
        return entityManager
                .createQuery(
                        "SELECT Move from Move Move where Move.game=?1",
                        Move.class)
                .setParameter(1, game)
                .getResultList();

    }

}
