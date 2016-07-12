package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/privileged")
public class PrivilegedResource {

    @GET
    public String getPriv(@CookieParam("user") String session) {
        if (session == null || session.length() == 0) {
            try {
                URI redirTo = new URI("/myapp/files/index.html");
                throw new WebApplicationException(Response.temporaryRedirect(redirTo).build());
            } catch (URISyntaxException ex) {
                System.out.println("URISyntax!");
            }
        }
        System.out.println("authorized request for secret info...");
        return "<html><body><p>Here is the secret info for logged in users. "
                + "Your session is " + session + "</p></body></html>";
        
    }
}
