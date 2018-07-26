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

  public URI getHref() {
    return entityLinks.linkForSingleResource(Review.class, id).toUri();
  }

  public long getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Park getPark() {
    return park;
  }

  public void setPark(Park park) {
    this.park = park;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
