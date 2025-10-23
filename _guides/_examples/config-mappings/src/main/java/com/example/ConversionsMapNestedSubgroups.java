package com.example;

import io.smallrye.config.ConfigMapping;
import java.util.Map;

@ConfigMapping(prefix = "conversionsMapNestedSubgroups")
public interface ConversionsMapNestedSubgroups {
    Map<String, ServerInfo> allServers();
}
