package com.finalproject.coalquilando.entities.property;

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
    private String propertyId;
    private Long ownerId;
    private Status status;
    private List<Attribute> attributes;
}
