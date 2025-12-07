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
* `bash prove-event-loops.sh`
  * check sh execution logs / FEW threads used

## Quarkus' provided development models
### Imperative model
* [ImperativeResource](src/main/java/org/acme/ImperativeResource.java)
* `sh test-imperative.sh`
  * check logs / FIRSTLY ALL "BLOCKED" & AFTERWARDS, "UNBLOCKED"
    * == blocking

### Reactive model
* [ReactiveResource](src/main/java/org/acme/ReactiveResource.java)
* `bash test-reactive.sh`
  * Problems:
    * Problem1: NOT reach === Thread Analysis ===
      * Solution: TODO:

### Virtual threads (JDK 21+)
* [VirtualThreadResource](src/main/java/org/acme/VirtualThreadResource.java)
* `bash test-virtual-threads.sh`
  * Problems:
    * Problem1: Stay forever in "Sending 1000 requests..."
      * Solution: TODO:

## TODO:


