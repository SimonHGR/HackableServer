package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/files")
public class MyResource {

    @Path("/{id}")
    @GET
    public String getIt(@PathParam("id") String id) {
        System.out.println("Reading file " + id);
        try (BufferedReader input = Files.newBufferedReader(Paths.get("./files/" + id))) {
            System.out.println("Trying to return stream...");
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = input.readLine()) != null) {
                sb.append(line).append('\n');
            }
            return sb.toString();
        } catch(IOException ioe) {
            System.out.println("Throwing not found");
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity(id + " does not exist").build());
        }
    }
}
