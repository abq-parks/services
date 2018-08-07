package edu.cnm.deepdive.abqparksservice.services.entity;

import com.google.gson.annotations.SerializedName;

public class Attributes
{
  @SerializedName("OBJECTID")
  private int objectId;
  @SerializedName("PARKNAME")
  private String parkName;
  @SerializedName("PARKSTATUS")
  private String parkStatus;
  @SerializedName("JURISDICTION")
  private String jurisdiction;
  @SerializedName("ACRES")
  private double acres;
  @SerializedName("DEVELOPEDACRES")
  private double developedAcres;
  @SerializedName("LITTENNISCOURTS")
  private int litTennisCourts;
  @SerializedName("UNLITTENNISCOURTS")
  private int unlitTennisCourts;
  @SerializedName("PLAYAREAS")
  private int playAreas;
  @SerializedName("FULLBASKETBALLCOURTS")
  private int fullBasketballCourts;
  @SerializedName("HALFBASKETBALLCOURTS")
  private int halfBasketballCourts;
  @SerializedName("SOCCERFIELDS")
  private int soccerFields;
  @SerializedName("LITSOFTBALLFIELDS")
  private int litSoftballFields;
  @SerializedName("UNLITSOFTBALLFIELDS")
  private int unlitSoftballFields;
  @SerializedName("YOUTHBALLFIELDS")
  private int youthballFields;
  @SerializedName("INDOORPOOLS")
  private int indoorPools;
  @SerializedName("OUTDOORPOOLS")
  private int outdoorPools;
  @SerializedName("HORSESHOEPITS")
  private int horseshoePits;
  @SerializedName("VOLLEYBALLCOURTS")
  private int volleyballCourts;
  @SerializedName("BACKSTOPS")
  private int backstops;
  @SerializedName("PICNICTABLES")
  private int picnictables;
  @SerializedName("SHADESTRUCTURES")
  private int ShadeStructures;
  @SerializedName("PARKINGSPACES")
  private int parkingSpaces;
  @SerializedName("JOGGINGPATHS")
  private int joggingPaths;
  private String created_user;
  private String created_date;
  private String last_edited_user;
  private String last_edited_date;

  public int getObjectId() { return this.objectId; }

  public void setObjectId(int objectId) { this.objectId = objectId; }

  public String getParkName() { return this.parkName; }

  public void setParkName(String parkName) { this.parkName = parkName; }

  public String getParkStatus() { return this.parkStatus; }

  public void setParkStatus(String parkStatus) { this.parkStatus = parkStatus; }

  public String getJurisdiction() { return this.jurisdiction; }

  public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }

  public double getAcres() { return this.acres; }

  public void setAcres(double acres) { this.acres = acres; }

  public double getDevelopedAcres() { return this.developedAcres; }

  public void setDevelopedAcres(double developedAcres) { this.developedAcres = developedAcres; }

  public int getLitTennisCourts() { return this.litTennisCourts; }

  public void setLitTennisCourts(int litTennisCourts) { this.litTennisCourts = litTennisCourts; }

  public int getUnlitTennisCourts() { return this.unlitTennisCourts; }

  public void setUnlitTennisCourts(int unlitTennisCourts) { this.unlitTennisCourts = unlitTennisCourts; }

  public int getPlayAreas() { return this.playAreas; }

  public void setPlayAreas(int playAreas) { this.playAreas = playAreas; }

  public int getFullBasketballCourts() { return this.fullBasketballCourts; }

  public void setFullBasketballCourts(int fullBasketballCourts) { this.fullBasketballCourts = fullBasketballCourts; }

  public int getHalfBasketballCourts() { return this.halfBasketballCourts; }

  public void setHalfBasketballCourts(int halfBasketballCourts) { this.halfBasketballCourts = halfBasketballCourts; }

  public int getSoccerFields() { return this.soccerFields; }

  public void setSoccerFields(int soccerFields) { this.soccerFields = soccerFields; }

  public int getLitSoftballFields() { return this.litSoftballFields; }

  public void setLitSoftballFields(int litSoftballFields) { this.litSoftballFields = litSoftballFields; }

  public int getUnlitSoftballFields() { return this.unlitSoftballFields; }

  public void setUnlitSoftballFields(int unlitSoftballFields) { this.unlitSoftballFields = unlitSoftballFields; }

  public int getYouthballFields() { return this.youthballFields; }

  public void setYouthballFields(int youthballFields) { this.youthballFields = youthballFields; }

  public int getIndoorPools() { return this.indoorPools; }

  public void setIndoorPools(int indoorPools) { this.indoorPools = indoorPools; }

  public int getOutdoorPools() { return this.outdoorPools; }

  public void setOutdoorPools(int outdoorPools) { this.outdoorPools = outdoorPools; }

  public int getHorseshoePits() { return this.horseshoePits; }

  public void setHorseshoePits(int horseshoePits) { this.horseshoePits = horseshoePits; }

  public int getVolleyballCourts() { return this.volleyballCourts; }

  public void setVolleyballCourts(int volleyballCourts) { this.volleyballCourts = volleyballCourts; }

  public int getBackstops() { return this.backstops; }

  public void setBackstops(int backstops) { this.backstops = backstops; }

  public int getPicnictables() { return this.picnictables; }

  public void setPicnictables(int picnictables) { this.picnictables = picnictables; }

  public int getShadeStructures() { return this.ShadeStructures; }

  public void setShadeStructures(int shadeStructures) { this.ShadeStructures = shadeStructures; }

  public int getParkingSpaces() { return this.parkingSpaces; }

  public void setParkingSpaces(int parkingSpaces) { this.parkingSpaces = parkingSpaces; }

  public int getJoggingPaths() { return this.joggingPaths; }

  public void setJoggingPaths(int joggingPaths) { this.joggingPaths = joggingPaths; }

  public String getCreatedUser() { return this.created_user; }

  public void setCreatedUser(String created_user) { this.created_user = created_user; }

  public String getCreatedDate() { return this.created_date; }

  public void setCreatedDate(String created_date) { this.created_date = created_date; }

  public String getLastEditedUser() { return this.last_edited_user; }

  public void setLastEditedUser(String last_edited_user) { this.last_edited_user = last_edited_user; }

  public String getLastEditedDate() { return this.last_edited_date; }

  public void setLastEditedDate(String last_edited_date) { this.last_edited_date = last_edited_date; }
}

