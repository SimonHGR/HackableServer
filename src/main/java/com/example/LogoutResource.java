package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/logout")
public class LogoutResource {
    @GET
    public Response logout() {
        return Response.ok("Logged out").cookie(new NewCookie("user", null)).build();
    }
}
