package edu.cnm.deepdive.abqparksservice.services;

import com.google.gson.Gson;
import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import edu.cnm.deepdive.abqparksservice.services.entity.Attributes;
import edu.cnm.deepdive.abqparksservice.services.entity.Parks;
import edu.cnm.deepdive.abqparksservice.services.entity.Geometry;

import edu.cnm.deepdive.abqparksservice.services.entity.ParksRoot;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadParks {

  private ParksRoot jsonParks;

  private AmenityRepository amenityRepository;
  private ParkRepository parkRepository;
  private List<Park> parks = new ArrayList<>();
  private List<Amenity> amenities = new ArrayList<>();

  private enum Amenities {
    LITTENNISCOURTS,
    UNLITTENNISCOURTS,
    PLAYAREAS,
    FULLBASKETBALLCOURTS,
    HALFBASKETBALLCOURTS,
    SOCCERFIELDS,
    LITSOFTBALLFIELDS,
    UNLITSOFTBALLFIELDS,
    YOUTHBALLFIELDS,
    INDOORPOOLS,
    OUTDOORPOOLS,
    HORSESHOEPITS,
    VOLLEYBALLCOURTS,
    BACKSTOPS,
    PICNICTABLES,
    SHADESTRUCTURES,
    PARKINGSPACES,
    JOGGINGPATHS
  }

  public LoadParks(AmenityRepository amenityRepository, ParkRepository parkRepository) {
    this.amenityRepository = amenityRepository;
    this.parkRepository = parkRepository;
    readJson();
  }

  private void readJson() {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("parks.json"));
    } catch (FileNotFoundException e) {
      //Do Nothing!
    }
    jsonParks = new Gson().fromJson(reader, ParksRoot.class);
    loadAmenities();
    loadParks();
    parkRepository.saveAll(parks);
    amenityRepository.saveAll(amenities);
  }

  private void loadParks() {
    for (Parks features : jsonParks.getParks()) {
      Attributes attributes = features.getAttributes();
      Geometry geometry = features.getGeometry();
      Park park = new Park();
      park.setName(attributes.getParkName());
      setParkAmenities(attributes, park);
      findCenter(geometry, park);
      parks.add(park);
    }
  }

  private void findCenter(Geometry geometry, Park park) {
    // Not the correct way to do this but it will do for now.
    double latitude = 0.0;
    double longitude = 0.0;
    int numPoints = geometry.getRings().get(0).size();
    for (int i = 0; i < numPoints; i++) {
      latitude += y2lat(geometry.getRings().get(0).get(i).get(1));
      longitude += x2lon(geometry.getRings().get(0).get(i).get(0));
    }
    park.setLatitude(latitude/numPoints);
    park.setLongitude(longitude/numPoints);
  }

  private void setParkAmenities(Attributes attributes, Park park) {
    if (attributes.getLitTennisCourts() > 0 || attributes.getUnlitTennisCourts() > 0) {
      park.getAmenities().add(amenities.get(Amenities.LITTENNISCOURTS.ordinal()));
    }
    if (attributes.getPlayAreas() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PLAYAREAS.ordinal()));
    }
    if (attributes.getFullBasketballCourts() > 0 || attributes.getHalfBasketballCourts() > 0) {
      park.getAmenities().add(amenities.get(Amenities.FULLBASKETBALLCOURTS.ordinal()));
    }
    if (attributes.getSoccerFields() > 0) {
      park.getAmenities().add(amenities.get(Amenities.SOCCERFIELDS.ordinal()));
    }
    if (attributes.getLitSoftballFields() > 0 || attributes.getUnlitSoftballFields() > 0) {
      park.getAmenities().add(amenities.get(Amenities.LITSOFTBALLFIELDS.ordinal()));
    }
    if (attributes.getYouthballFields() > 0) {
      park.getAmenities().add(amenities.get(Amenities.YOUTHBALLFIELDS.ordinal()));
    }
    if (attributes.getIndoorPools() > 0) {
      park.getAmenities().add(amenities.get(Amenities.INDOORPOOLS.ordinal()));
    }
    if (attributes.getOutdoorPools() > 0) {
      park.getAmenities().add(amenities.get(Amenities.OUTDOORPOOLS.ordinal()));
    }
    if (attributes.getHorseshoePits() > 0) {
      park.getAmenities().add(amenities.get(Amenities.HORSESHOEPITS.ordinal()));
    }
    if (attributes.getVolleyballCourts() > 0) {
      park.getAmenities().add(amenities.get(Amenities.VOLLEYBALLCOURTS.ordinal()));
    }
    if (attributes.getBackstops() > 0) {
      park.getAmenities().add(amenities.get(Amenities.BACKSTOPS.ordinal()));
    }
    if (attributes.getPicnictables() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PICNICTABLES.ordinal()));
    }
    if (attributes.getShadeStructures() > 0) {
      park.getAmenities().add(amenities.get(Amenities.SHADESTRUCTURES.ordinal()));
    }
    if (attributes.getParkingSpaces() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PARKINGSPACES.ordinal()));
    }
    if (attributes.getJoggingPaths() > 0) {
      park.getAmenities().add(amenities.get(Amenities.JOGGINGPATHS.ordinal()));
    }
  }

  private void loadAmenities() {
    for (Amenities a : Amenities.values()) {
      Amenity amenity = new Amenity();
      amenity.setName(a.toString());
      String displayName = jsonParks.getFieldAliases().get(a.toString());
      if (displayName.equals("Lit Tennis Courts") || displayName.equals("Unlit Tennis Courts")) {
        displayName = "Tennis Courts";
      }
      if (displayName.equals("Full Basketball Courts") || displayName.equals("Half Basketball Courts")) {
        displayName = "Basketball Courts";
      }
      if (displayName.equals("Lit Softball Fields") || displayName.equals("Unlit Softball Fields")) {
        displayName = "Softball Fields";
      }
      amenity.setDisplayName(displayName);
      amenities.add(amenity);
    }
  }

  private static final double RADIUS = 6378137.0;

  private double y2lat(double aY) {
    return Math.toDegrees(Math.atan(Math.exp(aY / RADIUS)) * 2 - Math.PI / 2);
  }

  private double x2lon(double aX) {
    return Math.toDegrees(aX / RADIUS);
  }
}
