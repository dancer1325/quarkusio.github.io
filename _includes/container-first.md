* Quarkus' container-first philosophy
  * == low memory usage & fast startup times

    ![](/quarkusio.github.io/assets/images/container/build-time-principle-light.png)

# Build Time Processing
* 💡Quarkus' 
  * build-time == traditional frameworks' runtime💡
    * configuration parsing,
    * classpath scanning,
    * feature toggle -- based on -- classloading
    * prepares ALL components initialization / -- used by -- your application
    * ...
  * runtime
    * 👀ONLY contains the classes / used 👀
    * [->](performance.md)
      * faster startup time
      * less memory usage

# Use less Reflection
* | build-time processing,
  * extensions 
    * analyze the application code & classes AVAILABLE | classpath
    * use regular invocations (❌NOT reflection calls❌) 
    * use generating custom proxy
      * == ❌NOT dynamic proxies❌ 

* Arc
  * == dependency injection framework used by Quarkus,
  * eliminates ALL reflection calls
    * Reason:🧠injection graph is deduced | build time🧠
    * -> | bootstrap the application,
      * ❌NO expensive lookups❌

# First-Class Support -- for -- GraalVM Native Images
* == 👀application is compiled down -- to a -- native executable👀 
* ->
  * starts faster
  * 's heap << standard JVM's heap
* TODO: The native compiler uses aggressive dead-code elimination techniques to only embed the parts of the JVM and classes that are absolutely required by your application
* Quarkus makes building optimized native executables plain easy
* The build-time approach allows Quarkus to collect enough metadata on your application to fine-tune the compilation
* No <code>-H:+ReportUnsupportedElementsAtRuntime</code> flag, no fallback, no compromise!</p>

# Native Image Pre-Boot
* We pre-boot as many of the frameworks as possible during the native compilation of a Quarkus application
* It means that the resulting native executable has already run most of the startup code and serialized the result into the executable: even faster startup!</p>

# Kubernetes, but also bare metal</h2>
* All the techniques allowing reducing the memory usage and provide faster startup times are not only advantageous in containers
* Even on bare metal, it would reduce your memory pressure, and it’s always pleasant to not have to wait 10 seconds to see your application running.</p>
* When Quarkus was designed, we didn’t focus only on containers but also on deploying Quarkus applications on container orchestrators such as Kubernetes
* Quarkus build-time processing also generates the Kubernetes metadata, so your application is ready to be deployed on Kubernetes
* Runtime capabilities such as health checks and metrics are exposed out of the box
* Quarkus collects all the required metadata at build time to create the Kubernetes deployment descriptor and produce a container image
* A single command line can deploy your application onto your Kubernetes cluster.</p>
