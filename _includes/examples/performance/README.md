# performance

## how has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 performance`

## Quarkus' core == reactive
### -- via -- engine
#### efficient asynchronous
* TODO:
#### non-blocking
* `sh verify-refactive-core.sh`
#### -- based on -- Netty & Eclipse Vert.x
* `./mvnw dependency:tree 2>/dev/null | grep "io.netty"`
* `./mvnw dependency:tree 2>/dev/null | grep "io.vertx"`
### == few event loops
* TODO:
### ❌!= you MUST write reactive code❌
* TODO:

## Quarkus' provided development models
### Imperative model
* [ImperativeResource](src/main/java/org/acme/ImperativeResource.java)
* `sh test-imperative.sh`
  * check logs / FIRSTLY ALL "BLOCKED" & AFTERWARDS, "UNBLOCKED"
    * == blocking

### Reactive model
* [ReactiveResource](src/main/java/org/acme/ReactiveResource.java)
  * asynchronous, non-blocking code
  * executes on event loop threads (`vert.x-eventloop-thread-X`)

### Virtual threads (JDK 21+)
* [VirtualThreadResource](src/main/java/org/acme/VirtualThreadResource.java)
  * imperative code on lightweight virtual threads
  * requires JDK 21+

## how to verify?
* `./mvnw quarkus:dev`
* test endpoints:
  * `curl http://localhost:8080/imperative`
  * `curl http://localhost:8080/reactive`
  * `curl http://localhost:8080/virtual`
* check thread names in responses

## TODO:


