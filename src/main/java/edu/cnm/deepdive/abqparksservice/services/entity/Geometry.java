package edu.cnm.deepdive.abqparksservice.services.entity;

import java.util.ArrayList;

public class Geometry
{
  private ArrayList<ArrayList<ArrayList<Double>>> rings;

  public ArrayList<ArrayList<ArrayList<Double>>> getRings() { return this.rings; }

  public void setRings(ArrayList<ArrayList<ArrayList<Double>>> rings) { this.rings = rings; }
}
