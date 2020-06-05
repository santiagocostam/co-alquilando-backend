package com.finalproject.coalquilando.entities.property;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Attribute {

    private final String attributeId;
    private final String attributeName;
    private final String value;
    private final String description;
}
