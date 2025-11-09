https://quarkus.io/kubernetes-native/

* Quarkus applications
  * 👀' design
    * run | container👀
  * are -- Reason:🧠due to its design 🧠 --
    * scalable
    * fast
    * lightweight
  * benefit
    * increase developer productivity
      * Reasons:🧠
        * tooling, 
        * pre-built integrations,
        * application services,
        * ...🧠
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
<h3>Application Configuration</h3>
      <p>Quarkus includes an extension that allows developers to use Kubernetes ConfigMaps and Secrets as a configuration source, without having to mount them into the Pod running the Quarkus application or make any other modifications to their Kubernetes Deployment (or Openshift DeploymentConfig) <a href="{{site.baseurl}}/guides/kubernetes-config">Read the guide for more details.</a></p>
      
# Remote Development
<h3>Remote Development</h3>
      <p>Create and debug applications in the same environment where applications run. Live coding in development mode where any changes made locally will be immediately visible in a clustered Kubernetes environment. <a href="https://developers.redhat.com/blog/2021/02/11/enhancing-the-development-loop-with-quarkus-remote-development">Read this blog post for greater insight.</a></p>
