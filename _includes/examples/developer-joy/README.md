# == cohesive platform /
* [cohesive-demo](cohesive-demo)
  * MULTIPLE extensions used & running great BETWEEN them
## easy generate a NATIVE executable
* `./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.native-image-xmx=2g -DskipTests`
  * 

# Quarkus features' goals
## works well
* | DIFFERENT scenarios
  * Dev mode
  * JVM mode
  * native mode
  * testing
## simple
* _Example:_ [database access](cohesive-demo/src/main/java/demo/ProductResource.java)
  * vs Spring

  ```java
  @Repository
  public class ProductRepository {
      @Autowired
      private EntityManager em;
      
      public List<Product> findAll() {
          return em.createQuery("SELECT p FROM Product p", Product.class)
                   .getResultList();
      }
      
      public Product save(Product product) {
          if (product.getId() == null) {
              em.persist(product);
          } else {
              em.merge(product);
          }
          return product;
      }
  }
  ```
## little or Zero configuration
* [application.properties](cohesive-demo/src/main/resources/application.properties) / 
  * configure MULTIPLE extensions
## intuitive
* _Example:_ features naming
  * `@QuarkusTest`

