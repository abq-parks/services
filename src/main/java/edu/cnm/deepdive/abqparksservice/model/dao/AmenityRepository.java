package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface extends {@link CrudRepository} and is used to query the amenity table.
 */
public interface AmenityRepository extends CrudRepository<Amenity, Long> {

  /**
   * Query database for all amenities that a park can contain.
   * @return a list of amenities ordered by their display name.
   */
  List<Amenity> findAllByOrderByDisplayName();
}
