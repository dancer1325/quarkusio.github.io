# openTelemetry

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## How has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 openTelemetry --extension=rest,opentelemetry`

## create the configuration
### exporters
#### by default, 👀send out data in batches👀
* `docker compose up -d`
* `./mvnw quarkus:dev`
* `bash test-batching.sh`
* `docker-compose logs -f otel-collector`
  * you can see ""resource spans": 1, "spans": 10"      ==      -- via -- batch
##### -- via -- 
###### gRPC protocol
* TODO:
###### endpoint: `http://localhost:4317`
* TODO:
##### if you want spans & logs are exported DIRECTLY (== NOT batch) -> set `quarkus.otel.simple=true`
* TODO:

## Disable OpenTelemetry extension's ALL OR parts 
### TODO: 