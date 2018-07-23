package edu.cnm.deepdive.abqparksservice.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Amenitites {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "amenities_id", nullable = false, updatable = false)
  private long id;

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
}
