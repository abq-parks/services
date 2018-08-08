package edu.cnm.deepdive.abqparksservice.model.entity;


import java.net.URI;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

/**
 * This entity class is used to store data for each park review.
 */
@Component
@Entity
public class Review {

  private static EntityLinks entityLinks;

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Review.entityLinks = entityLinks;
  }

  // Create an id for a new review.
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "review_id", nullable = false, updatable = false)
  private long id;

  // Create a timestamp for when the review was placed.
  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  @Column(nullable = false, updatable = false)
  private Date date;

  // Allow input of said review.
  @Column(nullable = false)
  private String review;

  // Does some other stuff!
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  @JoinColumn(name = "park_id", nullable = false)
  private Park park;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  /**
   * Returns a {@link URI} link to the review.
   * @return a {@link URI} link to the review.
   */
  public URI getHref() {
    return entityLinks.linkForSingleResource(Review.class, id).toUri();
  }

  /**
   * Returns the id for the review.
   * @return the id for the review.
   */
  public long getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  /**
   * Returns the text of the review as a string.
   * @return the text of the review as a string.
   */
  public String getReview() {
    return review;
  }

  /**
   * Sets the text of the review as a string.
   * @param review the text of the review as a string.
   */
  public void setReview(String review) {
    this.review = review;
  }

  /**
   * Returns the {@link Park} associated withe th review.
   * @return the {@link Park} associated withe th review.
   */
  public Park getPark() {
    return park;
  }

  /**
   * Sets the {@link Park} associated withe th review.
   * @param park the {@link Park} associated withe th review.
   */
  public void setPark(Park park) {
    this.park = park;
  }

  /**
   * Returns the {@link User} associated with the review.
   * @return the {@link User} associated with the review.
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the {@link User} associated with the review.
   * @param user the {@link User} associated with the review.
   */
  public void setUser(User user) {
    this.user = user;
  }
}
