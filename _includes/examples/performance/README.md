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
## == few event loops
* TODO:
## TODO:

* TODO:

