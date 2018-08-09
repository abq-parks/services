package edu.cnm.deepdive.abqparksservice.services.entity;

import com.google.gson.annotations.SerializedName;

/**
 * This class is used to store all parks attributes and amenities.
 */
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

  /**
   * Returns the object Id for the park.
   * @return the object Id for the park.
   */
  public int getObjectId() { return this.objectId; }

  /**
   * Sets the object Id for the park.
   * @param objectId the object Id for the park.
   */
  public void setObjectId(int objectId) { this.objectId = objectId; }

  /**
   * Returns the name of the park.
   * @return the name of the park.
   */
  public String getParkName() { return this.parkName; }

  /**
   * Sets the name of the park.
   * @param parkName the name of the park.
   */
  public void setParkName(String parkName) { this.parkName = parkName; }

  /**
   * Returns the status of the park.
   * @return the status of the park.
   */
  public String getParkStatus() { return this.parkStatus; }

  /**
   * Sets the status of the park.
   * @param parkStatus the status of the park.
   */
  public void setParkStatus(String parkStatus) { this.parkStatus = parkStatus; }

  /**
   * Returns the jurisdiction the park is in.
   * @return the jurisdiction the park is in.
   */
  public String getJurisdiction() { return this.jurisdiction; }

  /**
   * Sets the jurisdiction the park is in.
   * @param jurisdiction the jurisdiction the park is in.
   */
  public void setJurisdiction(String jurisdiction) { this.jurisdiction = jurisdiction; }

  /**
   * Returns the size of the park in acres.
   * @return the size of the park in acres.
   */
  public double getAcres() { return this.acres; }

  /**
   * Sets the size of the park. Should be in acres.
   * @param acres the size of the park in acres.
   */
  public void setAcres(double acres) { this.acres = acres; }

  /**
   * Returns the total acres that have been developed for the park.
   * @return the total acres that have been developed for the park.
   */
  public double getDevelopedAcres() { return this.developedAcres; }

  /**
   * Sets the total acres that have been developed for the park.
   * @param developedAcres the total acres that have been developed for the park.
   */
  public void setDevelopedAcres(double developedAcres) { this.developedAcres = developedAcres; }

  /**
   * Returns the number of tennis courts with lights that the park contains.
   * @return the number of tennis courts with lights that the park contains.
   */
  public int getLitTennisCourts() { return this.litTennisCourts; }

  /**
   * Sets the number of tennis courts with lights that the park contains..
   * @param litTennisCourts the number of tennis courts with lights that the park contains..
   */
  public void setLitTennisCourts(int litTennisCourts) { this.litTennisCourts = litTennisCourts; }

  /**
   * Returns the number of tennis courts without lights that the park contains.
   * @return the number of tennis courts without lights that the park contains.
   */
  public int getUnlitTennisCourts() { return this.unlitTennisCourts; }

  /**
   * Sets the number of tennis courts without lights that the park contains.
   * @param unlitTennisCourts the number of tennis courts without lights that the park contains.
   */
  public void setUnlitTennisCourts(int unlitTennisCourts) { this.unlitTennisCourts = unlitTennisCourts; }

  /**
   * Returns the number of play areas that the park contains.
   * @return the number of play areas that the park contains.
   */
  public int getPlayAreas() { return this.playAreas; }

  /**
   * Sets the number of play areas that the park contains.
   * @param playAreas the number of play areas that the park contains.
   */
  public void setPlayAreas(int playAreas) { this.playAreas = playAreas; }

  /**
   * Returns the number of full size basketball courts that the park contains.
   * @return the number of full size basketball courts that the park contains.
   */
  public int getFullBasketballCourts() { return this.fullBasketballCourts; }

  /**
   * Sets the number of full size basketball courts that the park contains.
   * @param fullBasketballCourts the number of full size basketball courts that the park contains.
   */
  public void setFullBasketballCourts(int fullBasketballCourts) { this.fullBasketballCourts = fullBasketballCourts; }

  /**
   * Returns the number of half size basketball courts that the park contains.
   * @return the number of half size basketball courts that the park contains.
   */
  public int getHalfBasketballCourts() { return this.halfBasketballCourts; }

  /**
   * Sets the number of half size basketball courts that the park contains.
   * @param halfBasketballCourts the number of half size basketball courts that the park contains.
   */
  public void setHalfBasketballCourts(int halfBasketballCourts) { this.halfBasketballCourts = halfBasketballCourts; }

  /**
   * Returns the number of soccer fields that the park contains.
   * @return the number of soccer fields that the park contains.
   */
  public int getSoccerFields() { return this.soccerFields; }

  /**
   * Sets the number of soccer fields that the park contains.
   * @param soccerFields the number of soccer fields that the park contains.
   */
  public void setSoccerFields(int soccerFields) { this.soccerFields = soccerFields; }

  /**
   * Returns the number of softball fields with lights that the park contains.
   * @return the number of softball fields with lights that the park contains.
   */
  public int getLitSoftballFields() { return this.litSoftballFields; }

  /**
   * Sets the number of softball fields with lights that the park contains.
   * @param litSoftballFields the number of softball fields with lights that the park contains.
   */
  public void setLitSoftballFields(int litSoftballFields) { this.litSoftballFields = litSoftballFields; }

  /**
   * Returns the number of softball fields without lights that the park contains.
   * @return the number of softball fields without lights that the park contains.
   */
  public int getUnlitSoftballFields() { return this.unlitSoftballFields; }

  /**
   * Sets the number of softball fields without lights that the park contains.
   * @param unlitSoftballFields the number of softball fields without lights that the park contains.
   */
  public void setUnlitSoftballFields(int unlitSoftballFields) { this.unlitSoftballFields = unlitSoftballFields; }

  /**
   * Returns the number of youth ball fields that the park contains.
   * @return the number of youth ball fields that the park contains.
   */
  public int getYouthballFields() { return this.youthballFields; }

  /**
   * Sets the number of youth ball fields that the park contains.
   * @param youthballFields the number of youth ball fields that the park contains.
   */
  public void setYouthballFields(int youthballFields) { this.youthballFields = youthballFields; }

  /**
   * Returns the number of indoor pools that the park contains.
   * @return the number of indoor pools that the park contains.
   */
  public int getIndoorPools() { return this.indoorPools; }

  /**
   * Sets the number of indoor pools that the park contains.
   * @param indoorPools the number of indoor pools that the park contains.
   */
  public void setIndoorPools(int indoorPools) { this.indoorPools = indoorPools; }

  /**
   * Returns the number of outdoor pools that the park contains.
   * @return the number of outdoor pools that the park contains.
   */
  public int getOutdoorPools() { return this.outdoorPools; }

  /**
   * Sets the number of outdoor pools that the park contains.
   * @param outdoorPools the number of outdoor pools that the park contains.
   */
  public void setOutdoorPools(int outdoorPools) { this.outdoorPools = outdoorPools; }

  /**
   * Returns the number of horseshoe pits that the park contains.
   * @return the number of horseshoe pits that the park contains.
   */
  public int getHorseshoePits() { return this.horseshoePits; }

  /**
   * Sets the number of horseshoe pits that the park contains.
   * @param horseshoePits the number of horseshoe pits that the park contains.
   */
  public void setHorseshoePits(int horseshoePits) { this.horseshoePits = horseshoePits; }

  /**
   * Returns the number of volleyball courts that the park contains.
   * @return the number of volleyball courts that the park contains.
   */
  public int getVolleyballCourts() { return this.volleyballCourts; }

  /**
   * Sets the number of volleyball courts that the park contains.
   * @param volleyballCourts the number of volleyball courts that the park contains.
   */
  public void setVolleyballCourts(int volleyballCourts) { this.volleyballCourts = volleyballCourts; }

  /**
   * Returns the number of backstops that the park contains.
   * @return the number of backstops that the park contains.
   */
  public int getBackstops() { return this.backstops; }

  /**
   * Sets the number of backstops that the park contains.
   * @param backstops the number of backstops that the park contains.
   */
  public void setBackstops(int backstops) { this.backstops = backstops; }

  /**
   * Returns the number of picnic tables that the park contains.
   * @return the number of picnic tables that the park contains.
   */
  public int getPicnictables() { return this.picnictables; }

  /**
   * Sets the number of picnic tables that the park contains.
   * @param picnictables the number of picnic tables that the park contains.
   */
  public void setPicnictables(int picnictables) { this.picnictables = picnictables; }

  /**
   * Returns the number of shade structures that the park contains.
   * @return the number of shade structures that the park contains.
   */
  public int getShadeStructures() { return this.ShadeStructures; }

  /**
   * Sets the number of shade structures that the park contains.
   * @param shadeStructures the number of shade structures that the park contains.
   */
  public void setShadeStructures(int shadeStructures) { this.ShadeStructures = shadeStructures; }

  /**
   * Returns the number of parking spaces that the park contains.
   * @return the number of parking spaces that the park contains.
   */
  public int getParkingSpaces() { return this.parkingSpaces; }

  /**
   * Sets the number of parking spaces that the park contains.
   * @param parkingSpaces the number of parking spaces that the park contains.
   */
  public void setParkingSpaces(int parkingSpaces) { this.parkingSpaces = parkingSpaces; }

  /**
   * Returns the number of jogging paths that the park contains.
   * @return the number of jogging paths that the park contains.
   */
  public int getJoggingPaths() { return this.joggingPaths; }

  /**
   * Sets the number of jogging paths that the park contains.
   * @param joggingPaths the number of jogging paths that the park contains.
   */
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

