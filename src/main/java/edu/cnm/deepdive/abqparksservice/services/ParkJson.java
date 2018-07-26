package edu.cnm.deepdive.abqparksservice.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkJson {

  private Attributes attributes;

  private Geometry geometry;

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public Attributes getAttributes() {
    return attributes;
  }

  public void setGeometry(Geometry geometry) {
    this.geometry = geometry;
  }

  public Geometry getGeometry() {
    return geometry;
  }

  public class Attributes {

    private long objectId;

    private String parkName;

    private int playAreas;

    private int fullBasketBallCourts;

    private int halfBasketballCourts;

    private int soccerFields;

    private int litSoftBallFields;

    private int unlitSoftballFields;

    private int youthBallFields;

    private int indoorPools;

    private int outdoorPools;

    private int horseshoePits;

    private int volleyballCourts;

    private int backstops;

    private int picnicTables;

    private int shadeStructures;

    private int joggingPaths;

    public long getObjectId() {
      return objectId;
    }

    public void setObjectId(long objectId) {
      this.objectId = objectId;
    }

    public String getParkName() {
      return parkName;
    }

    public void setParkName(String parkName) {
      this.parkName = parkName;
    }

    public int getPlayAreas() {
      return playAreas;
    }

    public void setPlayAreas(int playAreas) {
      this.playAreas = playAreas;
    }

    public int getFullBasketBallCourts() {
      return fullBasketBallCourts;
    }

    public void setFullBasketBallCourts(int fullBasketBallCourts) {
      this.fullBasketBallCourts = fullBasketBallCourts;
    }

    public int getHalfBasketballCourts() {
      return halfBasketballCourts;
    }

    public void setHalfBasketballCourts(int halfBasketballCourts) {
      this.halfBasketballCourts = halfBasketballCourts;
    }

    public int getSoccerFields() {
      return soccerFields;
    }

    public void setSoccerFields(int soccerFields) {
      this.soccerFields = soccerFields;
    }

    public int getLitSoftBallFields() {
      return litSoftBallFields;
    }

    public void setLitSoftBallFields(int litSoftBallFields) {
      this.litSoftBallFields = litSoftBallFields;
    }

    public int getUnlitSoftballFields() {
      return unlitSoftballFields;
    }

    public void setUnlitSoftballFields(int unlitSoftballFields) {
      this.unlitSoftballFields = unlitSoftballFields;
    }

    public int getYouthBallFields() {
      return youthBallFields;
    }

    public void setYouthBallFields(int youthBallFields) {
      this.youthBallFields = youthBallFields;
    }

    public int getIndoorPools() {
      return indoorPools;
    }

    public void setIndoorPools(int indoorPools) {
      this.indoorPools = indoorPools;
    }

    public int getOutdoorPools() {
      return outdoorPools;
    }

    public void setOutdoorPools(int outdoorPools) {
      this.outdoorPools = outdoorPools;
    }

    public int getHorseshoePits() {
      return horseshoePits;
    }

    public void setHorseshoePits(int horseshoePits) {
      this.horseshoePits = horseshoePits;
    }

    public int getVolleyballCourts() {
      return volleyballCourts;
    }

    public void setVolleyballCourts(int volleyballCourts) {
      this.volleyballCourts = volleyballCourts;
    }

    public int getBackstops() {
      return backstops;
    }

    public void setBackstops(int backstops) {
      this.backstops = backstops;
    }

    public int getPicnicTables() {
      return picnicTables;
    }

    public void setPicnicTables(int picnicTables) {
      this.picnicTables = picnicTables;
    }

    public int getShadeStructures() {
      return shadeStructures;
    }

    public void setShadeStructures(int shadeStructures) {
      this.shadeStructures = shadeStructures;
    }

    public int getJoggingPaths() {
      return joggingPaths;
    }

    public void setJoggingPaths(int joggingPaths) {
      this.joggingPaths = joggingPaths;
    }
  }

  public class Geometry {

    private double[][] rings;

    public double[][] getRings() {
      return rings;
    }

    public void setRings(double[][] rings) {
      this.rings = rings;
    }
  }
}
