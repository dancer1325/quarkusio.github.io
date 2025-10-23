package com.example;

import io.smallrye.config.WithParentName;

public interface OverridePropertyNameWithParentName {
    @WithParentName
    ServerHostAndPort hostAndPort();

    @WithParentName
    ServerInfo info();
}

interface ServerHostAndPort {
    String host();

    int port();
}

interface ServerInfo {
    String name();
}
