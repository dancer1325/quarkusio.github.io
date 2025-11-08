package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogService {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
