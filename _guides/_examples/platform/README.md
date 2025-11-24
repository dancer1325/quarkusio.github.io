# Quarkus Platform BOM
* [here](quarkusPlatformBOM.xml)
## requirements
### imports a chosen version of `io.quarkus:quarkus-bom`
* `dependencyManagement.dependencies.dependency`
#### OR flattened
* [here](quarkusPlatformBOMFlattened.xml)
## includes
### ALL Quarkus extension artifacts (runtime & deployment ones) / platform consists of
* check `dependencyManagement.dependencies.dependency`
### third-party artifacts / compatible BETWEEN ALL platform extensions' transitive dependency versions
* check `dependencyManagement.dependencies.dependency`
### platform JSON descriptor
* check `dependencyManagement.dependencies.dependency`

# Quarkus Platform Descriptor
* TODO:

# Quarkus Platform Properties
## steps
### create Quarkus Platform properties .xml 
* [platform-properties.xml](platform-properties.xml)
### | Quarkus Platform "pom.xml", add the dependency
* [quarkusPlatformBOM.xml](quarkusPlatformBOM.xml)'s `dependencies.dependency`
## hierarchy dominated -- by the -- application's "application.properties"
* [here](platform/README.md#applicationproperties-s-priority--platformproperties-s-priority)
## way / BOM makes the platform's default properties available -- to -- ALL applications / use that platform
* `dependencyManagement.dependencies.dependency`