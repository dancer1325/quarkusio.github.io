package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CacheService {
    public void cache(String key, Object value) {
        System.out.println("[CACHE] Storing: " + key + " = " + value);
    }
}
