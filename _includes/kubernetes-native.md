https://quarkus.io/kubernetes-native/

* Quarkus applications
  * == 💡Kubernetes-native framework💡
    * == [1! step deployments](#1-step-deployments) + [tracing & debugging](#tracing--debugging) + [application health & metrics](#application-health--metrics) + [remote development](#remote-development) 

# 1! step deployments
* Quarkus 
  * [Kubernetes extension](../_guides/deploying-to-kubernetes.adoc) makes it easy -- to -- deploy microservice applications | Kubernetes OR Kubernetes distributions
    * Reason:🧠WITHOUT having to understand Kubernetes framework🧠

# Tracing & Debugging
* Quarkus
  * provides
    * [tracing & debugging tools](../_guides/opentelemetry.adoc)

# Application Health & Metrics
* SmallRye Health
  * used by Quarkus
  * == implementation of the MicroProfile Health specification
  * provide
    * application's state to external viewers
  * [MORE](../_guides/smallrye-health.adoc) 

* [Micrometer](https://micrometer.io/)
  * used by Quarkus
  * == metrics library 
    * allows
      * exposing
        * runtime metrics
        * application metrics
  * provides
    * simple facade -- for -- the most popular monitoring systems
      * to instrument your JVM-based application code WITHOUT vendor lock-in
  * [MORE](../_guides/telemetry-micrometer.adoc)

# Application Configuration
* Quarkus extension
  * allows
    * use Kubernetes ConfigMaps and Secrets -- as a -- configuration source / WITHOUT mounting them MANUALLY
  * [MORE](../_guides/kubernetes-config.adoc)
      
# Remote Development
* create & debug applications | environment / applications run
* live coding | development mode /
  * any changes made locally will be IMMEDIATELY visible | clustered Kubernetes environment
* [MORE](https://developers.redhat.com/blog/2021/02/11/enhancing-the-development-loop-with-quarkus-remote-development)
