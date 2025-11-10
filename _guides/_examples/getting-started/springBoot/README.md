# build time
* `./mvnw clean package`
## == ALL actions /
### applied | your Java source files -- to convert them into -- something runnable (class files, jar/war, native images)
* `ls -all target`
## == compilation + annotation processing + bytecode generation + etc.
* `./mvnw package > logs.txt`
* | "logs.txt"
  * TODO:

# run time
## -- relies on a -- lot of technical actions
* `java -jar target/springBoot-0.0.1-SNAPSHOT.jar --debug 2>&1 | head -5000 > runtime-logs.txt & sleep 10 && kill $! 2>/dev/null`
* | [runtime-logs.txt](runtime-logs.txt), you can find
  * **loading libraries & configuration files**
    * "Loading source class org.example.springboot.Application"
    * "Published root WebApplicationContext as ServletContext attribute"
  * **scanning the application's classpath**
    * "@EnableAutoConfiguration was declared on a class in the package 'org.example.springboot'. Automatic @Repository and @Entity scanning is enabled."
    * "CONDITIONS EVALUATION REPORT" -- shows -- ALL auto-configuration classes evaluated
  * **configuring the dependency injection**
    * "Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext"
    * "Root WebApplicationContext: initialization completed in 466 ms"
  * **setting up components -- through -- reflection**
    * "Mapping filters: characterEncodingFilter urls=[/*]"
    * "Mapping servlets: dispatcherServlet urls=[/]"
    * "3 mappings in 'requestMappingHandlerMapping'"
    * "ControllerAdvice beans: 0 @ModelAttribute, 0 @InitBinder, 1 RequestBodyAdvice, 1 ResponseBodyAdvice"
  * **instantiating REST controllers**
    * "Starting Servlet engine: [Apache Tomcat/10.1.48]"
    * "Tomcat started on port 8080 (http) with context path '/'"
## MAIN problems
### delay the readiness of your application
* | [runtime-logs.txt](runtime-logs.txt), you can find
  * output: `Started Application in 1.XXX seconds`
  * ⚠️takes ~1-2 seconds BEFORE serving requests⚠️
### if you have a peak of resource consumption | bootstrap -> you will need to size the needed resources -- based on -- your technical bootstrap needs
* TODO:

