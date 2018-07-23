package edu.cnm.deepdive.abqparksservice.model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;


@Component
@Entity
public class Park {

  private static EntityLinks entityLinks;

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Park.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "park_id", nullable = false, updatable = false)
  private long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(name = "location", nullable = false)
  private double lat;
  private double lng;

  @Column(name = "play_areas")
  private int playArea;

  @Column(name = "full_ball_court")
  private int fullBallCourt;

  @Column(name = "half_ball_court")
  private int halfBallCourt;

  @Column(name = "soccer")
  private int soccer;

  @Column(name = "softball")
  private int softball;

  @Column(name = "youth_ball")
  private int youthBall;

  @Column(name = "indoor_pool")
  private int indoorPool;

  @Column(name = "outdoor_pool")
  private int outdoorPool;

  @Column(name = "horseshoe_pit")
  private int horseshoePit;

  @Column(name = "volleyball_court")
  private int volleyball;

  @Column(name = "backstops")
  private int backstop;

  @Column(name = "picnic_tables")
  private int picnicTables;

  @Column(name = "shade_structures")
  private int shadeStructures;

  @Column(name = "jogging_paths")
  private int joggingPath;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "park", cascade = CascadeType.DETACH)
  @OrderBy("DESC")
  private List<Review> reviews;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }

  public int getPlayArea() {
    return playArea;
  }

  public void setPlayArea(int playArea) {
    this.playArea = playArea;
  }

  public int getFullBallCourt() {
    return fullBallCourt;
  }

  public void setFullBallCourt(int fullBallCourt) {
    this.fullBallCourt = fullBallCourt;
  }

  public int getHalfBallCourt() {
    return halfBallCourt;
  }

  public void setHalfBallCourt(int halfBallCourt) {
    this.halfBallCourt = halfBallCourt;
  }

  public int getSoccer() {
    return soccer;
  }

  public void setSoccer(int soccer) {
    this.soccer = soccer;
  }

  public int getSoftball() {
    return softball;
  }

  public void setSoftball(int softball) {
    this.softball = softball;
  }

  public int getYouthBall() {
    return youthBall;
  }

  public void setYouthBall(int youthBall) {
    this.youthBall = youthBall;
  }

  public int getIndoorPool() {
    return indoorPool;
  }

  public void setIndoorPool(int indoorPool) {
    this.indoorPool = indoorPool;
  }

  public int getOutdoorPool() {
    return outdoorPool;
  }

  public void setOutdoorPool(int outdoorPool) {
    this.outdoorPool = outdoorPool;
  }

  public int getHorseshoePit() {
    return horseshoePit;
  }

  public void setHorseshoePit(int horseshoePit) {
    this.horseshoePit = horseshoePit;
  }

  public int getVolleyball() {
    return volleyball;
  }

  public void setVolleyball(int volleyball) {
    this.volleyball = volleyball;
  }

  public int getBackstop() {
    return backstop;
  }

  public void setBackstop(int backstop) {
    this.backstop = backstop;
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

  public int getJoggingPath() {
    return joggingPath;
  }

  public void setJoggingPath(int joggingPath) {
    this.joggingPath = joggingPath;
  }
}
