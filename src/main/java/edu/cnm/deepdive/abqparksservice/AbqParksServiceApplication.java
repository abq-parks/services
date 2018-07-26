package edu.cnm.deepdive.abqparksservice;

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
    ParkJson json = new ParkJson();
  }
}
