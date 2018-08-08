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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

/**
 * This entity class is used to store information on each park such as park id, name and location.
 */
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

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(
  cascade = CascadeType.REMOVE)
  private List<Review> reviews = new LinkedList<>();

  /**
   * Returns a URI that links to the park.
   * @return a URI that links to the park.
   */
  public URI getHref() {
    return entityLinks.linkForSingleResource(Review.class, id).toUri();
  }

  /**
   * Returns the id for the park.
   * @return the id for the park.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the name of the park.
   * @return the name of the park.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the park.
   * @param name the name of the park.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the "center" latitude of the park.
   * @return the "center" latitude of the park.
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * Sets the "center" latitude of the park.
   * @param latitude the "center" latitude of the park.
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Returns the "center" longitude of the park.
   * @return the "center" longitude of the park.
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * Sets the "center" longitude of the park.
   * @param longitude the "center" longitude of the park.
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * Returns a list of amenities that the park contains.
   * @return a list of amenities that the park contains.
   */
  @JsonSerialize(contentAs = BaseAmenity.class)
  public List<Amenity> getAmenities() {
    return amenities;
  }

  /**
   * Returns a list of reviews for the park.
   * @return a list of reviews for the park.
   */
  public List<Review> getReviews() {
    return reviews;
  }
}
