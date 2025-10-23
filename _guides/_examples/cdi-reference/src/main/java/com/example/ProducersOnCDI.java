package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

public class ProducersOnCDI {
    @Inject
    @ConfigProperty(name = "cool")
    String coolProperty;

    // @Produces            ALWAYS required
    @Produces
    @ApplicationScoped
    MyService produceService() {
        return new MyService(coolProperty);
    }
}
