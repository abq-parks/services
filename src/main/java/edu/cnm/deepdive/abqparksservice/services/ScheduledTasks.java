package edu.cnm.deepdive.abqparksservice.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {

  private ParkJson jsonPark;

  private static final String ABQ_PARK_URL =
      "http://coagisweb.cabq.gov/arcgis/rest/services/public/recreation/MapServer/0/query?"
      + "where=1%3D1&text=&objectIds=&time=&geometry=&geometryType=esriGeometryEnvelope"
      + "&inSR=&spatialRel=esriSpatialRelIntersects&relationParam=&outFields=*&returnGeometry=true"
      + "&maxAllowableOffset=&geometryPrecision=&outSR=&returnIdsOnly=false&returnCountOnly=false"
      + "&orderByFields=&groupByFieldsForStatistics=&outStatistics=&returnZ=false&returnM=false"
      + "&gdbVersion=&f=pjson";

  // Midnight on the first of each month
  // TODO: implement exception handling
  @Scheduled(cron = "* * 0 1 * *")
  public void retrieveData () {
    jsonPark = new ParkJson();
    RestTemplate template = new RestTemplate();
    jsonPark = template.getForObject(ABQ_PARK_URL, ParkJson.class);
    populateDatabase();
  }

  public void populateDatabase() {

  }

}
