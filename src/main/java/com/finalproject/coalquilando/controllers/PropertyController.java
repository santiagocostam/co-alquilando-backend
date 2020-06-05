package com.finalproject.coalquilando.controllers;

import com.finalproject.coalquilando.entities.property.Property;
import com.finalproject.coalquilando.entities.property.Status;
import com.finalproject.coalquilando.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/create")
    public
    String createProperty(@RequestBody Property property) {
        Property p = propertyService.createProperty(property);
        return p.toString();
    }

    @GetMapping("/propertyId")
    public @ResponseBody
    Property getProperty(@PathVariable(value = "propertyId") String propertyId) {
        return propertyService.getByPropertyId(propertyId);
    }

    @GetMapping("/properties")
    public @ResponseBody
    List<Property> getAllProperty() {
        return propertyService.getAll();
    }

    @GetMapping("/properties/statusIs")
    public @ResponseBody
    List<Property> getPropertiesByStatus(@PathVariable(value = "statusIs") Status statusIs) {
        return propertyService.getPropertyByStatus(statusIs);
    }

    @GetMapping("/properties/ownerId")
    public @ResponseBody
    List<Property> getPropertiesByOwner(@PathVariable(value = "ownerId") Long ownerId) {
        return propertyService.getPropertyByOwner(ownerId);
    }

    @PutMapping("/propertyId")
    public @ResponseBody
    Property updateProperty(@PathVariable(value = "propertyId") String propertyId,
                            @RequestBody Property property) {
        return propertyService.updateProperty(property);
    }

    @DeleteMapping("/propertyId")
    public @ResponseBody
    String deleteProperty(@PathVariable(value = "propertyId") String propertyId) {
        propertyService.deleteProperty(propertyId);
        return "Deleted the property " + propertyId;
    }

    @DeleteMapping("/properties")
    public @ResponseBody
    String deleteAllProperties() {
        propertyService.deleteAll();
        return "Deleted all properties";
    }


}
