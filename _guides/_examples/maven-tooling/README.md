# TODO:

# Development mode
## ways to run
* | [maven-tooling-1](maven-tooling-1)
  * `quarkus dev`, OR
  * `./mvnw quarkus:dev `
## enable
### hot deployment + background compilation
#### if you update code OR resources OR configurations -> AUTOMATICALLY reflected | your running application
* |[maven-tooling-1](maven-tooling-1)
  * [run it](#ways-to-run)
  * adjust some source code
  * hit again [sample.http](maven-tooling-1/sample.http)
  * reflected the change
#### if there are issues with compilation OR deployment -> error page -- will -- let you know
* |[maven-tooling-1](maven-tooling-1)
  * uncomment lines in [GreetingResource](maven-tooling-1/src/main/java/my/groupId/GreetingResource.java)
### enable Dev UI
* |[maven-tooling-1](maven-tooling-1)
  * [run it](#ways-to-run)
  * http://localhost:8080/q/dev-ui
## debug host
* TODO:

# TODO: