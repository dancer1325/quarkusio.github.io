package org.acme;

import io.smallrye.reactive.messaging.kafka.api.IncomingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import io.smallrye.reactive.messaging.kafka.Record;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class PriceConsumer {
    // 1. ways to receive messages -- from -- Kafka
    // 1.1 receive message payload DIRECTLY
    @Incoming("prices")
    public void consume(double price) {
        // process your price.
        System.out.println("Option 1 - receive message payload DIRECTLY - Received price: " + price);
    }

    // 1.2 access the incoming message metadata + handle MANUALLY the acknowledgment
    @Incoming("pricesSecond")
    public CompletionStage<Void> consume(Message<Double> msg) {
        // access record metadata
        var metadata = msg.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();
        // process the message payload.
        double price = msg.getPayload();
        System.out.println("Option 2 - access the incoming message metadata + handle MANUALLY the acknowledgment - Price: " + price + ", Topic: " + metadata.getTopic());
        // Acknowledge the incoming message (commit the offset)
        return msg.ack();
    }

    // 1.3 access the Kafka record objects DIRECTLY
    // 1.3.1 ConsumerRecord
    @Incoming("pricesThird")
    public void consume(ConsumerRecord<String, Double> record) {
        String key = record.key(); // Can be `null` if the incoming record has no key
        Double value = record.value(); // Can be `null` if the incoming record has no value
        String topic = record.topic();
        int partition = record.partition();
        System.out.println("Option 3.1 - ConsumerRecord - Price: " + value + ", Topic: " + topic + ", Partition: " + partition);
        // ...
    }
    // 1.3.2 Record
    @Incoming("pricesFourth")
    public void consume(Record<String, Double> record) {
        String key = record.key(); // Can be `null` if the incoming record has no key
        Double value = record.value(); // Can be `null` if the incoming record has no value
        System.out.println("Option 3.2 - Record - Price: " + value + ", Key: " + key);
    }

    // 2. if you have 1! connector | your classpath -> you can omit the configuration
    @Incoming("pricesFifth")
    public void consumeFifth(double price) {
        // process your price.
        System.out.println("consumeFifth - Received price: " + price);
    }
}
