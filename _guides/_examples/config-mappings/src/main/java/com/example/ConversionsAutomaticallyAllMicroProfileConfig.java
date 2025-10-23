package com.example;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;
import java.util.Optional;
import java.util.OptionalInt;

@ConfigMapping
public interface ConversionsAutomaticallyAllMicroProfileConfig {
    @WithName("int")
    int intPrimitive();

    @WithName("int")
    Integer intWrapper();

    @WithName("long")
    long longPrimitive();

    @WithName("long")
    Long longWrapper();

    @WithName("float")
    float floatPrimitive();

    @WithName("float")
    Float floatWrapper();

    @WithName("double")
    double doublePrimitive();

    @WithName("double")
    Double doubleWrapper();

    @WithName("char")
    char charPrimitive();

    @WithName("char")
    Character charWrapper();

    @WithName("boolean")
    boolean booleanPrimitive();

    @WithName("boolean")
    Boolean booleanWrapper();

    // with OPTIONAL
    Optional<String> optional();

    @WithName("optional.int")
    OptionalInt optionalInt();

    Optional<ConvertWithOptional> convertWithOptional();

    interface ConvertWithOptional {
        String host();

        int port();
    }
}
