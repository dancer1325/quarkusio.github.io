* `quarkus create`
  * Problems:
    * Problem1: "Unable to create project: Failed to resolve the Quarkus extension registry descriptor of registry.quarkus.io from registry.quarkus.io (https://registry.quarkus.io/maven)"
      * Attempt1: `rm -rf ~/.m2/repository/io/quarkus`
      * Attempt2: | ".m2/settings.xml", add
      
        ```
        <repository>
          <id>registry.quarkus.io</id>
          <name>Quarkus community extension registry</name>
          <url>https://registry.quarkus.io/maven</url>
          <snapshots>
            <enabled>true</enabled>
            <updatePolicy>daily</updatePolicy>
            <checksumPolicy>warn</checksumPolicy>
          </snapshots>
        </repository>
        ```
      * Attempt3: | ".m2/settings.xml", add
        * `<mirrorOf>*,!registry.quarkus.io</mirrorOf>` 
        * `<mirrorOf>external:*,!registry.quarkus.io</mirrorOf>`
      * Workaround: 💡`quarkus create -P io.quarkus.platform:quarkus-bom:3.22.3`💡
      * Solution: TODO:

# | classic Java frameworks
* [springBoot](springBoot)

# Quarkus BOM
* [here](code-with-quarkus/pom.xml)'s 1! `<dependencyManagement>`

# `quarkus-maven-plugin`
* [here](code-with-quarkus/pom.xml)'s `build.plugins[0]`

# `io.quarkus:quarkus-rest`
* [here](code-with-quarkus/pom.xml)'s `<dependency>`
