package edu.cnm.deepdive.abqparksservice.services.entity;

public class Feature
{
  private Attributes attributes;

  public Attributes getAttributes() { return this.attributes; }

  public void setAttributes(Attributes attributes) { this.attributes = attributes; }

  private Geometry geometry;

  public Geometry getGeometry() { return this.geometry; }

  public void setGeometry(Geometry geometry) { this.geometry = geometry; }
}
