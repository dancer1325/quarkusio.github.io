# containerImageJIB

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## How has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 containerImageJIB --extension=jib`

## allows
### perform container image builds
* `./mvnw package -Dquarkus.container-image.build=true`
  * Problems:
    * Problem1: "The supplied combination of container-image group 'dancer13' and name 'containerImageJIB' is invalid"
      * Solution: | "application.properties", `quarkus.container-image.name=jib`
        * Reason:🧠[docker image naming restrictions](https://pkg.go.dev/github.com/distribution/reference#pkg-overview)🧠
* `docker images | grep jib`
  * check the container image is built

## ALL the dependencies (| "target/lib") are cached | layer != actual application layer
* `docker history dancer13/jib:1.0.0-SNAPSHOT`
  * actual application layer life time != rest of layers life time

## ❌enable you NOT need to
### have a dedicated client side tooling / create a container image
* build the docker image / WITHOUT running docker
### run a daemon process
* build the docker image / WITHOUT running docker

## 