package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// URI prefix empty
@Path("")
public class GreetingResourceWihoutURIPrefix {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/withoutUriPrefix")
    public String hello() {
        return "Hello without URI prefix";
    }

}
