* Quarkus
  * provides , -- via -- build-time optimizations + reactive core,
    * fast startup times
    * high throughput,
    * low response latency,
    * reduced memory footprint,
    * minimal resource consumption

* [build-time principle](container-first.md#build-time-processing)

* Quarkus' 
  * core == reactive
    * -- via -- engine
      * efficient asynchronous
      * non-blocking
      * -- based on -- Netty & Eclipse Vert.x
    * == 💡few event loops💡
      * ⚠️!= large thread pool⚠️
      * -> optimize hardware behavior ->
        * reduce resource usage
        * improve response times
    * ❌!= you MUST write reactive code❌
      * _Example:_ imperative model
  * provided development models
    * Imperative model
      * == traditional synchronous approach / faster execution
        * Reason:🧠thanks to optimized I/O layer🧠
      * use cases
        * lower concurrency
      * if high concurrency -> increases memory use
    * Reactive model
      * == asynchronous, non-blocking code
      * enables
        * high concurrency / minimal resources
      * cons
        * MORE complex | implement and debug
    * Virtual threads (JDK 21+)
      * benefits == imperative model's benefits + reactive models' benefits
        * imperative code can run | lightweight virtual threads /
          * high concurrency
          * low memory overhead
          * some limitations

* build time principle + reactive core
  * pros
    * Reduced Memory
      * Reason:🧠
        * build-time principle -> less JMV heap
        * reactive -> less thread stacks🧠
    * Fast Startup Time
      * use cases
        * traffic / pretty variable (== ups & downs)
    * High Throughput
    * Optimized Resource Consumption (CPU, memory)

* Continuously Measuring, Continuously Improving
  * [one of the most efficient frameworks -- for -- developing cloud-ready applications](https://www.techempower.com/benchmarks/#hw=ph&test=fortune&section=data-r22&c=e&f=0-0-0-0-0-0-0-0-0-2-4zsow-0-0-0-0&l=5181v-6bl)

* ["Reactive CRUD Performance: A Case Study" Blog Post](https://quarkus.io/blog/reactive-crud-performance-case-study/)
* ["Measuring Performance" guide](https://quarkus.io/guides/performance-measure)
