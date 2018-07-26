package edu.cnm.deepdive.abqparksservice.utils;

/**
 * Implemented by {@link edu.cnm.deepdive.abqparksservice.model.entity.Amenity} to define desired
 * {@link edu.cnm.deepdive.abqparksservice.model.entity.Park#amenities} serialization and elimintate
 * recursive retrieval in the
 * {@link edu.cnm.deepdive.abqparksservice.model.entity.Park#getAmenities()} method.
 */
public interface BaseAmenity {


  public long getId();

  public String getName();

}
