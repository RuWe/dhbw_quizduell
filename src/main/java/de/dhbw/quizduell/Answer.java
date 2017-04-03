package de.dhbw.quizduell;

/**
 * Created by kfrank on 03.04.2017.
 */
public class Answer {

    private long id;

    private String answer;

    private Answer() {}

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
