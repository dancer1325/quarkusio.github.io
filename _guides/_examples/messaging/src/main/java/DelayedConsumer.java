import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class DelayedConsumer {

    @Incoming("buffered-channel")
    @Blocking  // block WITHOUT impacting the event loop
    public void consumeAfterDelay(String message) throws InterruptedException {
        System.out.println("Consumer starting to process: " + message);
        Thread.sleep(5000); // Simulate slow processing - 5 seconds delay
        System.out.println("Consumer finished processing: " + message);
    }
}
