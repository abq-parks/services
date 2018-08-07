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

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column
  private String userEmail;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.DETACH)
  private List<Review> user;

  public URI getHref() {
    return entityLinks.linkForSingleResource(User.class, id).toUri();
  }

  public String getGoogleID() {
    return googleID;
  }

  public void setGoogleID(String googleID) {
    this.googleID = googleID;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
