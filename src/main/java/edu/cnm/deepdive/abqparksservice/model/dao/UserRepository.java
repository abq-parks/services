package edu.cnm.deepdive.abqparksservice.model.dao;

import edu.cnm.deepdive.abqparksservice.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}