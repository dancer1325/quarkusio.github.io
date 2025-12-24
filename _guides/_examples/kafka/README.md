# kafka

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## How has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 kafka --extension=messaging-kafka, rest`
  * includes
    * MyMessagingApplication.java & SOME application.properties configurations

## how to configure SmallRye Kafka Connector?
### broker location
#### ways
##### globally -- `kafka.bootstrap.servers` --
* [application.properties](src/main/resources/application.properties)
##### / channel -- `mp.messaging.incoming.$channel.bootstrap.servers` --
* [application.properties](src/main/resources/application.properties)
### configure connector -- `mp.messaging.incoming.channelName.connector=smallrye-kafka` --
* [application.properties](src/main/resources/application.properties)
#### if you have 1! connector | your classpath -> you can omit it
* [PriceConsumer.java](src/main/java/org/acme/PriceConsumer.java)'s "pricesFifth"
* omitted `mp.messaging.incoming.pricesFifth.connector` | [application.properties](src/main/resources/application.properties)
* [run properly](#how-to-run)
##### if you want to disable it -> `quarkus.messaging.auto-connector-attachment=false`
* [PriceConsumer.java](src/main/java/org/acme/PriceConsumer.java)'s "pricesFifth"
* omitted `mp.messaging.incoming.pricesFifth.connector` | [application.properties](src/main/resources/application.properties)
* `quarkus.messaging.auto-connector-attachment=false` | [application.properties](src/main/resources/application.properties)
* [❌run does NOT work❌](#how-to-run)

## ways to receive messages -- from -- Kafka
* [PriceConsumer.java](src/main/java/org/acme/PriceConsumer.java)
* [PriceResource.java](src/main/java/org/acme/PriceResource.java)
* [application.properties](src/main/resources/application.properties)
* [run it](#how-to-run) 
  * check the logs

## how to run?

* | [infra](infra)
  * `docker compose up -d`
* | here
  * `./mvnw quarkus:dev`



## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/kafka-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging

## Provided Code

### Messaging codestart

Use Quarkus Messaging

[Related Apache Kafka guide section...](https://quarkus.io/guides/kafka-reactive-getting-started)

