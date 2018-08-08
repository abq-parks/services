package edu.cnm.deepdive.abqparksservice.services.entity;

/**
 * This class contains objects that contain attributes and location data for each park.
 */
public class Parks
{
  private Attributes attributes;
  private Geometry geometry;

  /**
   * Returns a list of {@link Attributes} for the park.
   * @return a list of {@link Attributes} for the park.
   */
  public Attributes getAttributes() { return this.attributes; }

  /**
   * Sets the list of {@link Attributes} for the park.
   * @param attributes the list of {@link Attributes} for the park.
   */
  public void setAttributes(Attributes attributes) { this.attributes = attributes; }

  /**
   * Returns a {@link Geometry} object which contains location data for the park.
   * @return a {@link Geometry} object which contains location data for the park.
   */
  public Geometry getGeometry() { return this.geometry; }

  /**
   * Sets the {@link Geometry} object which contains location data for the park.
   * @param geometry the {@link Geometry} object which contains location data for the park.
   */
  public void setGeometry(Geometry geometry) { this.geometry = geometry; }
}
