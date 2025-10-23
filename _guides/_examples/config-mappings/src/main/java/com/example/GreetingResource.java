package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Server server;

    @Inject
    ServerWithStaticInitSafe serverWithStaticInitSafe;

    @Inject
    ServerNestedSubgroups serverNestedSubgroups;

    @Inject
    ConversionsAutomaticallyAllMicroProfileConfig conversionsAutomaticallyAllMicroProfileConfig;

    @Inject
    ConversionsMap conversionsMap;

    @Inject
    OverridePropertyNameWithName overridePropertyNameWithName;

    @Inject
    OverridePropertyNameWithParentName overridePropertyNameWithParentName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String server = "server.host() " + this.server.host() + ", server.port() " + this.server.port() + ", + server.address() " + this.server.address();
        String serverWithStaticInitSafe = "serverWithStaticInitSafe.host() " + this.serverWithStaticInitSafe.host() + ", serverWithStaticInitSafe.port() " + this.serverWithStaticInitSafe.port() + ", + serverWithStaticInitSafe.address() " + this.serverWithStaticInitSafe.address();
        return "Hello from Quarkus REST - " + server + serverWithStaticInitSafe;
    }

    @GET
    @Path("/nestedsubgroup")
    @Produces(MediaType.TEXT_PLAIN)
    public String nestedsubgroup() {
        String serverNestedSubgroups = "serverNestedSubgroups.host() " +
                this.serverNestedSubgroups.host() +
                ", serverNestedSubgroups.port() " +
                this.serverNestedSubgroups.port() +
                ", + serverNestedSubgroups.log().enabled() " +
                this.serverNestedSubgroups.log().enabled() +
                ", + serverNestedSubgroups.log().suffix() " +
                this.serverNestedSubgroups.log().suffix() +
                ", + serverNestedSubgroups.log().rotate() " +
                this.serverNestedSubgroups.log().rotate();
        return "nestedsubgroup - " + serverNestedSubgroups;
    }

    @GET
    @Path("/conversions/automaticallyallmicroprofileconfig")
    @Produces(MediaType.TEXT_PLAIN)
    public String conversionsAutomaticallyallmicroprofileconfig() {
        String conversionsAutomaticallyAllMicroProfileConfig = "conversionsAutomaticallyAllMicroProfileConfig.intPrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.intPrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.intWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.intWrapper() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.longPrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.longPrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.longWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.longWrapper() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.floatPrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.floatPrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.floatWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.floatWrapper() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.doublePrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.doublePrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.doubleWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.doubleWrapper() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.charPrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.charPrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.charWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.charWrapper() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.optionalValue() " +
                ", + conversionsAutomaticallyAllMicroProfileConfig.booleanPrimitive() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.booleanPrimitive() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.booleanWrapper() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.booleanWrapper();
        return "conversionsAutomaticallyAllMicroProfileConfig - " + conversionsAutomaticallyAllMicroProfileConfig;
    }

    @GET
    @Path("/conversions/automaticallyallmicroprofileconfig/optional")
    @Produces(MediaType.TEXT_PLAIN)
    public String conversionsAutomaticallyallmicroprofileconfigOptional() {
        String conversionsAutomaticallyAllMicroProfileConfigOptional =
                "conversionsAutomaticallyAllMicroProfileConfigOptional.optional() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.optional() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.convertWithOptional() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.convertWithOptional() +
                ", + conversionsAutomaticallyAllMicroProfileConfig.optionalInt() " +
                this.conversionsAutomaticallyAllMicroProfileConfig.optionalInt();
        return "conversionsAutomaticallyAllMicroProfileConfigOptional - " + conversionsAutomaticallyAllMicroProfileConfigOptional;
    }

    @GET
    @Path("/overridepropertyname/withname")
    @Produces(MediaType.TEXT_PLAIN)
    public String overridepropertynameWithName() {
        String overridepropertynameWithName =
                "overridePropertyNameWithName.host() " +
                        this.overridePropertyNameWithName.host() +
                        ", + overridePropertyNameWithName.port() " +
                        this.overridePropertyNameWithName.port();
        return "overridepropertynameWithName - " + overridepropertynameWithName;
    }

    @GET
    @Path("/overridepropertyname/withparentname")
    @Produces(MediaType.TEXT_PLAIN)
    public String overridepropertynameWithParentName() {
        String overridepropertynameWithParentName =
                "overridePropertyNameWithParentName.hostAndPort() " +
                        this.overridePropertyNameWithParentName.hostAndPort() +
                        ", + overridePropertyNameWithParentName.info() " +
                        this.overridePropertyNameWithParentName.info();
        return "overridepropertynameWithParentName - " + overridepropertynameWithParentName;
    }

    @GET
    @Path("/conversions/automaticallyallmicroprofileconfig/map")
    @Produces(MediaType.TEXT_PLAIN)
    public String conversionsAutomaticallyMap() {
        String conversionsAutomaticallyMap =
                "conversionsMap.host() " +
                        this.conversionsMap.host() +
                        ", + conversionsMap.port() " +
                        this.conversionsMap.port() +
                        ", + conversionsMap.form() " +
                        this.conversionsMap.form();
        return "conversionsAutomaticallyMap - " + conversionsAutomaticallyMap;
    }
}
