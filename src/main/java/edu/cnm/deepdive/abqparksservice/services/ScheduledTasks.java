package edu.cnm.deepdive.abqparksservice.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  // Midnight on the first of each month
  @Scheduled(cron = "* * 12 1 * *")
  

}
