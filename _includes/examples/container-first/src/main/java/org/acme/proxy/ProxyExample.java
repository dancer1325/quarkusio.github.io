package org.acme.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ProxyExample {

    @Produces
    public ServiceInterface createService() {
        // This would be the generated proxy class at build time
        // In reality, this would be injected by the extension
        return new ServiceInterface() {
            @Override
            public String process(String input) {
                return "Build-time generated proxy: " + input;
            }
        };
    }
}
