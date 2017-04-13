package de.dhbw.quizduell;

import javax.persistence.*;
import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * Created by Ruth Weber on 30.03.2017.
 */
public class Server {

    EntityManager entityManager = new EntityManagerClass().getEntityManager();

    public Server() {}

    public static void main(String[] args) {

        Server server = new Server();

        //server.savePlayers();

        long playerId = server.login("Klaus");
        System.out.println(playerId);
        boolean otherPlayersWaiting = server.match(playerId);
        System.out.println("Andere Spieler warten: "+ otherPlayersWaiting);
        server.login("Peter");
        otherPlayersWaiting = server.match(playerId);
        System.out.println("Andere Spieler warten: "+ otherPlayersWaiting);

        boolean roundToPlay = server.roundToPlay(playerId);
        System.out.println("Runden da: "+ roundToPlay);


        server.logout();

        /*Game game = new Game();

        Player player1 = new Player();
        Player player2 = new Player();

        player1.setPlayerName("Peter");
        player1.setScore(2);
        player2.setPlayerName("Klaus");
        player2.setScore(5);

        Duell duell = new Duell();
        duell.setPlayer1(player1);
        duell.setPlayer2(player2);

        entityManager.getTransaction().begin();
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.persist(duell);
        entityManager.getTransaction().commit();

        entityManager.close();*/

    }


/*    public void savePlayers() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setPlayerName("Peter");
        player1.setScore(2);
        player2.setPlayerName("Klaus");
        player2.setScore(5);
        entityManager.getTransaction().begin();
        entityManager.persist(player1);
        entityManager.persist(player2);
        entityManager.getTransaction().commit();
    }*/

   public long login(String username) {
       Player player = (Player) entityManager.createQuery("FROM Player WHERE playerName = :username").setParameter("username", username).getSingleResult();

       if(player != null) {
           List<WaitingQueue> waitingQueueList = entityManager.createQuery("FROM WaitingQueue WHERE player.id = :playerid").setParameter("playerid", player.getId()).getResultList();
           if(waitingQueueList.size() == 0) {
               entityManager.getTransaction().begin();
               WaitingQueue wq = new WaitingQueue();
               wq.setPlayer(player);
               entityManager.persist(wq);
               entityManager.getTransaction().commit();

           }
           return player.getId();
       } else {
            return 0;
       }
   }

    public void logout() {
        entityManager.close();
    }

    public boolean match(long playerId) {
        List<WaitingQueue> wq = entityManager.createQuery("FROM WaitingQueue WHERE player.id != :playerid").setParameter("playerid", playerId).getResultList();
        if(wq.size() > 0) {
            WaitingQueue waitingQueuePlayer = (WaitingQueue) entityManager.createQuery("FROM WaitingQueue WHERE player.id = :playerid").setParameter("playerid", playerId).getSingleResult();
            Player playerEins = waitingQueuePlayer.getPlayer();
            Player playerZwei = wq.get(0).getPlayer();

            entityManager.getTransaction().begin();
            entityManager.remove(waitingQueuePlayer);
            entityManager.remove(wq.get(0));
            entityManager.getTransaction().commit();

            Game game = new Game();
            game.startGame(playerEins, playerZwei);

            return true;
        } else {
            return false;
        }
    }

    public boolean roundToPlay(long playerId) {
        Duell duell = (Duell) entityManager.createQuery("FROM Duell WHERE player1.id = :playerId").setParameter("playerId", playerId).getSingleResult();
        List<Round> rounds = duell.getRounds();
        for (Round round : rounds) {
            List<Question_Answer_Set> question_answer_sets = entityManager.createQuery("FROM Question_Answer_Set WHERE round = :round")
                    .setParameter("round", round).getResultList();
            if(question_answer_sets.size() < 3) {
                return true;
            }
        }

        Duell duell2 = (Duell) entityManager.createQuery("FROM Duell WHERE player2.id = :playerId").setParameter("playerId", playerId).getSingleResult();
        List<Round> rounds2 = duell2.getRounds();
        for (Round round2 : rounds2) {
            List<Question_Answer_Set> question_answer_sets = entityManager.createQuery("FROM Question_Answer_Set WHERE round = :round")
                    .setParameter("round", round2).getResultList();
            if(question_answer_sets.size() < 3) {
                return true;
            }
        }

        return false;

    }

}
