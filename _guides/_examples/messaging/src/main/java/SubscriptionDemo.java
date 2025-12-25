import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.resteasy.reactive.RestStreamElementType;

@ApplicationScoped
@Path("/subscription")
public class SubscriptionDemo {

    // @Channel - Manual subscription (lazy)
    @Channel("demo-incoming")
    Multi<String> channelStream;    // by itself, NOTHING is consumed

    // Manual subscription -- via -- REST endpoint
    @GET
    @Path("/manual")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<String> manualSubscription() {
        System.out.println("📡 MANUAL (@Channel): Client subscribed to stream");

        // application code is responsible -- for -- returning the stream
        // ⚠️| connect the client, happens the subscription⚠️
        return channelStream.onItem().transform(message -> {
            System.out.println("📤 MANUAL (@Channel): Sending to client: " + message);
            return "Manual: " + message;
        });
    }

    // @Incoming - Automatic subscription (eager)
    @Incoming("demo-incoming")
    public void automaticConsumer(String message) {
        System.out.println("🤖 AUTOMATIC (@Incoming): " + message + " - consumed immediately");
    }


}
