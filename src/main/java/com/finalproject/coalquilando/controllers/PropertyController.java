package com.finalproject.coalquilando.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.finalproject.coalquilando.entities.property.Property;
import com.finalproject.coalquilando.entities.property.Status;
import com.finalproject.coalquilando.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping()
    public ResponseEntity createProperty(@Valid @RequestBody Property property) throws JsonProcessingException {
        return ResponseEntity.ok(propertyService.createProperty(property));
    }

    @GetMapping("/{propertyId}")
    public @ResponseBody
    Property getProperty(@PathVariable(value = "propertyId") String propertyId) {
        return propertyService.getByPropertyId(propertyId);
    }

    @GetMapping("/properties")
    public @ResponseBody
    List<Property> getAllProperty() {
        return propertyService.getAll();
    }

    @GetMapping("/properties/status/{statusId}")
    public @ResponseBody
    List<Property> getPropertiesByStatus(@PathVariable(value = "statusId") Status statusId) {
        return propertyService.getPropertyByStatus(statusId);
    }

    @GetMapping("/properties/owner/{ownerId}")
    public @ResponseBody
    List<Property> getPropertiesByOwner(@PathVariable(value = "ownerId") Long ownerId) {
        return propertyService.getPropertyByOwner(ownerId);
    }

    @PutMapping("/{propertyId}")
    public @ResponseBody
    Property updateProperty(@PathVariable(value = "propertyId") String propertyId,
                            @RequestBody Property property) {
        return propertyService.updateProperty(property);
    }

    @DeleteMapping("/{propertyId}")
    public @ResponseBody
    ResponseEntity deleteProperty(@PathVariable(value = "propertyId") String propertyId) {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.ok("Deleted the property " + propertyId);
    }

    @DeleteMapping("/properties")
    public @ResponseBody
    ResponseEntity deleteAllProperties() {
        propertyService.deleteAll();
        return ResponseEntity.ok("Deleted all properties");
    }


}
