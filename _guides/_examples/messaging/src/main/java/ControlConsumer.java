import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ControlConsumer {

    @Incoming("control-channel")
    public void consumeControl(String message) {
        System.out.println("Regular channel received: " + message);
    }

    @Incoming("mutiny-channel")
    public void consumeMutiny(String message) {
        System.out.println("Mutiny channel received: " + message);
        // Simulate occasional failure to see error handling
        if (message.contains("fail")) {
            throw new RuntimeException("Simulated processing failure");
        }
    }
}
