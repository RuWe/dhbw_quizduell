package de.dhbw.quizduell.REST;

import de.dhbw.quizduell.Duell;
import de.dhbw.quizduell.EntityManagerClass;
import de.dhbw.quizduell.Player;
import de.dhbw.quizduell.Round;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kfrank on 24.04.2017.
 */
public class DuellFinishedResource extends ServerResource {

    @Post
    public void finishDuell() {
        long duellId = Long.parseLong((String) getRequestAttributes().get("duellId"));
        EntityManager entityManager = new EntityManagerClass().getEntityManager();

        Duell duell = (Duell) entityManager.createQuery("FROM Duell WHERE id = :duellId").setParameter("duellId", duellId).getSingleResult();

        List<Round> roundList = duell.getRounds();
        Player player1 = duell.getPlayer1();
        Player player2 = duell.getPlayer2();

        List correctAnswersPlayer1 = new ArrayList();
        List correctAnswersPlayer2 = new ArrayList();

        for (Round round : roundList) {
            correctAnswersPlayer1.addAll(entityManager.createQuery("FROM Question_Answer_Set qa join Question q on q.correctAnswer.id = qa.answer.id where qa.round.id = :roundId and qa.player.id = :playerId").setParameter("roundId", round.getId()).setParameter("playerId", player1.getId()).getResultList());
            correctAnswersPlayer2.addAll(entityManager.createQuery("FROM Question_Answer_Set qa join Question q on q.correctAnswer.id = qa.answer.id where qa.round.id = :roundId and qa.player.id = :playerId").setParameter("roundId", round.getId()).setParameter("playerId", player2.getId()).getResultList());
        }

        entityManager.getTransaction().begin();

        if(correctAnswersPlayer1.size() > correctAnswersPlayer2.size()) {
            player1.setScore(player1.getScore() + 5);
            player2.setScore(player2.getScore() - 1);
        } else {
            if (correctAnswersPlayer1.size() < correctAnswersPlayer2.size()) {
                player1.setScore(player1.getScore() - 1);
                player2.setScore(player2.getScore() + 5);
            }
        }

        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.remove(duell);
        entityManager.getTransaction().commit();

        entityManager.close();
    }


}
