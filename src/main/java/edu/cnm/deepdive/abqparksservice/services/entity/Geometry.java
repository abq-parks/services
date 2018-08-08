package edu.cnm.deepdive.abqparksservice.services.entity;

import java.util.ArrayList;

/**
 * This class is used for location data for each park.
 */
public class Geometry
{
  private ArrayList<ArrayList<ArrayList<Double>>> rings;

  /**
   * Returns a list of doubles that contains points for the perimeter of the park.
   * @return a list of doubles that contains points for the perimeter of the park.
   */
  public ArrayList<ArrayList<ArrayList<Double>>> getRings() { return this.rings; }

  /**
   * Sets the list of points for the perimeter of the park.
   * @param rings the list of points for the perimeter of the park.
   */
  public void setRings(ArrayList<ArrayList<ArrayList<Double>>> rings) { this.rings = rings; }
}
