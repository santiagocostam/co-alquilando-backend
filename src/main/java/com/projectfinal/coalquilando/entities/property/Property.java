package com.projectfinal.coalquilando.entities.property;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Property {

    private Long propertyId;
    private Long ownerId;
    private List<Attribute> attributes;
}
