import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class MessageProcessor {

    @Incoming("payload")
    @Outgoing("sinkpayload")
    public Message<String> process(Message<String> consumed) {      // 1. Message<String>      == wrap the payload
        System.out.println("Processing message: " + consumed.getPayload());
        
        // 2. .getMetadata()      -- add `Metadata` --
        consumed.getMetadata().forEach(metadata -> {
            System.out.println("Metadata: " + metadata.getClass().getSimpleName());
        });
        
        // Process the incoming message and return an updated message
        String processed = consumed.getPayload().toUpperCase();
        System.out.println("Processed result: " + processed);
        
        return consumed.withPayload(processed);
    }

    // Consumer for the processed messages
    @Incoming("sinkpayload")
    public void consumeProcessed(String message) {
        System.out.println("Final result: " + message);
    }

    @Incoming("custom-channel")
    public void consumeCustomData(Message<CustomData> message) {      // 3. `<T>` can be arbitrary objects
        CustomData payload = message.getPayload();
        System.out.println("Received: " + payload.name + " = " + payload.value);
    }

    @Incoming("async-actions-toAckOrNack")
    public CompletionStage<Void> consumeToAckOrNack(Message<Double> messageToAckOrNack) {
        double doubleNumber = messageToAckOrNack.getPayload();
        if (doubleNumber > 0) {
            return messageToAckOrNack.ack();  // 4. Built-in async ack
        }
        return messageToAckOrNack.nack(new IllegalArgumentException("Invalid number")); // 4. Built-in async nack
    }
}
