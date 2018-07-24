package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ParkRepository extends CrudRepository<Park, Long> {

  Iterable<Park> findAllByParkAmenities(Amenity... amenities);

  Iterable<Park> findAllByParkAmenities(List<Amenity> amenities);

}
