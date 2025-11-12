# container-first

## how has it been created?
* `quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3 container-first`

## Build Time Processing
### Quarkus' build-time
#### configuration parsing
* | [configPropertyParsing.txt](configPropertyParsing.txt), you can find
  * steps
    * load ConfigSource
      * "[io.smallrye.config] (main) SRCFG01006: Loaded ConfigSource"
    * process the configuration
      * "[DEBUG] [io.quarkus.builder] (build-"
    * generate the configuration
      * "[io.quarkus.builder] Starting step "io.quarkus.deployment.steps.ConfigGenerationBuildStep"
    * transform configuration' annotations
      * "[DEBUG] [io.quarkus.arc.processor.Transformation] Annotations of"
  * generated -- via -- `./mvnw clean package -X | grep -i "config\|property\|parsing" > configPropertyParsing.txt`
#### classpath scanning
* | [classpathScanning.txt](classpathScanning.txt)
  * "io.smallrye:jandex"
  * "[io.quarkus.bootstrap.classloading.QuarkusClassLoader"
  * "io.quarkus.bootstrap.classloading.PathTreeClassPathElement"
  * "<dependenciesToScan>"
  * generated -- via -- `./mvnw clean package -X | grep -i "index\|scan\|jandex\|class.*loading" > classpathScanning.txt`
#### feature toggle -- based on -- classloading
* | [configPropertyParsing.txt](configPropertyParsing.txt), you can find
  * steps
    * ALL [configuration parsing's steps](#configuration-parsing)
    * "Removed unused PRODUCER METHOD"
#### prepares ALL components initialization / -- used by -- your application
* | [configPropertyParsing.txt](configPropertyParsing.txt), you can find
  * steps
    * " Created "
      * == create beans & components
    * "Unremovable - injected:"
      * == prepare injection graph
    * "Removed unused "
      * == remove NOT used components
    * "[io.quarkus.arc.processor.Transformation]"
      * == transform annotations
    * "io.quarkus.deployment.index"
      * == index classes
    * "Starting step"
      * specific build steps
    * "io.quarkus.arc.processor.BeanArchives"
      * configure components
### Quarkus' run time
#### ONLY contains the classes / used
* `jar -tf target/quarkus-app/app/container-first-1.0.0-SNAPSHOT.jar`
  * ⚠️ONLY contains the used classe⚠️
* `ls target/quarkus-app/lib/main/`
  * dependencies
* | [configPropertyParsing.txt](configPropertyParsing.txt), you can find
  * "Removed unused"

## Use less Reflection
## | build-time processing,
### extensions
#### use regular invocations (❌NOT reflection calls❌)
* `sh check-reflection-usage.sh`
  * barely reflection calls
#### use generating custom proxy
* TODO:

## Kubernetes, but also bare metal
* | [pom.xml](pom.xml),
  * add
    ```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-kubernetes</artifactId>
    </dependency>
    ```
### | Quarkus build-time
#### generates the Kubernetes metadata
* `./mvnw clean package -DskipTests`
* check 'targets/kubernetes'
### runtime capabilities
#### are exposed out of the box
* | [pom.xml](pom.xml)
  * add
    ```xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-smallrye-health</artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-micrometer-registry-prometheus</artifactId>
    </dependency>
    ```
* [run it](#running-the-application-in-dev-mode)
  * http://localhost:8080/q/health
  * http://localhost:8080/q/metrics

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

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

You can then execute your native executable with: `./target/container-first-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
