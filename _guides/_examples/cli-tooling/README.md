# Using the CLI
## `quarkus create`
### by default
* `quarkus create`
  * Problems: 
    * Problem1: Unable to create project: Failed to resolve the Quarkus extension registry descriptor of registry.quarkus.io from registry.quarkus.io (https://registry.quarkus.io/maven)"
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
### OTHER commands
* `quarkus create app groupId:appId:version`
  * specify `artifactId` + `groupId:version`
  * Problems: 
    * Problem1: Unable to create project: Failed to resolve the Quarkus extension registry descriptor of registry.quarkus.io from registry.quarkus.io (https://registry.quarkus.io/maven)"
      * Solution: TODO:
  * [here](bar)
* `quarkus create app mine:bar2`
  * [here](bar2)
* `quarkus create app mine:coffee:2.0`
  * [here](coffee)
#### if you specify 1! -> it's `appId`
* `quarkus create app bar`
  * [here](bar)

## Specifying the Quarkus version
* `quarkus create app bom1 --platform-bom=io.quarkus.platform:quarkus-bom:3.29.3`
  * [here](bom1)
* `quarkus create app bom5 -P :quarkus-bom:`
  * [here](bom5)
### if you specify 1! segment (== NO `:`) -> it's the version
* `quarkus create app bom1 --platform-bom=3.29.3`
  * [here](bom2)
#### `io.quarkus.platform:quarkus-bom` == default groupId
* [here](bom2)
### `--dry-run` option
* `quarkus create app bom4 --dry-run`
### TODO:

## Working with extensions
* | [bom1](bom1)
### `quarkus ext --help`
### `quarkus ext ls`
* `quarkus ext ls --name`
* `quarkus ext ls --concise`
* `quarkus ext ls --full`
* `quarkus ext ls --origins`
#### -- for a -- Quarkus release
* `quarkus ext ls --platform-bom=io.quarkus.platform:quarkus-bom:3.29.3`

### `quarkus ext add extension1 extension2 ...`
* `quarkus ext add kubernetes health`
* `quarkus ext add smallrye-*`
  * add extensions / match a glob pattern
### `quarkus ext remove extension1`
* `quarkus ext remove kubernetes health`
## Build your project
* `quarkus build`
## Development mode
* `quarkus dev`
