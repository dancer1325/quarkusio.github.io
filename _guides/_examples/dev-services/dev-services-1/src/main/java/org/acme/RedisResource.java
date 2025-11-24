package org.acme;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/redis")
public class RedisResource {

    @Inject
    RedisDataSource redisDS;

    @GET
    @Path("/{key}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("key") String key) {
        ValueCommands<String, String> commands = redisDS.value(String.class);
        return commands.get(key);
    }

    @POST
    @Path("/{key}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String set(@PathParam("key") String key, String value) {
        ValueCommands<String, String> commands = redisDS.value(String.class);
        commands.set(key, value);
        return "OK";
    }
}
