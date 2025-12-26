import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class MessageProducer {

    private final Random random = new Random();

    @Outgoing("payload")
    public Multi<Message<String>> generateSource() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(3))
                .map(tick -> {
                    String[] items = {"hello", "world", "quarkus", "messaging"};
                    String item = items[(int) (tick % items.length)];
                    System.out.println("Source producing Message with payload: " + item);
                    return Message.of(item);        // 5.       1 Message / EACH payload
                });
    }

    // 3. `<T>` can be arbitrary objects
    @Outgoing("custom-channel")
    public Multi<Message<CustomData>> generateCustomMessages() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(2))
                .map(tick -> {
                    CustomData data = new CustomData();
                    data.name = "Item-" + tick;
                    data.value = (int) (tick * 10);

                    return Message.of(data);
                });
    }

    @Outgoing("async-actions-toAckOrNack")
    public Multi<Message<Double>> generateMessagesToAckOrNack() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(2))
                .map(tick -> {
                    return Message.of(random.doubles().sum());
                });
    }
}
