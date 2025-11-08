package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class InjectExampleService {

    // 4. | injected field declaration / NO qualifiers
    //      MANDATORY
    @Inject
    MetricsService metricsService;

    // 3. | injected field declaration / qualifiers
    //      OPTIONAL
    @Inject
    // TODO:    Why @Default is NOT working?
    @Named("default")
    DatabaseService database;

    @ConfigProperty(name = "app.timeout")
    String timeout;
    
    @Named("primary")
    DatabaseService primaryDatabase;

    @Inject @Named("secondary")
    DatabaseService backupDatabase;

    private LogService logService;
    private CacheService cacheService;

    // 1. | constructor injection,
    //       @Inject is MANDATORY
    @Inject
    public InjectExampleService(LogService logService) {
        this.logService = logService;
    }

    // 2. | method injection,
    //       @Inject is MANDATORY
    @Inject
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void doSomething() {
        logService.log("Using database: " + database.getName());
        logService.log("Timeout: " + timeout);
        logService.log("Primary DB: " + primaryDatabase.getName());
        logService.log("Backup DB: " + backupDatabase.getName());
        logService.log("Metric name: " + metricsService.getMetricName());
    }
}
