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

/**
 * This class implements {@link ApplicationRunner} and is used to call the {@link LoadParks} class
 * on startup to populate the database with ABQ parks data.
 */
@Component
public class LoadData implements ApplicationRunner {

  private AmenityRepository amenityRepository;
  private ParkRepository parkRepository;

  /**
   * {@link LoadData} constructor used to auto wire {@link AmenityRepository} and
   * {@link ParkRepository} and set them to member fields.
   * @param amenityRepository AmenityRepository dao.
   * @param parkRepository ParkRepository dao.
   */
  @Autowired
  public LoadData(AmenityRepository amenityRepository,
      ParkRepository parkRepository) {
    this.amenityRepository = amenityRepository;
    this.parkRepository = parkRepository;
  }

  @Override
  public void run(ApplicationArguments args) {
    if (parkRepository.findAll().size() == 0) {
      new LoadParks(amenityRepository, parkRepository);
    }
  }
}