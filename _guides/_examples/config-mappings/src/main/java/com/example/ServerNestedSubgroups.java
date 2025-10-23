package com.example;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "servernestedsoubgroups")
public interface ServerNestedSubgroups {
    String host();

    int port();

    Log log();

    // log      == sub-namespace -- to the -- configurations properties
    interface Log {
        boolean enabled();

        String suffix();

        boolean rotate();
    }
}
