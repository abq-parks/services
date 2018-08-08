package edu.cnm.deepdive.abqparksservice.services.entity;

/**
 * This class contains information on the coordinate system used for location data.
 */
public class SpatialReference
{
  private int wkid;
  private int latestWkid;

  /**
   * Returns the well-known ID used for location data.
   * @return the well-known ID used for location data.
   */
  public int getWkid() { return this.wkid; }

  /**
   * Sets the well-known ID used for location data.
   * @param wkid the well-known ID used for location data.
   */
  public void setWkid(int wkid) { this.wkid = wkid; }

  /**
   * Returns the latest well-known ID used for location data.
   * @return the latest well-known ID used for location data.
   */
  public int getLatestWkid() { return this.latestWkid; }

  /**
   * Sets the latest well-known ID used for location data.
   * @param latestWkid the latest well-known ID used for location data.
   */
  public void setLatestWkid(int latestWkid) { this.latestWkid = latestWkid; }
}
