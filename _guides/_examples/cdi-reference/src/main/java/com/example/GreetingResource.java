package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    ProducersOnCDI producersOnCDI;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        MyService myServiceOnCDI = producersOnCDI.produceService();
        myServiceOnCDI.getCoolProperty();

        MyService myServiceOnQuarkus = new ProducersOnQuarkus().produceService();
        myServiceOnQuarkus.getCoolProperty();

        return "Hello from Quarkus REST";
    }
}
