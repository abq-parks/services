package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface extends {@link CrudRepository} and is used to query the user table.
 */
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * Query to find a certain user by their google ID.
   * @param googleID users google ID.
   * @return the user if found.
   */
  User findByGoogleID(String googleID);

}