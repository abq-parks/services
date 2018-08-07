package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@ExposesResourceFor(Amenity.class)
@RequestMapping("/amenities")
public class AmenityController {

  private AmenityRepository amenityRepository;

  @Autowired
  public AmenityController(AmenityRepository amenityRepository) {
    this.amenityRepository = amenityRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Amenity> getAmenities() {
    return amenityRepository.findAllByOrderByDisplayName();
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
