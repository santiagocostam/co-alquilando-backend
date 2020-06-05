package com.finalproject.coalquilando.services;

import com.finalproject.coalquilando.entities.property.Property;
import com.finalproject.coalquilando.entities.property.Status;
import com.finalproject.coalquilando.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // Create op
    public Property createProperty(Property property) {
        validatePropertyCreate(property);

        return propertyRepository.save(
                Property.builder()
                        .ownerId(property.getOwnerId())
                        .status(defineStatus(property))
                        .attributes(property.getAttributes())
                        .build()
        );
    }

    // Retrieve op
    public Property getByPropertyId(String propertyId) {
        return propertyRepository.findByPropertyId(propertyId);
    }

    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    public List<Property> getPropertyByStatus(Status status) {
        return propertyRepository.findByStatus(status);
    }

    public List<Property> getPropertyByOwner(Long ownerId) {
        return propertyRepository.findByOwnerId(ownerId);
    }

    // Update op
    public Property updateProperty(Property property) {

        validatePropertyUpdate(property);

        Property p = propertyRepository.findByPropertyId(property.getPropertyId());
        p.setStatus(property.getStatus());
        p.setAttributes(property.getAttributes());
        return propertyRepository.save(p);
    }

    // Delete op
    public void deleteAll() {
        propertyRepository.deleteAll();
    }

    public void deleteProperty(String propertyId) {
        Property p = propertyRepository.findByPropertyId(propertyId);
        propertyRepository.delete(p);
    }


    protected void validatePropertyCreate(Property property) {
        if (isNull(property.getOwnerId()))
            throw new IllegalArgumentException("OwnerId can't be null");
        if (isNull(property.getAttributes()))
            throw new IllegalArgumentException("Attributes can't be null. At list one attribute");
    }

    protected void validatePropertyUpdate(Property property) {
        if (isNull(property.getPropertyId()))
            throw new IllegalArgumentException("PropertyId can't be null");
        if (isNull(property.getOwnerId()))
            throw new IllegalArgumentException("OwnerId can't be null");
        if (isNull(property.getStatus()))
            throw new IllegalArgumentException("Status can't be null");
        if (isNull(property.getAttributes()))
            throw new IllegalArgumentException("Attributes can't be null. At list one attribute");
    }


    protected Status defineStatus(Property property) {
        return isNull(property.getStatus()) ? Status.AVAILABLE : property.getStatus();
    }





    /*public String createProperty(@NotNull Property property) throws JsonProcessingException {
        return null;
    }

    public Property getPropertyById(@NotNull Long propertyId) throws JsonProcessingException {
        return null;
    }

    /*public List<Property> getPropertiesByOwner(@NotNull Long ownerId) throws JsonProcessingException {
        return restClient.request(urlBase, ownerId, HttpMethod.GET, List.class);
    }

    public String deleteProperty(@NotNull Long propertyId) throws JsonProcessingException {
        return restClient.request(urlBase, propertyId, HttpMethod.DELETE, String.class);
    }*/
}
