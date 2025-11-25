package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/other")
public class OtherResource {
    @GET
    public String other() {
        return "other()";
    }
    @GET
    @Path("/{id}")
    public String otherId(@PathParam("id") String id) {
        return "otherId(@PathParam(\"id\") String id) " + id ;
    }
}
