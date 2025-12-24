package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.concurrent.Flow;

@Path("/prices")
public class PriceResource {
    // 1. ways to receive messages -- from -- Kafka
    // 1.4 inject a `Multi` | your bean + subscribe to its events
    @Inject
    @Channel("pricesChannel")
    Multi<Double> prices;

    @Inject
    @Channel("pricesChannelMessage")
    Multi<Message<Double>> priceChannelMessage;

    @Inject
    @Channel("pricesChannelPublisher")
    Flow.Publisher<Double> priceChannelPublisher;

    @Inject
    @Channel("pricesChannelPublisherMessage")
    Flow.Publisher<Message<Double>> priceChannelPublisherMessage;

    @GET
    @Path("/prices")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<Double> stream() {
        System.out.println("Option 4 - inject a `Multi` | your bean + subscribe to its events - Multi - Price: " + prices);
        // explicit subscription
        return prices;
    }

    @GET
    @Path("/channelMessage")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<Message<Double>> streamByMultiMessage() {
        System.out.println("Option 4 - inject a `Multi` | your bean + subscribe to its events - MultiMessage - Price: " + priceChannelMessage);
        // explicit subscription
        return priceChannelMessage;
    }

    @GET
    @Path("/channelPublisher")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Flow.Publisher<Double> streamByPublisher() {
        System.out.println("Option 4 - inject a `Multi` | your bean + subscribe to its events - Publisher - Price: " + priceChannelPublisher);
        // explicit subscription
        return priceChannelPublisher;
    }

    @GET
    @Path("/channelPublisherMessage")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Flow.Publisher<Message<Double>> streamByPublisherMessage() {
        System.out.println("Option 4 - inject a `Multi` | your bean + subscribe to its events - PublisherMessage - Price: " + priceChannelPublisherMessage);
        // explicit subscription
        return priceChannelPublisherMessage;
    }
}
