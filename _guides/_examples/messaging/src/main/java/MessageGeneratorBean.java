import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class MessageGeneratorBean {
    @Outgoing("sink")
    public Multi<String> generate() {
        return Multi.createFrom().items("a", "b", "c");
    }
}
