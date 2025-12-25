import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;

@ApplicationScoped
public class DemoProducer {

    @Outgoing("demo-incoming")
    @Broadcast  // ⚠️enable MULTIPLE consumers (@Incoming + @Channel)⚠️
    public Multi<String> generateMessages() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(2))
                .map(tick -> {
                    String message = "Message-" + tick;
                    System.out.println("🔄 PRODUCER: Generated " + message);
                    return message;
                });
    }
}
