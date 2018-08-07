package edu.cnm.deepdive.abqparksservice.services.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

public class ParksRoot
{
  private String displayFieldName;
  private HashMap<String, String> fieldAliases;
  private String geometryType;
  private SpatialReference spatialReference;
  private ArrayList<Field> fields;
  @SerializedName("features")
  private ArrayList<Parks> parks;

  public String getDisplayFieldName() { return this.displayFieldName; }

  public void setDisplayFieldName(String displayFieldName) { this.displayFieldName = displayFieldName; }

  public HashMap<String, String> getFieldAliases() {
    return fieldAliases;
  }

  public void setFieldAliases(HashMap<String, String> fieldAliases) {
    this.fieldAliases = fieldAliases;
  }

  public String getGeometryType() { return this.geometryType; }

  public void setGeometryType(String geometryType) { this.geometryType = geometryType; }

  public SpatialReference getSpatialReference() { return this.spatialReference; }

  public void setSpatialReference(SpatialReference spatialReference) { this.spatialReference = spatialReference; }

  public ArrayList<Field> getFields() { return this.fields; }

  public void setFields(ArrayList<Field> fields) { this.fields = fields; }

  public ArrayList<Parks> getParks() { return this.parks; }

  public void setParks(ArrayList<Parks> parks) { this.parks = parks; }
}
