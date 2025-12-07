package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/reactive")
public class ReactiveResource {

    private static final AtomicInteger requestCounter = new AtomicInteger(0);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // Uni<String>      ==      async method
    public Uni<String> nonBlocking() {
        int requestId = requestCounter.incrementAndGet();
        String startThread = Thread.currentThread().getName();
        
        System.out.println("[Request " + requestId + "] START on thread: " + startThread + " - NOT BLOCKED");
        
        // async delay - NOT block the thread
        return Uni.createFrom().item(() -> {
            String endThread = Thread.currentThread().getName();
            System.out.println("[Request " + requestId + "] END on thread: " + endThread + " - SAME EVENT LOOP");
            return "Reactive (NON-BLOCKING) - Request " + requestId + " - Thread: " + endThread;
        }).onItem().delayIt().by(Duration.ofSeconds(2));
    }
}
