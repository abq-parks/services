package edu.cnm.deepdive.abqparksservice.controller;

import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ReviewRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.UserRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Review;
import java.util.NoSuchElementException;
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
@ExposesResourceFor(Review.class)
@RequestMapping("/reviews")
public class ReviewController {

  private ReviewRepository reviewRepository;
  private ParkRepository parkRepository;
  private UserRepository userRepository;

  @Autowired
  public ReviewController(ReviewRepository reviewRepository, ParkRepository parkRepository, UserRepository userRepository) {
    this.reviewRepository = reviewRepository;
    this.parkRepository = parkRepository;
    this.userRepository = userRepository;
  }

  @GetMapping(value ="{parkId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Review> getReviews(@PathVariable("parkId") long parkId) {
    return reviewRepository.findAllByPark_IdOrderByReviewDesc(parkId);
  }

  @PostMapping(value = "{args}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Review> post(@PathVariable("args") Long[] args, @RequestBody Review review) {
    return parkRepository.findById(args[0]).map(
        park -> {
          review.setPark(park);
          return userRepository.findById(args[1]).map(
              user -> {
                review.setUser(user);
                reviewRepository.save(review);
                return ResponseEntity.created(review.getHref()).body(review);
              }
          ).get();
        }
    ).get();
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }
}
