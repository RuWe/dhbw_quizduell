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

        return router;
    }

}
