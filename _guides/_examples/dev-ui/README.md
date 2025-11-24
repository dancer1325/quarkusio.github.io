# Dev UI
## AVAILABLE | dev mode (== `mvn quarkus:dev`) | http://localhost:8080/q/dev-ui
* | [dev-ui-1](dev-ui-1)
  * `./mvnw quarkus:dev`
* | browser,
  * http://localhost:8080/q/dev-ui
## allows you, 
### view
#### ALL extensions
* http://localhost:8080/q/dev-ui/extensions
#### Dev services information
* http://localhost:8080/q/dev-ui/dev-services
#### Build information
* http://localhost:8080/q/dev-ui/configuration-form-editor
* http://localhost:8080/index.html
### change the configuration
* http://localhost:8080/q/dev-ui/configuration-form-editor
  * click & unclick
### manage Continuous Testing
* http://localhost:8080/q/dev-ui/continuous-testing
### stream various logs
* | [dev-ui-1](dev-ui-1)
  * `./mvnw quarkus:add-extension -Dextensions="logging-manager"`
* | http://localhost:8080/q/dev-ui/,
  * extensions > Logging Manager > adjust logging levels / packages
## vs Dev UI v2
* Dev UI
  * http://localhost:8080/q/dev/
* Dev UI v2
  * http://localhost:8080/q/dev-ui/

# Make my extension / extend the Dev UI
## ALL extensionS, by default, are listed | Dev UI
* | [dev-ui-1](dev-ui-1)
  * run it in dev mode
* http://localhost:8080/q/dev-ui/extensions
  * list ALL installed extensions WITHOUT configuration
