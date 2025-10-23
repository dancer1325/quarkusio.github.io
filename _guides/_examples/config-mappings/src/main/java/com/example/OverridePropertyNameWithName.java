package com.example;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "overridepropertynamewithname")
public interface OverridePropertyNameWithName {
    @WithName("name")
    String host();

    int port();
}
