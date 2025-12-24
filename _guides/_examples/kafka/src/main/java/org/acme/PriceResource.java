package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

@Path("/prices")
public class PriceResource {
    // 1. ways to receive messages -- from -- Kafka
    // 1.4 inject a `Multi` | your bean + subscribe to its events
    @Inject
    @Channel("pricesChannel")
    Multi<Double> prices;

    @GET
    @Path("/prices")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<Double> stream() {
        return prices;
    }
}
