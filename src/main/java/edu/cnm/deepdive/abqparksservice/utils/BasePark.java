package edu.cnm.deepdive.abqparksservice.utils;

import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;

/**
 *  Implemented by {@link edu.cnm.deepdive.abqparksservice.model.entity.Park} to define desired
 *  serialization and eliminate recursive retrieval in the {@link Amenity#getParks()} method.
 */
public interface BasePark {

  public long getId();

  public String getName();

  public double getLatitude();

  public double getLongitude();

}
