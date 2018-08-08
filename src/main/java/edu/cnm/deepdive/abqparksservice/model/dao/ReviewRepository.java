package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface extends {@link CrudRepository} and is used to query the review table.
 */
public interface ReviewRepository extends CrudRepository<Review, Long> {

  /**
   * Query review table for all reviews for a certain park.
   * @param parkId id of the park.
   * @return a list of reviews for the park.
   */
  Iterable<Review> findAllByPark_IdOrderByReviewDesc(long parkId);

}
