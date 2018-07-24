package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

  Iterable<Review> findAllByParkOrderByReviewDesc(long parkId);

}
