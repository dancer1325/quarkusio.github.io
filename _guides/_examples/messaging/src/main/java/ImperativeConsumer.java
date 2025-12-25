import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ImperativeConsumer {

    @Incoming("imperatives")
    public void consume(double price) {
        System.out.println("imperatives - Received price: " + price);
    }

    @Incoming("imperativesMessage")
    public void consumeMessage(double price) {
        System.out.println("imperativesMessage - Received price: " + price);
    }

    @Incoming("imperativesMutiny")
    public void consumeMutiny(double price) {
        System.out.println("imperativesMutiny - Received price: " + price);
    }
}
