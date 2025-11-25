package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/forbidden")
public class ForbiddenResource {
    @GET
    public String forbidden() {
        return "No!";
    }
}
