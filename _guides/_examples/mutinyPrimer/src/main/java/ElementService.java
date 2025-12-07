import com.mongodb.client.result.InsertOneResult;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ElementService {

    final ReactiveMongoCollection<Element> collection;

    @Inject
    ElementService(ReactiveMongoClient client) {
        collection = client.getDatabase("quarkus")
                .getCollection("elements", Element.class);
    }

    public void add(Element element) {
        Uni<InsertOneResult> insertion = collection.insertOne(element);
        insertion
                .onItem().transform(r -> r.getInsertedId().asString())
                .subscribe().with(
                        result -> System.out.println("inserted " + result),
                        failure -> System.out.println("D'oh" + failure));
    }

    public void getAll() {
        collection.find()
                .subscribe().with(
                        element -> System.out.println("Element: " + element),
                        failure -> System.out.println("D'oh! " + failure),
                        () -> System.out.println("No more elements")
                );
    }
}
