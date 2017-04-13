package de.dhbw.quizduell;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Game {
    EntityManager entityManager = new EntityManagerClass().getEntityManager();


    public Game() {
    }

    public void startGame(Player playerEins, Player playerZwei) {
        entityManager.getTransaction().begin();
        Duell duell = new Duell();
        duell.setPlayer1(playerEins);
        duell.setPlayer2(playerZwei);
        entityManager.persist(duell);

        List<Round> rounds = new ArrayList<Round>();

        for(int i=0; i<6; i++) {
            Round round = new Round();
            List<Question> questions = new ArrayList<Question>();
            for(int j=0; j<3; j++) {
                List<Question> allQuestions = entityManager.createQuery("FROM Question", Question.class).getResultList();

                int randomQuestion = (int) (Math.random() * allQuestions.size());

                Question selectedQuestion = (Question) entityManager.createQuery("FROM Question WHERE id = :questionId").setParameter("questionId", allQuestions.get(randomQuestion).getId()).getSingleResult();

                questions.add(selectedQuestion);
            }
            round.setQuestions(questions);
            round.setDuell(duell);
            entityManager.persist(round);
            rounds.add(round);
        }

        duell.setRounds(rounds);

        entityManager.persist(duell);
        entityManager.getTransaction().commit();
    }

    public void playRound(long roundId) {
        //TODO: runde mit der Nummer x soll nun gespielt werden
    }

    public void setQuestionAnswer(long questionId, long answerId, long playerId) {
        //TODO: setze antwort zu Frage x
    }


}
