package com.projectfinal.coalquilando.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.projectfinal.coalquilando.entities.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    RestClient restClient;

    String urlBase = "localhost:8082"; // TODO: Set this property in a resource to consume database.

    public String createProperty(@NotNull Property property) throws JsonProcessingException {
        return restClient.request(urlBase, property, HttpMethod.POST, String.class);
    }

    public Property getPropertyById(@NotNull Long propertyId) throws JsonProcessingException {
        return restClient.request(urlBase, propertyId, HttpMethod.GET, Property.class);
    }

    public List<Property> getPropertiesByOwner(@NotNull Long ownerId) throws JsonProcessingException {
        return restClient.request(urlBase, ownerId, HttpMethod.GET, List.class);
    }

    public String deleteProperty(@NotNull Long propertyId) throws JsonProcessingException {
        return restClient.request(urlBase, propertyId, HttpMethod.DELETE, String.class);
    }
}
