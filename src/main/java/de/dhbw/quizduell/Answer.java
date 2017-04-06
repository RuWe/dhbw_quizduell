package de.dhbw.quizduell;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kfrank on 03.04.2017.
 */
@Entity
public class Answer {

    @Id
    private long id;

    private String answer;

    @OneToMany(mappedBy = "correctAnswer")
    private List<Question> question;

    public Answer() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
