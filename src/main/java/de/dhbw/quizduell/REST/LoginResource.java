package de.dhbw.quizduell.REST;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kfrank on 24.04.2017.
 */
public class LoginResource extends ServerResource {

    @Get
    public StringRepresentation getLogin() {
        StringRepresentation sr = new StringRepresentation(getSomeHTML());
        sr.setMediaType(MediaType.TEXT_HTML);
        return sr;
    }

    @Post
    public void login(String username) {

    }

    public static void main(String[] args) {
        LoginResource lr = new LoginResource();
        lr.getSomeHTML();
    }

    public String getSomeHTML() {

        String html = "";
        try {

            BufferedReader in = new BufferedReader (
                    new FileReader("./src/main/resources/HTML/login.html") );
            try {
                String out;
                while( (out = in.readLine()) != null ) {
                    html += out;
                }
                in.close();
            } catch (IOException e) {
                System.out.println("Read error " + e);
            }
        }
        catch (IOException e) {
            System.out.println("Open error " + e);
        }

        return html;
    }
}
