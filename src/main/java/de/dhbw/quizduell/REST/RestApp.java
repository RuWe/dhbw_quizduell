package de.dhbw.quizduell.REST;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by kfrank on 11.04.2017.
 */
public class RestApp extends Application{

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/game/player/{playerId}", ClientResource.class);
        router.attach("/game/login", LoginResource.class); // Login für den Spieler
        router.attach("/game/player/{playerId}/round/{roundId}/question/{questionId}/answer/{answerId}", PlayerAnswerResource.class); // set answer for player
        router.attach("/game/player/{playerId}/duell/{duellId}", DuellFinishedResource.class);

        return router;
    }

}
