package edu.cnm.deepdive.abqparksservice.services;

import com.google.gson.Gson;
import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import edu.cnm.deepdive.abqparksservice.services.entity.Attributes;
import edu.cnm.deepdive.abqparksservice.services.entity.Feature;
import edu.cnm.deepdive.abqparksservice.services.entity.Geometry;

import edu.cnm.deepdive.abqparksservice.services.entity.RootObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadParks {

  private RootObject jsonParks;

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
  }

  public void readJson() {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("parks.json"));
    } catch (FileNotFoundException e) {
      //Do something for now!
      e.printStackTrace();
    }
    jsonParks = new Gson().fromJson(reader, RootObject.class);
    loadAmenities();
    loadParks();
    parkRepository.saveAll(parks);
    amenityRepository.saveAll(amenities);
  }

  private void loadParks() {
    for (Feature features : jsonParks.getFeatures()) {
      Attributes attributes = features.getAttributes();
      Geometry geometry = features.getGeometry();
      Park park = new Park();
      park.setName(attributes.getPARKNAME());
      setParkAmenities(attributes, park);
      // TODO Set to center of park or array of lat/long
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
    if (attributes.getLITTENNISCOURTS() > 0 || attributes.getUNLITTENNISCOURTS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.LITTENNISCOURTS.ordinal()));
    }
    if (attributes.getPLAYAREAS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PLAYAREAS.ordinal()));
    }
    if (attributes.getFULLBASKETBALLCOURTS() > 0 || attributes.getHALFBASKETBALLCOURTS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.FULLBASKETBALLCOURTS.ordinal()));
    }
    if (attributes.getSOCCERFIELDS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.SOCCERFIELDS.ordinal()));
    }
    if (attributes.getLITSOFTBALLFIELDS() > 0 || attributes.getUNLITSOFTBALLFIELDS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.LITSOFTBALLFIELDS.ordinal()));
    }
    if (attributes.getYOUTHBALLFIELDS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.YOUTHBALLFIELDS.ordinal()));
    }
    if (attributes.getINDOORPOOLS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.INDOORPOOLS.ordinal()));
    }
    if (attributes.getOUTDOORPOOLS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.OUTDOORPOOLS.ordinal()));
    }
    if (attributes.getHORSESHOEPITS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.HORSESHOEPITS.ordinal()));
    }
    if (attributes.getVOLLEYBALLCOURTS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.VOLLEYBALLCOURTS.ordinal()));
    }
    if (attributes.getBACKSTOPS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.BACKSTOPS.ordinal()));
    }
    if (attributes.getPICNICTABLES() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PICNICTABLES.ordinal()));
    }
    if (attributes.getSHADESTRUCTURES() > 0) {
      park.getAmenities().add(amenities.get(Amenities.SHADESTRUCTURES.ordinal()));
    }
    if (attributes.getPARKINGSPACES() > 0) {
      park.getAmenities().add(amenities.get(Amenities.PARKINGSPACES.ordinal()));
    }
    if (attributes.getJOGGINGPATHS() > 0) {
      park.getAmenities().add(amenities.get(Amenities.JOGGINGPATHS.ordinal()));
    }
  }

  private void loadAmenities() {
    for (Amenities a : Amenities.values()) {
      Amenity amenity = new Amenity();
      amenity.setName(a.toString());
      amenities.add(amenity);
    }
  }

  private static final double RADIUS = 6378137.0; /* in meters on the equator */

  /* These functions take their length parameter in meters and return an angle in degrees */
  private static double y2lat(double aY) {
    return Math.toDegrees(Math.atan(Math.exp(aY / RADIUS)) * 2 - Math.PI / 2);
  }

  private static double x2lon(double aX) {
    return Math.toDegrees(aX / RADIUS);
  }
}
