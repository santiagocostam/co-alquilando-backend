package com.finalproject.coalquilando.entities.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Status {
    @JsonProperty("available")
    AVAILABLE("available"),
    @JsonProperty("disable")
    DISABLE("disable"),
    @JsonProperty("rented")
    RENTED("rented"),
    @JsonProperty("available")
    PRE_RENTED("pre_rented");

    private final String apiName;

    Status(String apiName){
        this.apiName = apiName;
    }

    public static Status findByApiName(String apiName) {
        return Arrays.stream(Status.values())
                .filter( x -> x.getApiName().equalsIgnoreCase(apiName))
                .findFirst()
                .orElse(null);
    }
}
