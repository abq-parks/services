package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.ReviewRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Review.class)
@RequestMapping("/reviews/")
public class ReviewController {

  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewController(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @GetMapping(value="/{parkId}/", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Review> getReviews(@PathVariable("parkId") long parkId) {
    return reviewRepository.findAllByParkOrderByReviewDesc(parkId);
  }

}
