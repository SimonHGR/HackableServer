package com.example;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessageResource {
    private static List<String> messages = new ArrayList<>();
    static {
        messages.add("This is message zero");
    }
    
    @GET
    @Path("/{id: \\d+}")
    public String getMessage(@PathParam("id") int id) {
        if (id < messages.size()) {
            return messages.get(id);
        } else {
            throw new WebApplicationException(
                    Response.ok("No message id " + id)
                    .status(Response.Status.NOT_FOUND)
                    .build());
        }
    }
    
    @POST
    public Response createMessage(@FormParam("message") String message) {
        System.out.println("Post, message is "+ message);
        int idx = messages.size();
        messages.add(message);
        return Response.status(Response.Status.CREATED)
                .header("location", "/messages/" + idx)
                .entity("Accepted! ").build();
    }
}
