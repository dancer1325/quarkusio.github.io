# Dev Services
## := unconfigured services / Quarkus -- can -- AUTOMATICALLY provision
* | [dev-services-1](dev-services-1)
  * `./mvnw quarkus:dev`
    * Problems:
      * Problem1:  "io.quarkus.arc.InactiveBeanException: Bean is not active: SYNTHETIC bean [class=io.agroal.api.AgroalDataSource, id=83v3mgZs1bc75ou7lAXNtJCAcLA]" 
        * Attempt1: | "application.properties", add 
          ```properties
          quarkus.devservices.enabled=true
          quarkus.log.category."io.quarkus.devservices".level=DEBUG
          ```
        * Attempt2: `export DOCKER_HOST=unix:///var/run/docker.sock`
        * Attempt3: `export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock`
        * Attempt4: `./mvnw quarkus:add-extension -Dextensions="redis-client"`
        * Solution: TODO:
## ALLOWED |
### development mode
* | [dev-services-1](dev-services-1)
  * `./mvnw quarkus:dev`
### test mode
* | [dev-services-1](dev-services-1)
  * `./mvnw quarkus:test`

# Using Dev Services
* TODO: