package edu.cnm.deepdive.abqparksservice.model.dao;

import java.util.List;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParkRepository extends CrudRepository<Park, Long> {

  @Query(value =
      "select "
          + "p.* "
          + "from "
          + "park as p "
          + "inner join ("
          + "select "
          + "p2.park_id, "
          + "count(*) as match_count "
          + "from "
          + "park as p2 "
          + "inner join park_amenities as pa "
          + "on pa.park_id = p2.park_id "
          + "where "
          + "pa.amenity_id in :amenityIds "
          + "group by "
          + "p2.park_id "
          + "having "
          + "count(*) = :amenityCount"
          + ") as p3 on p3.park_id = p.park_id", nativeQuery = true)
  List<Park> findAllByAllAmenities(@Param("amenityIds") List<Long> amenityIds,@Param("amenityCount") int amenityCount);
  List<Park> findAll();

}
