package edu.cnm.deepdive.abqparksservice.model.entity;

import java.net.URI;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

/**
 * This class contains information on a user.
 */
@Component
@Entity
@Table(name = "users")
public class User {

  private static EntityLinks entityLinks;

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    User.entityLinks = entityLinks;
  }

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String googleID;

  @Column(nullable = true)
  private String firstName;

  @Column(nullable = true)
  private String lastName;

  @Column
  private String userEmail;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.DETACH)
  private List<Review> user;

  /**
   * Returns a {@link URI} link for the user.
   * @return a {@link URI} link for the user.
   */
  public URI getHref() {
    return entityLinks.linkForSingleResource(User.class, id).toUri();
  }

  /**
   * Returns the users id.
   * @return the users id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns a string that contains the users Google ID.
   * @return a string that contains the users Google ID.
   */
  public String getGoogleID() {
    return googleID;
  }

  /**
   * Sets the users Google ID.
   * @param googleID the users Google ID.
   */
  public void setGoogleID(String googleID) {
    this.googleID = googleID;
  }

  /**
   * Returns the users last name.
   * @return the users last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the users last name.
   * @param lastName the users last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Returns the users first name.
   * @return the users first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the users first name.
   * @param firstName the users first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the user email address.
   * @return the user email address.
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Sets the user email address.
   * @param userEmail the user email address.
   */
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
