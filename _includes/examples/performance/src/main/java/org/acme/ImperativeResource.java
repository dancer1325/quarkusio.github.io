package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/imperative")
public class ImperativeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // String   == sync method
    public String blocking() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().threadId();
        
        System.out.println("[BEFORE SLEEP] Thread: " + threadName + " (ID: " + threadId + ") - BLOCKED");
        
        // blocks the server | 2"       == imperative model
        Thread.sleep(2000);
        
        System.out.println("[AFTER SLEEP] Thread: " + threadName + " (ID: " + threadId + ") - UNBLOCKED");
        
        return "Imperative (BLOCKING) - Thread: " + threadName + " stayed blocked for 2s";
    }
}
