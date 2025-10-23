package com.example;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;

@ConfigMapping(prefix = "overridePropertyNameWithParentName")
public interface OverridePropertyNameWithParentName {
    String test();

    @WithParentName
    ServerHostAndPort hostAndPort();

    @WithParentName
    ServerInfo info();
}
