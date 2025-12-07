package org.acme;

import io.smallrye.mutiny.Uni;
import io.vertx.core.Vertx;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Duration;

@Path("/reactive-demo")
public class ReactiveDemo {

    @Inject
    Vertx vertx;

    @GET
    @Path("/slow")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> slowEndpoint() {
        return Uni.createFrom().item("Completed after 2s")
            .onItem().delayIt().by(Duration.ofSeconds(2));
    }

    @GET
    @Path("/fast")
    @Produces(MediaType.TEXT_PLAIN)
    public String fastEndpoint() {
        return "Fast response";
    }
}
