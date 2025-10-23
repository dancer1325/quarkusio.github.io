package com.example;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import java.util.Optional;

@StaticInitSafe
@ConfigMapping(prefix = "serverstaticinitsafe")
public interface ServerWithStaticInitSafe {
    String host();

    int port();

    // OPTIONAL -> NOT throw `NoSuchElementException`
    //      by default, Optional.empty
    Optional<String> address();
}
