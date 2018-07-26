package edu.cnm.deepdive.abqparksservice;

import edu.cnm.deepdive.abqparksservice.model.dao.AmenityRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ParkRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.ReviewRepository;
import edu.cnm.deepdive.abqparksservice.model.dao.UserRepository;
import edu.cnm.deepdive.abqparksservice.model.entity.Amenity;
import edu.cnm.deepdive.abqparksservice.model.entity.Park;
import edu.cnm.deepdive.abqparksservice.model.entity.Review;
import edu.cnm.deepdive.abqparksservice.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements ApplicationRunner {

  private UserRepository userRepository;
  private AmenityRepository amenityRepository;
  private ParkRepository parkRepository;
  private ReviewRepository reviewRepository;

  @Autowired
  public LoadData(UserRepository userRepository, AmenityRepository amenityRepository,
      ParkRepository parkRepository, ReviewRepository reviewRepository) {
    this.userRepository = userRepository;
    this.amenityRepository = amenityRepository;
    this.parkRepository = parkRepository;
    this.reviewRepository = reviewRepository;
  }

  @Override
  public void run(ApplicationArguments args) {
      Iterable<User> users = userRepository.findAll();
      if (!users.iterator().hasNext()) {
        addUsers();
        addAmenities();
        addParks();
        linkAmenities();
      }

  }

  private void addParks() {
    List<Park> parks = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Park park = new Park();
      park.setName("Park " + i);
      parks.add(park);
    }
    parkRepository.saveAll(parks);
  }

  private void addAmenities() {
    List<Amenity> amenities = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      Amenity amenity = new Amenity();
      amenity.setName("Amenity " + i);
      amenities.add(amenity);
    }
    amenityRepository.saveAll(amenities);
  }

  private void addUsers() {
    User user = new User();
    user.setFirstName("FirstName");
    user.setLastName("LastName");
    user.setUserEmail("Email@email.com");
    userRepository.save(user);
  }

  private void linkAmenities() {

    Random rng = new Random();
    rng.nextInt(9);
    List<Park> parks = parkRepository.findAll();
    List<Amenity> amenities = amenityRepository.findAll();
    List<Park> amenityParks;
    List<Amenity> parkAmenities;
    for (int i = 0; i < parks.size(); i++) {
      for (int j = 0; j < rng.nextInt(5); j++) {
        int random = rng.nextInt(19);
        parkAmenities = parks.get(i).getAmenities();
        if (!parkAmenities.contains(amenities.get(random))) {
          parks.get(i).getAmenities().add(amenities.get(random));
        }
        amenityParks = amenities.get(random).getParks();
        if (!amenityParks.contains(parks.get(i))) {
          amenities.get(random).getParks().add(parks.get(i));
        }
      }
    }
    amenityRepository.saveAll(amenities);
    parkRepository.saveAll(parks);
    System.out.println();
  }
}