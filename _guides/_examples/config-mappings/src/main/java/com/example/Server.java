package com.example;

import io.smallrye.config.ConfigMapping;
import java.util.Optional;

@ConfigMapping(prefix = "server")
public interface Server {
    String host();

    int port();

    // OPTIONAL -> NOT throw `NoSuchElementException`
    //      by default, Optional.empty
    Optional<String> address();
}
