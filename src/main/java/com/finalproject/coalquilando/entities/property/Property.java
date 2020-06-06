package com.finalproject.coalquilando.entities.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@Document
public class Property {

    @Id
    private String id;
    @JsonProperty("propertyId")
    private String propertyId;
    @JsonProperty("ownerId")
    private Long ownerId;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("attributes")
    private List<Attribute> attributes;
}
