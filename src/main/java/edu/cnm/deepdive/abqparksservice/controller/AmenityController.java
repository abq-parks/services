package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the amenity REST controller.
 */
@RestController
@ExposesResourceFor(Amenity.class)
@RequestMapping("/amenities")
public class AmenityController {

  private AmenityRepository amenityRepository;

  /**
   * Auto wires AmenityRepository.
   * @param amenityRepository AmenityRepository
   */
  @Autowired
  public AmenityController(AmenityRepository amenityRepository) {
    this.amenityRepository = amenityRepository;
  }

  /**
   * Returns a list of all amenities that a park can contain.
   * @return a list of all amenities that a park can contain.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Amenity> getAmenities() {
    return amenityRepository.findAllByOrderByDisplayName();
  }

  /**
   * Error handling.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
