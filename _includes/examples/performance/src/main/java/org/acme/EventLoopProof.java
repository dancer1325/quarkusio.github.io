package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/event-loop-proof")
public class EventLoopProof {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkEventLoop() {
        Thread thread = Thread.currentThread();
        boolean isEventLoop = io.vertx.core.Context.isOnEventLoopThread();
        
        return String.format(
            "Thread Name: %s\n" +
            "Thread ID: %d\n" +
            "Is Event Loop: %s\n" +
            "Thread Class: %s",
            thread.getName(),
            thread.getId(),
            isEventLoop,
            thread.getClass().getSimpleName()
        );
    }
}
