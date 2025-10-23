package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class ProducersOnQuarkus {
    @Inject
    @ConfigProperty(name = "cool")
    String coolProperty;

    // scope annotation     -> you can skip `@Produces`
    @ApplicationScoped
    MyService produceService() {
        return new MyService(coolProperty);
    }
}
