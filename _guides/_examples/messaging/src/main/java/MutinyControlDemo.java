import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
@Path("/control")
public class MutinyControlDemo {

    @Channel("control-channel")
    Emitter<String> regularEmitter;

    @Channel("mutiny-channel")
    MutinyEmitter<String> mutinyEmitter;

    // 1. Regular Emitter - Limited control
    @POST
    @Path("/regular")
    public CompletionStage<Void> sendRegular(@QueryParam("msg") String message) {
        System.out.println("Regular Emitter - Sending: " + message);
        // limited
        //      NO direct control about success/failure
        return regularEmitter.send(message);
    }

    // 2. MutinyEmitter
    // 2.1 MORE control
    // 2.1.1 async
    @POST
    @Path("/mutiny-async")
    public String sendMutinyAsync(@QueryParam("msg") String message) {
        System.out.println("Mutiny Emitter - Async send: " + message);
        
        // ⚠️MORE control: Fire and forget with callback⚠️
        mutinyEmitter.send(message)
            .subscribe().with(
                unused -> System.out.println("✅ Successfully sent: " + message),
                failure -> System.err.println("❌ Failed to send: " + message + " - " + failure.getMessage())
            );
        
        return "Message sent asynchronously with callbacks";
    }

    // 2.1.2 sync
    @POST
    @Path("/mutiny-blocking")
    public String sendMutinyBlocking(@QueryParam("msg") String message) {
        System.out.println("Mutiny Emitter - Blocking send: " + message);
        
        try {
            // MORE control: synchronous -- by -- blocking the thread
            mutinyEmitter.sendAndAwait(message);
            System.out.println("✅ Blocking send completed for: " + message);
            return "Message sent and confirmed";
        } catch (Exception e) {
            System.err.println("❌ Blocking send failed: " + e.getMessage());
            return "Message failed: " + e.getMessage();
        }
    }
}
