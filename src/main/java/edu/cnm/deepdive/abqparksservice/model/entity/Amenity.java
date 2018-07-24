package edu.cnm.deepdive.abqparksservice.model.entity;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

@Entity
public class Amenity {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Amenity.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "amenity_id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "amenity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<ParkAmenity> parkAmenities;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ParkAmenity> getParkAmenities() {
    return parkAmenities;
  }

  public void setParkAmenities(
      List<ParkAmenity> parkAmenities) {
    this.parkAmenities = parkAmenities;
  }
}
