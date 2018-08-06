package edu.cnm.deepdive.abqparksservice.services.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class RootObject
{
  private String displayFieldName;

  public String getDisplayFieldName() { return this.displayFieldName; }

  public void setDisplayFieldName(String displayFieldName) { this.displayFieldName = displayFieldName; }

  private HashMap<String, String> fieldAliases;

  public HashMap<String, String> getFieldAliases() {
    return fieldAliases;
  }

  public void setFieldAliases(HashMap<String, String> fieldAliases) {
    this.fieldAliases = fieldAliases;
  }

  private String geometryType;

  public String getGeometryType() { return this.geometryType; }

  public void setGeometryType(String geometryType) { this.geometryType = geometryType; }

  private SpatialReference spatialReference;

  public SpatialReference getSpatialReference() { return this.spatialReference; }

  public void setSpatialReference(SpatialReference spatialReference) { this.spatialReference = spatialReference; }

  private ArrayList<Field> fields;

  public ArrayList<Field> getFields() { return this.fields; }

  public void setFields(ArrayList<Field> fields) { this.fields = fields; }

  private ArrayList<Feature> features;

  public ArrayList<Feature> getFeatures() { return this.features; }

  public void setFeatures(ArrayList<Feature> features) { this.features = features; }
}
