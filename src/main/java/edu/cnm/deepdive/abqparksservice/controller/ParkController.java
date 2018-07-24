package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Park.class)
@RequestMapping("/parks/")
public class ParkController {

  private ParkRepository parkRepository;

  @Autowired
  public ParkController(ParkRepository parkRepository) {
    this.parkRepository = parkRepository;
  }

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> allParks() {
    return parkRepository.findAll();
  }

  @GetMapping(value = "/{amenities}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> searchParks(@PathVariable("amenities")Amenity... amenities) {
    return parkRepository.findAllByParkAmenities(amenities);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
