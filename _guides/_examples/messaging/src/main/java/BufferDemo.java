import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
@Path("/buffer")
public class BufferDemo {

    @Channel("buffered-channel")
    @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 10)
    Emitter<String> bufferedEmitter;

    @POST
    @Path("/send")
    @Consumes(MediaType.TEXT_PLAIN)
    public CompletionStage<Void> sendToBuffer(String message) {
        System.out.println("Sending to buffer: " + message + " (hasRequests: " + bufferedEmitter.hasRequests() + ")");
        return bufferedEmitter.send(message);
    }

    @POST
    @Path("/sendMultiple")
    public String sendMultiple() {
        System.out.println("=== Sending multiple messages rapidly ===");
        bufferedEmitter.send("Message 1");
        System.out.println("Sent Message 1 (hasRequests: " + bufferedEmitter.hasRequests() + ")");
        
        bufferedEmitter.send("Message 2");
        System.out.println("Sent Message 2 (hasRequests: " + bufferedEmitter.hasRequests() + ")");
        
        bufferedEmitter.send("Message 3");
        System.out.println("Sent Message 3 (hasRequests: " + bufferedEmitter.hasRequests() + ")");
        
        return "Sent 3 messages";
    }
}
