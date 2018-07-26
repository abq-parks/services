package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AmenityRepository extends CrudRepository<Amenity, Long> {
  List<Amenity> findAll();
}
