package my.groupId;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
//asldofjasldkfhalsdhflajsdhjfa::;;!!       -- uncomment to see reflected the error
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello frsssssom Quarkus REST";
    }       // modify it / see reflected the hot reload
}
