package de.dhbw.quizduell.REST;

import de.dhbw.quizduell.*;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pn323l on 24.04.17.
 */
public class DuellNewResource extends ServerResource {

    EntityManager entityManager = new EntityManagerClass().getEntityManager();

    @Post
    public void createNewDuell() {

        long playerId = Long.parseLong((String) getRequestAttributes().get("playerId"));

        List<WaitingQueue> wq = entityManager.createQuery("FROM WaitingQueue WHERE player.id != :playerid").setParameter("playerid", playerId).getResultList();
        if(wq.size() > 0) {
            WaitingQueue waitingQueuePlayer = (WaitingQueue) entityManager.createQuery("FROM WaitingQueue WHERE player.id = :playerid").setParameter("playerid", playerId).getSingleResult();
            Player playerEins = waitingQueuePlayer.getPlayer();
            Player playerZwei = wq.get(0).getPlayer();



            startGame(playerEins, playerZwei);


            entityManager.getTransaction().begin();
            entityManager.remove(waitingQueuePlayer);
            entityManager.remove(wq.get(0));
            entityManager.getTransaction().commit();

        }

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

}
