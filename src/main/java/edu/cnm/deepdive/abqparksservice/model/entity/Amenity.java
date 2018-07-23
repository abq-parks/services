package edu.cnm.deepdive.abqparksservice.model.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Amenity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "amenity_id", nullable = false, updatable = false)
  private long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "Amenity")
  private List<ParkAmenity> parkAmenities;

}
