package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MetricsService {
    public String getMetricName() {
        return "Default Metric";
    }
}
