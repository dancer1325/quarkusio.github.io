import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
@Path("/")
public class MyImperativeBean {
    @Channel("imperatives")
    Emitter<Double> emitterPayload;

   /* @Channel("imperativesMessage")
    Emitter<Double> emitterMessage;*/

    //@Channel("imperatives")           // TooManyUpstreamCandidatesException
    @Channel("imperativesMutiny")
    MutinyEmitter<Double> mutinyEmitter;

    //@GET      -- NOT valid to send method's argument
    @POST
    @Path("/send")           // == HTTP endpoint
    @Consumes(MediaType.APPLICATION_JSON)
    public CompletionStage<Void> sendPayload(double d) {
        // send ONLY the payload
        return emitterPayload.send(d);     // produce messages
    }

    /*@POST
    @Path("/sendMessage")           // == HTTP endpoint
    @Consumes(MediaType.APPLICATION_JSON)
    public CompletionStage<Void> sendMessage(double d) {
        // send the message
        return emitterMessage.send(Message.of(d));     // TODO: Required type: CompletionStage<java.lang.Void>, Provided:void
    }*/

    //@GET      -- NOT valid to send method's argument
    @POST
    @Path("/sendmutiny")    // == HTTP endpoint
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMutiny(double d) {
        mutinyEmitter.sendAndAwait(d);      // produce messages
    }
}
