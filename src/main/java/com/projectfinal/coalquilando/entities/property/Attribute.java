package com.projectfinal.coalquilando.entities.property;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Attribute {

    private String attributeId;
    private String attributeName;
    private String value;
    private String description;
}
