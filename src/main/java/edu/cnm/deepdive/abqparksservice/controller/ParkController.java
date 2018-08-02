package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Park.class)
@RequestMapping("/parks")
public class ParkController {

  private ParkRepository parkRepository;
  private AmenityRepository amenityRepository;

  @Autowired
  public ParkController(ParkRepository parkRepository, AmenityRepository amenityRepository) {
    this.parkRepository = parkRepository;
    this.amenityRepository = amenityRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> allParks() {
    return parkRepository.findAll();
  }

  @GetMapping(value = "{amenitiesId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> searchParks(@PathVariable("amenitiesId") Long[] amenitiesId) {
    List<Long> idsList = Arrays.stream(amenitiesId).collect(Collectors.toList());
    return parkRepository.findAllByAllAmenities(idsList, idsList.size());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Park> post(@RequestBody Park park) {
    parkRepository.save(park);
    return ResponseEntity.created(park.getHref()).body(park);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
