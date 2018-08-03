package edu.cnm.deepdive.abqparksservice;

import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.UserRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.User;
import edu.cnm.deepdive.abqparksservice.services.LoadParks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements ApplicationRunner {

  private AmenityRepository amenityRepository;
  private ParkRepository parkRepository;
  private UserRepository userRepository;

  @Autowired
  public LoadData(AmenityRepository amenityRepository,
      ParkRepository parkRepository, UserRepository userRepository) {
    this.amenityRepository = amenityRepository;
    this.parkRepository = parkRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) {
    if (parkRepository.findAll().size() == 0) {
      LoadParks loadParks = new LoadParks(amenityRepository, parkRepository);
      loadParks.readJson();
      User defaultUser = new User();
      defaultUser.setFirstName("Default");
      defaultUser.setLastName("User");
      defaultUser.setUserEmail("Default@email.com");
      userRepository.save(defaultUser);
      User defaultUser2 = new User();
      defaultUser2.setFirstName("Default");
      defaultUser2.setLastName("User 2");
      defaultUser2.setUserEmail("Default2@email.com");
      userRepository.save(defaultUser2);
    }
  }
}