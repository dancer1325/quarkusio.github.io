# Creating a new project
## ALLOWED attributes
```shell
mvn io.quarkus.platform:quarkus-maven-plugin:3.6.0:create \
    -DprojectGroupId=com.example \
    -DprojectArtifactId=maven-tooling-create \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DplatformGroupId=io.quarkus.platform \
    -DplatformArtifactId=quarkus-bom \
    -DplatformVersion=3.6.0 \
    -DjavaVersion=21 \
    -DclassName=com.example.HelloResource \
    -Dpath=/hello \
    -Dextensions=resteasy-reactive \
    -DquarkusRegistryClient=false
```
* [output](maven-tooling-create)
## `io.quarkus.platform:quarkus-bom` is the default target
* [here](maven-tooling-1/pom.xml)'s `dependencyManagement.dependencies.dependency`
## SEVERAL Dockerfiles
###  are generated
* [here](maven-tooling-create/src/main/docker)
### -- for -- native mode, jvm mode
* check the DIFFERENT names

# Dealing with extensions
## list the AVAILABLE extensions
* `./mvnw quarkus:list-extensions`
## list installed extensions | your Quarkus application
* `./mvnw quarkus:list-extensions -Dinstalled`
## add an extension
* `./mvnw quarkus:add-extension -Dextensions='hibernate-validator,quarkus-spring-cache'`
### way to specify the extension
#### `groupId:artifactId:name`
* `./mvnw quarkus:add-extension -Dextensions='io.quarkiverse.opentracing:quarkus-smallrye-opentracing:1.0.0'`
#### partially
* `./mvnw quarkus:add-extension -Dextensions='opentracing'`
#### globbing pattern
* `./mvnw quarkus:add-extension -Dextensions='smallrye-*'`


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