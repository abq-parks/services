package edu.cnm.deepdive.abqparksservice.model.entity;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

@Entity
public class ParkAmenity {

  private static EntityLinks entityLinks;
  
  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ParkAmenity.entityLinks = entityLinks;
  }

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "park_id")
  Park park;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "amenity_id")
  Amenity amenity;


}
