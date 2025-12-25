package org.acme;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PriceProducer {

    private Random random = new Random();

    @Outgoing("price-producer")
    public Multi<Double> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> {
                    double price = random.nextDouble() * 100;
                    System.out.println("Sending price: " + price);
                    return price;
                });
    }

    @Outgoing("price-producer-ToAck")
    public Multi<Double> generateToAck() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> {
                    double price = random.nextDouble() * 100;
                    System.out.println("Sending price: " + price);
                    return price;
                });
    }

    @Outgoing("price-producer-ToAckDefault")
    public Multi<Double> generateToAckDefault() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .map(tick -> {
                    double price = random.nextDouble() * 100;
                    System.out.println("Sending price: " + price);
                    return price;
                });
    }

    @Outgoing("pricesFifth-producer")
    public Multi<Double> generateFifth() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(3))
                .map(tick -> {
                    double price = random.nextDouble() * 50;
                    System.out.println("Sending pricesFifth: " + price);
                    return price;
                });
    }

    @Outgoing("pricesSecond-producer")
    public Multi<Double> generateSecond() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(4))
                .map(tick -> {
                    double price = random.nextDouble() * 75;
                    System.out.println("Sending pricesSecond: " + price);
                    return price;
                });
    }

    @Outgoing("pricesSecond-producer-ToAck")
    public Multi<Double> generateSecondToAck() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(4))
                .map(tick -> {
                    double price = random.nextDouble() * 75;
                    System.out.println("Sending pricesSecond: " + price);
                    return price;
                });
    }

    @Outgoing("pricesThird-producer")
    public Multi<Double> generateThird() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(6))
                .map(tick -> {
                    double price = random.nextDouble() * 25;
                    System.out.println("Sending pricesThird: " + price);
                    return price;
                });
    }

    @Outgoing("pricesThird-producer-ToAck")
    public Multi<Double> generateThirdToAck() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(6))
                .map(tick -> {
                    double price = random.nextDouble() * 25;
                    System.out.println("Sending pricesThird: " + price);
                    return price;
                });
    }

    // comment to see that it's required
    @Outgoing("pricesFourth-producer")
    public Multi<Double> generateFourth() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(7))
                .map(tick -> {
                    double price = random.nextDouble() * 150;
                    System.out.println("Sending pricesFourth: " + price);
                    return price;
                });
    }

    @Outgoing("pricesFourth-producer-ToAck")
    public Multi<Double> generateFourthToAck() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(7))
                .map(tick -> {
                    double price = random.nextDouble() * 150;
                    System.out.println("Sending pricesFourth: " + price);
                    return price;
                });
    }

    @Outgoing("pricesFifth-producer-ToAck")
    public Multi<Double> generateFifthToAck() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(7))
                .map(tick -> {
                    double price = random.nextDouble() * 150;
                    System.out.println("Sending pricesFifth: " + price);
                    return price;
                });
    }
}
