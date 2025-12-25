package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class AckStrategyExamples {

    // POST_PROCESSING Ack after method completes
    @Incoming("pricesToAck")
    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
    public void postProcessingPayload(double price) {
        System.out.println("POST_PROCESSING payload: " + price);
        if (price > 80) {
            throw new RuntimeException("POST_PROCESSING: Price too high! " + price);
        }
        System.out.println("POST_PROCESSING: Successfully processed " + price);
    }

    @Incoming("pricesSecondToAck")
    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
    public CompletionStage<Void> postProcessingAsync(Message<Double> msg) {
        System.out.println("POST_PROCESSING async: " + msg.getPayload());
        // Message acked AFTER CompletionStage completes
        return msg.ack();
    }

    // POST_PROCESSING - default
    @Incoming("pricesToAckDefault")
    // @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)     -- comment to check that it's the default one
    public void postProcessingDefault(double price) {
        System.out.println("POST_PROCESSING default: " + price);
        if (price > 80) {
            throw new RuntimeException("POST_PROCESSING default: Price too high! " + price);
        }
        System.out.println("POST_PROCESSING default: Successfully processed " + price);
    }

    // PRE_PROCESSING - Ack immediately on arrival
    @Incoming("pricesThirdToAck")
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public void preProcessing(double price) {
        System.out.println("PRE_PROCESSING: " + price + " (already acked)");
        if (price > 60) {
            throw new RuntimeException("PRE_PROCESSING: Price too high! " + price + " (message lost!)");
        }
        System.out.println("PRE_PROCESSING: Successfully processed " + price);
    }

    // NONE - Never ack automatically
    @Incoming("pricesFourthToAck")
    @Acknowledgment(Acknowledgment.Strategy.NONE)
    public CompletionStage<Void> noneStrategy(Message<Double> msg) {
        System.out.println("NONE strategy: " + msg.getPayload() + " (manual ack control)");
        if (msg.getPayload() > 50) {
            System.out.println("NONE: Manually acking " + msg.getPayload());
            return msg.ack();
        } else {
            System.out.println("NONE: Manually nacking " + msg.getPayload());
            return msg.nack(new RuntimeException("Price too low"));
        }
    }

    // MANUAL - Never ack automatically
    @Incoming("pricesFifthToAck")
    @Acknowledgment(Acknowledgment.Strategy.MANUAL)
    public CompletionStage<Void> manualStrategy(Message<Double> msg) {
        System.out.println("MANUAL strategy: " + msg.getPayload() + " (manual ack control)");
        if (msg.getPayload() > 50) {
            System.out.println("MANUAL: Manually acking " + msg.getPayload());
            return msg.ack();
        } else {
            System.out.println("MANUAL: Manually nacking " + msg.getPayload());
            return msg.nack(new RuntimeException("Price too low"));
        }
    }
}
