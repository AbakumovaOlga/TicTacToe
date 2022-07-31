package com.example.tictactoe.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
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
    
    public Move() {
    }

    public Move(Game game,GameUser user, int x, int y) {
        this.game=game;
        this.user = user;
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Move other = (Move) obj;
        if (game == null) {
            if (other.game != null)
                return false;
        } else if (!game.equals(other.game))
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((game == null) ? 0 : game.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    
    
}
