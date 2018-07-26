package edu.cnm.deepdive.abqparksservice.services.entity;

public class SpatialReference
{
  private int wkid;

  public int getWkid() { return this.wkid; }

  public void setWkid(int wkid) { this.wkid = wkid; }

  private int latestWkid;

  public int getLatestWkid() { return this.latestWkid; }

  public void setLatestWkid(int latestWkid) { this.latestWkid = latestWkid; }
}
