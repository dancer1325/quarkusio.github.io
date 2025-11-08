package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("default")
public class DatabaseService {
    public String getName() {
        return "Default Database";
    }
}

@ApplicationScoped
@Named("primary")
class PrimaryDatabaseService extends DatabaseService {
    @Override
    public String getName() {
        return "Primary Database";
    }
}

@ApplicationScoped
@Named("secondary")
class SecondaryDatabaseService extends DatabaseService {
    @Override
    public String getName() {
        return "Secondary Database";
    }
}
