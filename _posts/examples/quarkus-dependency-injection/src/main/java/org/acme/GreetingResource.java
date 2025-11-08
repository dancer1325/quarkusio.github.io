package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    InjectExampleService injectExampleService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/inject-example")
    @Produces(MediaType.TEXT_PLAIN)
    public String injectExample() {
        injectExampleService.doSomething();
        return "Check console for @Inject examples output";
    }
}
