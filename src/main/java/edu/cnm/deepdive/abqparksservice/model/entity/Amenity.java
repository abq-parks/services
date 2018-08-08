package edu.cnm.deepdive.abqparksservice.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.abqparksservice.utils.BaseAmenity;
import edu.cnm.deepdive.abqparksservice.utils.BasePark;
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
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;

/**
 * This entity class information about a park amenity such as the id, name, and display name.
 */
@Entity
public class Amenity implements BaseAmenity {

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

  @Column(nullable = false)
  private String displayName;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "amenities",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("name ASC")
  private List<Park> parks = new LinkedList<>();

  /**
   * Returns the id for the amenity.
   * @return the id for the amenity.
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
   * Returns the display name for the park.
   * @return the display name for the park.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the display name for the park.
   * @param displayName the display name for the park.
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * Sets the list of parks that contain the amenity.
   * @param parks the list of parks that contain the amenity.
   */
  public void setParks(List<Park> parks) {
    this.parks = parks;
  }

  /**
   * Returns the list of parks that contain the amenity.
   * @return the list of parks that contain the amenity.
   */
  @JsonSerialize(contentAs = BasePark.class)
  public List<Park> getParks() {
    return parks;
  }
}
