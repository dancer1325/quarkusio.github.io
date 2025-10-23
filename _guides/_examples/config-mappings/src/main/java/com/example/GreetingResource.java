package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Server server;

    @Inject
    ServerWithStaticInitSafe serverWithStaticInitSafe;

    @Inject
    ServerNestedSubgroups serverNestedSubgroups;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String server = "server.host() " + this.server.host() + ", server.port() " + this.server.port() + ", + server.address() " + this.server.address();
        String serverWithStaticInitSafe = "serverWithStaticInitSafe.host() " + this.serverWithStaticInitSafe.host() + ", serverWithStaticInitSafe.port() " + this.serverWithStaticInitSafe.port() + ", + serverWithStaticInitSafe.address() " + this.serverWithStaticInitSafe.address();
        return "Hello from Quarkus REST - " + server + serverWithStaticInitSafe;
    }

    @GET
    @Path("/nestedsubgroup")
    @Produces(MediaType.TEXT_PLAIN)
    public String nestedsubgroup() {
        String serverNestedSubgroups = "serverNestedSubgroups.host() " +
                this.serverNestedSubgroups.host() +
                ", serverNestedSubgroups.port() " +
                this.serverNestedSubgroups.port() +
                ", + serverNestedSubgroups.log().enabled() " +
                this.serverNestedSubgroups.log().enabled() +
                ", + serverNestedSubgroups.log().suffix() " +
                this.serverNestedSubgroups.log().suffix() +
                ", + serverNestedSubgroups.log().rotate() " +
                this.serverNestedSubgroups.log().rotate();
        return "nestedsubgroup - " + serverNestedSubgroups;
    }
}
