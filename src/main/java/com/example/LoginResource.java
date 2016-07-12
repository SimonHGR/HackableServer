package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {
    @GET
    public Response login(@QueryParam("user") String user, @QueryParam("pass") String pass) {
        System.out.println("Login!!!");
        return Response.ok("Welcome")
                .cookie(new NewCookie("user", "SESS" + (int)(Math.random() * 10_000)))
                .build();
    }
}
