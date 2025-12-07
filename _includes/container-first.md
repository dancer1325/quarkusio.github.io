* Quarkus' container-first philosophy
  * == low memory usage & fast startup times

# Build Time Processing
* 💡Quarkus' 
  * build-time == traditional frameworks' runtime💡
    * == ⚠️the HIGHEST cost⚠️
    * happens 1! time
      * != EACH startup
    * steps / taken
      * configuration parsing,
      * classpath scanning,
      * feature toggle -- based on -- classloading
      * prepares ALL components initialization / -- used by -- your application
      * ...
  * runtime
    * 👀ONLY contains the classes / used 👀
    * [-> BETTER performance](performance.md)
      * faster startup time
        * -> reach FASTER the peak performance
      * less memory usage
        * Reason:🧠-- thanks to -- 
          * minimize allocations & class loading
          * replace reflection -- by -- build-time bytecode generation🧠
      * better latency & improved throughput
        * Reason:🧠
          * prunes unnecessary classes and methods
          * avoids MULTIPLE layers of indirection🧠

    ![](/quarkusio.github.io/assets/images/container/build-time-principle-light.png)

# Use less Reflection
* | build-time processing,
  * extensions 
    * [analyze the application code & classes AVAILABLE | classpath](#build-time-processing)
    * use regular invocations (❌NOT reflection calls❌) 
    * use generating custom proxy
      * == ❌NOT dynamic proxies❌ 

* [Arc](/quarkusio.github.io/_guides/cdi-integration.adoc)
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

* [Performance](performance.md)

# Native Image Pre-Boot
* | native compilation of a Quarkus application
  * pre-boot, as much as possible
    * _Example:_ CDI bean discovery, configuration binding,  reflection registration, proxy registration, ... 
    * == resulting native executable has ALREADY
      * run MOST of the startup code
      * serialized the result | executable

# Kubernetes, but also bare metal
* reduce the memory usage & provide faster startup times
  * profitable |
    * containers
    * bare metal

* Quarkus's original design
  * | 
    * containers &
    * container orchestrators

* | Quarkus build-time
  * 👀generates the Kubernetes metadata👀
    * Kubernetes deployment descriptor
    * produce a container image

* runtime capabilities (_Example:_ health checks and metrics)
  * are exposed out of the box

* `-Dquarkus.kubernetes.deploy=true`
  * 👀CL's command -- to -- deploy your application | your Kubernetes cluster 👀
  * [MORE](/quarkusio.github.io/_guides/deploying-to-kubernetes.adoc)
