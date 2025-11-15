package demo;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    @Operation(summary = "Get all products")
    public List<Product> getAll() {
        return Product.listAll();
    }

    @POST
    @Transactional
    @Operation(summary = "Create a product")
    public Product create(Product product) {
        product.persist();
        return product;
    }
}
