package edu.cnm.deepdive.abqparksservice.services;

import com.google.gson.Gson;
import edu.cnm.deepdive.abqparksservice.services.entity.RootObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private RootObject jsonPark;

  private static final String ABQ_PARK_URL =
      "http://coagisweb.cabq.gov/arcgis/rest/services/public/recreation/MapServer/0/query?where=1%3D1&outFields=*&f=json";

  // Midnight on the first of each month
  // TODO: implement exception handling
  @Scheduled(cron = "* * 0 1 * *")
  public void retrieveData () {

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("parks.json"));
    } catch (FileNotFoundException e) {
      //Do something for now!
      e.printStackTrace();
    }

    jsonPark = new Gson().fromJson(reader, RootObject.class);
    populateDatabase();
  }

  public void populateDatabase() {

  }

}
