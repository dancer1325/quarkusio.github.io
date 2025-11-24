package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
public class ConfigResource {
    
    @ConfigProperty(name = "quarkus.http.port")
    String port;
    
    @ConfigProperty(name = "my.platform.setting")
    String setting;
    
    @GET
    public String getConfig() {
        return "Port: " + port + ", Setting: " + setting;
    }
}
