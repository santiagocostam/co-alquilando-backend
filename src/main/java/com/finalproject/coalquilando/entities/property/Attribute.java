package com.finalproject.coalquilando.entities.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@ToString
@Document
public class Attribute {

    @JsonProperty("attributeId")
    private String attributeId;
    @JsonProperty("attributeName")
    private String attributeName;
    @JsonProperty("value")
    private String value;
    @JsonProperty("description")
    private String description;
}
