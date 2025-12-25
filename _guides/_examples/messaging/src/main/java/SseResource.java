import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

@ApplicationScoped
@Path("/")
public class SseResource {
    @Channel("prices")
    Multi<Double> prices;   // Multi  ==    stream of messages

    @GET
    @Path("/prices")
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<Double> stream() {
        return prices;
    }
}
