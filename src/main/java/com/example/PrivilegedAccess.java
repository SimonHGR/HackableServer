package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/getPrivileged")
public class PrivilegedAccess {
    @GET
    public String doGet() {
        return "<HTML><BODY><H1>Welcome</H1>"
                + "<a href='/myapp/privileged'>Get Privileged Info</a></BODY></HTML>";
    }
}
