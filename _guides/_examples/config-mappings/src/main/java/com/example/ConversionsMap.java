package com.example;

import io.smallrye.config.ConfigMapping;
import java.util.Map;

@ConfigMapping(prefix = "conversionsMap")
public interface ConversionsMap {
    String host();

    int port();

    Map<String, String> form();
}
