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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String server = "server.host() " + this.server.host() + ", server.port() " + this.server.port() + ", + server.address() " + this.server.address();
        String serverWithStaticInitSafe = "serverWithStaticInitSafe.host() " + this.serverWithStaticInitSafe.host() + ", serverWithStaticInitSafe.port() " + this.serverWithStaticInitSafe.port() + ", + serverWithStaticInitSafe.address() " + this.serverWithStaticInitSafe.address();
        return "Hello from Quarkus REST - " + server + serverWithStaticInitSafe;
    }
}
