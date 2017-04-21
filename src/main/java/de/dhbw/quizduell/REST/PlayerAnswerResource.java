package de.dhbw.quizduell.REST;

import de.dhbw.quizduell.*;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;

/**
 * Created by kfrank on 21.04.2017.
 */
public class PlayerAnswerResource extends ServerResource {

    @Post
    public void setAnswer() {
        EntityManager entityManager = new EntityManagerClass().getEntityManager();
        long playerId = Long.parseLong((String) getRequestAttributes().get("playerId"));
        Player player = (Player) entityManager.createQuery("FROM Player WHERE id = :playerId").setParameter("playerId", playerId).getSingleResult();
        long roundId = Long.parseLong((String) getRequestAttributes().get("roundId"));
        Round round = (Round) entityManager.createQuery("from Round where id = :roundId").setParameter("roundId", roundId).getSingleResult();
        long questionId = Long.parseLong((String) getRequestAttributes().get("questionId"));
        Question question = (Question) entityManager.createQuery("from Question where id = :questionId").setParameter("questionId", questionId).getSingleResult();
        long answerId = Long.parseLong((String) getRequestAttributes().get("answerId"));
        Answer answer = (Answer) entityManager.createQuery("from Answer WHERE id = :answerId").setParameter("answerId", answerId).getSingleResult();



        Question_Answer_Set question_answer_set = new Question_Answer_Set();
        question_answer_set.setPlayer(player);
        question_answer_set.setRound(round);
        question_answer_set.setQuestion(question);
        question_answer_set.setAnswer(answer);

        entityManager.getTransaction().begin();
        entityManager.persist(question_answer_set);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
