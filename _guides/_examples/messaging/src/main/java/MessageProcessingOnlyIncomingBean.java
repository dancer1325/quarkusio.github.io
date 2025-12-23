import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class MessageProcessingOnlyIncomingBean {
    @Incoming("source")
    public void process(String consumedPayload) {
        // process the payload
        consumedPayload.toUpperCase();
    }
}
