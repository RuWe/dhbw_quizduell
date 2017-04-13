package de.dhbw.quizduell;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruth Weber on 13.04.2017.
 */
@Entity
public class WaitingQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Player player;

    public WaitingQueue() {    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
