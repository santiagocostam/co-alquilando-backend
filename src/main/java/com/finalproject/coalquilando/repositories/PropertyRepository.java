package com.finalproject.coalquilando.repositories;

import com.finalproject.coalquilando.entities.property.Property;
import com.finalproject.coalquilando.entities.property.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    Property findByPropertyId(String propertyId);

    List<Property> findByStatus(Status status);

    List<Property> findByOwnerId(Long ownerId);







    /*@Autowired
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

    @GetMapping("/ownerId/all")
    public @ResponseBody
    List<Property> getProperties(@PathVariable(value="ownerId") Long id) throws JsonProcessingException {
        return propertyService.getPropertiesByOwner(id);
    }

    @DeleteMapping("/propertyId")
    public @ResponseBody String deleteProperty(@PathVariable(value="propertyId") Long id) throws JsonProcessingException {
        return propertyService.deleteProperty(id);
    }*/

}
