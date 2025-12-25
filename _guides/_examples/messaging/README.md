# messaging

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## how has it been created?
`quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 kafka --extension=quarkus-resteasy-reactive, quarkus-resteasy-reactive-jackson`

## Emitters (`Emitter`) + `@Channel`
### allows
#### | imperative code, send messages -- to a -- specific channel
* [MyImperativeBean.java](src/main/java/MyImperativeBean.java)
* hit [sample.http](sample.http)
* | logs, look for ""imperatives " & "imperativesMutiny"
  * == sent -- to -- specific channel
### use case
#### application / message + other parts of the application
* [MyImperativeBean.java](src/main/java/MyImperativeBean.java)
  * == | HTTP endpoints, produce messages
### `@Channel`  
#### == channel |
##### send your payloads OR
* [MyImperativeBean.java](src/main/java/MyImperativeBean.java)'s `.sendPayload()`
* hit [sample.http](sample.http)
##### send your messages
* [MyImperativeBean.java](src/main/java/MyImperativeBean.java)'s `.sendMessage()`
  * TODO: it does NOT work
#### | consume messages / sent -- via -- `@Channel`
##### -> application code is responsible for subscribing | stream
###### == MANUAL subscription
* [run](#how-to-run--dev)
  * check logs and NOT find "MANUAL (@Channel):"
* hit [sample.http](sample.http)
###### != `@Incoming` (== AUTOMATIC)
* [run](#how-to-run--dev)
* check logs and find "AUTOMATIC (@Incoming):"
#### inject the stream of messages
* [SseResource](src/main/java/SseResource.java)
### `Emitter`
#### allows: buffering (== if there are NO consumers OR MULTIPLE -> keep the messages) messages / sent to the channel
* [run](#how-to-run--dev)
* hit [1.2.1.1](sample.http)
* check logs that it consume ALL
#### vs Mutiny APIs
##### Mutiny has MORE control
* [MutinyControlDemo.java](src/main/java/MutinyControlDemo.java) & [ControlConsumer.java](src/main/java/ControlConsumer.java)
  * check code
* hit [sample.http](sample.http)
* check logs

## how to run | dev?
* `./mvnw quarkus:dev`
  * Problems:
    * Problem1: "Please make sure there is only one provider of the following capabilities:
      capability io.quarkus.rest is provided by:
    - io.quarkus:quarkus-resteasy-reactive:3.6.4
    - io.quarkus:quarkus-resteasy:3.6.4"
      * Solution: remove 1 of those
