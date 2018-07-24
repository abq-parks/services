package edu.cnm.deepdive.abqparksservice.model.entity;

import java.util.List;
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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String userName;

  @Column
  private String userEmail;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.DETACH)
  private List<Review> user;

  public long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
}
