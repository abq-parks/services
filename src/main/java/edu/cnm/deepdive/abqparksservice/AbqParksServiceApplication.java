package edu.cnm.deepdive.abqparksservice;

import edu.cnm.deepdive.abqparksservice.services.ScheduledTasks;
import edu.cnm.deepdive.abqparksservice.services.entity.RootObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableEntityLinks
@SpringBootApplication
public class AbqParksServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AbqParksServiceApplication.class, args);

    ScheduledTasks task = new ScheduledTasks();
    task.retrieveData();
  }
}
