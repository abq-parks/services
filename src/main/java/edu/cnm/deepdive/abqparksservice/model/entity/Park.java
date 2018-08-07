package edu.cnm.deepdive.abqparksservice.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.abqparksservice.utils.BaseAmenity;
import edu.cnm.deepdive.abqparksservice.utils.BasePark;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Park implements BasePark {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Park.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "park_id", nullable = false, updatable = false)
  private long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(nullable = false)
  private double latitude;

  @Column(nullable = false)
  private double longitude;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(joinColumns = @JoinColumn(name = "park_id"),
      inverseJoinColumns = @JoinColumn(name = "amenity_id"))
  @OrderBy("name ASC")
  private List<Amenity> amenities = new LinkedList<>();

  @OneToMany(fetch = FetchType.EAGER,
  cascade = CascadeType.REMOVE)
  private List<Review> reviews = new LinkedList<>();

  public URI getHref() {
    return entityLinks.linkForSingleResource(Review.class, id).toUri();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @JsonSerialize(contentAs = BaseAmenity.class)
  public List<Amenity> getAmenities() {
    return amenities;
  }
  
  public List<Review> getReviews() {
    return reviews;
  }
}
