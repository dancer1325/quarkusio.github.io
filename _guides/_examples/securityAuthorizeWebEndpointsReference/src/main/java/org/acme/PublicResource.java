package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/public")
public class PublicResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String publicHost() {
        return "Hello public";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String publicById(@PathParam("id") String id) {
        return "Hello public" + id;
    }
}
