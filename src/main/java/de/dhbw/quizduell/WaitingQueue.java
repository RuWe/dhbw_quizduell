package de.dhbw.quizduell;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruth Weber on 13.04.2017.
 */
@Entity
public class WaitingQueue {

    @Id
    private long id;

    @OneToMany
    private List<Player> player;

    public WaitingQueue() {    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
