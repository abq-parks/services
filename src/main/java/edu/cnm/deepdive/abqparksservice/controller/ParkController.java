package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Park.class)
@RequestMapping("/parks/")
public class ParkController {

  private ParkRepository parkRepository;

  @Autowired
  public ParkController(ParkRepository parkRespository) {
    this.parkRepository = parkRespository;
  }
  

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> allParks() {
    return parkRepository.findAll();
  }

  @GetMapping(value = "/{amenities}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Park> searchParks(@PathVariable("amenities")Amenity... amenities) {
    return parkRepository.findAllByParkAmenities(amenities);
  }

}
