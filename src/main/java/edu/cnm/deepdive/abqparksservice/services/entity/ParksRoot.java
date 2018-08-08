package edu.cnm.deepdive.abqparksservice.services.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the root class for the parks json pojo.
 */
public class ParksRoot
{
  private String displayFieldName;
  private HashMap<String, String> fieldAliases;
  private String geometryType;
  private SpatialReference spatialReference;
  private ArrayList<Field> fields;
  @SerializedName("features")
  private ArrayList<Parks> parks;

  /**
   * Returns the display name.
   * @return the display name.
   */
  public String getDisplayFieldName() { return this.displayFieldName; }

  /**
   * Sets the display name.
   * @param displayFieldName the display name.
   */
  public void setDisplayFieldName(String displayFieldName) { this.displayFieldName = displayFieldName; }

  /**
   * Returns a hash map of names mapped to display names.
   * @return a hash map of names mapped to display names.
   */
  public HashMap<String, String> getFieldAliases() {
    return fieldAliases;
  }

  /**
   * Sets the hash map of names mapped to display names.
   * @param fieldAliases the hash map of names mapped to display names.
   */
  public void setFieldAliases(HashMap<String, String> fieldAliases) {
    this.fieldAliases = fieldAliases;
  }

  /**
   * Returns the geometry type for location data.
   * @return the geometry type for location data.
   */
  public String getGeometryType() { return this.geometryType; }

  /**
   * Sets the geometry type for location data.
   * @param geometryType the geometry type for location data.
   */
  public void setGeometryType(String geometryType) { this.geometryType = geometryType; }

  /**
   * Returns a {@link SpatialReference} object.
   * @return a {@link SpatialReference} object.
   */
  public SpatialReference getSpatialReference() { return this.spatialReference; }

  /**
   * Sets a {@link SpatialReference} object.
   * @param spatialReference a {@link SpatialReference} object.
   */
  public void setSpatialReference(SpatialReference spatialReference) { this.spatialReference = spatialReference; }

  /**
   * Returns a list of {@link Field} objects
   * @return a list of {@link Field} objects
   */
  public ArrayList<Field> getFields() { return this.fields; }

  /**
   * Sets the list of {@link Field} objects
   * @param fields the list of {@link Field} objects
   */
  public void setFields(ArrayList<Field> fields) { this.fields = fields; }

  /**
   * Returns a list of {@link Parks} objects.
   * @return a list of {@link Parks} objects.
   */
  public ArrayList<Parks> getParks() { return this.parks; }

  /**
   * Sets the list of {@link Parks} objects.
   * @param parks the list of {@link Parks} objects.
   */
  public void setParks(ArrayList<Parks> parks) { this.parks = parks; }
}
