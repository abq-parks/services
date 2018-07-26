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

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "amenities",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("name ASC")
  private List<Park> parks = new LinkedList<>();

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setParks(List<Park> parks) {
    this.parks = parks;
  }

  @JsonSerialize(contentAs = BasePark.class)
  public List<Park> getParks() {
    return parks;
  }
}
