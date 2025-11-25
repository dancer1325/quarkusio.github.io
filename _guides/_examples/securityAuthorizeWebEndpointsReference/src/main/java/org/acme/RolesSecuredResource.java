package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/roles-secured")
public class RolesSecuredResource {
    @GET
    public String rolesSecured() {
        return "rolesSecured()";
    }
    @GET
    @Path("/{id}")
    public String rolesSecuredId(@PathParam("id") String id) {
        return "rolesSecuredId(@PathParam(\"id\") String id) " + id;
    }
}
