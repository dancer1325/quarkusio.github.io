package org.acme;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/virtual")
public class VirtualThreadResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RunOnVirtualThread     // virtual thread   == JDK 21+
    public String virtualThread() throws InterruptedException {
        // imperative code
        Thread.sleep(100);
        return "Virtual thread model - Thread: " + Thread.currentThread().getName() +
               " (isVirtual: " + Thread.currentThread().isVirtual() + ")";
    }
}
