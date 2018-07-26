package edu.cnm.deepdive.abqparksservice.model.dao;

import java.util.List;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import org.springframework.data.repository.CrudRepository;

public interface ParkRepository extends CrudRepository<Park, Long> {

  Iterable<Park> findAllByAmenitiesIn(List<Amenity> amenities);
  Iterable<Park> findDistinctByAmenitiesIn(List<Amenity> amenities);

}
