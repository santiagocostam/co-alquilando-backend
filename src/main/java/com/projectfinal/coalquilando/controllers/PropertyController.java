package com.projectfinal.coalquilando.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projectfinal.coalquilando.entities.property.Property;
import com.projectfinal.coalquilando.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping()
    public @ResponseBody
    String createProperty(@RequestBody Property property) throws JsonProcessingException {
        return propertyService.createProperty(property);
    }

    @GetMapping("/propertyId")
    public @ResponseBody
    Property getProperty(@PathVariable(value = "propertyId") Long id) throws JsonProcessingException {
        return propertyService.getPropertyById(id);
    }

    /*@GetMapping("/ownerId/all")
    public @ResponseBody List<Property> getProperties(@PathVariable(value="ownerId") Long id) throws JsonProcessingException {
        return propertyService.getPropertiesByOwner(id);
    }

    @DeleteMapping("/propertyId")
    public @ResponseBody String deleteProperty(@PathVariable(value="propertyId") Long id) throws JsonProcessingException {
        return propertyService.deleteProperty(id);
    }*/

}
