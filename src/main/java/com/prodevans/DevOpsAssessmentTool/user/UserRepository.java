package com.prodevans.DevOpsAssessmentTool.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	/**
	 * This method is defined for getting the user information by passing the email address.
	 * It returns the Set of optional collection
	 * @param email - User email address 
	 * @return - List of user having the address.
	 */
	@Query("FROM com.prodevans.DevOpsAssessmentTool.user.User u WHERE u.user_email=:email")
	Optional<User> getUserByEmail(@Param("email")String email); 
	
	
	@Query("FROM com.prodevans.DevOpsAssessmentTool.user.User u WHERE u.reset_token=:reset_token")
	Optional<User> findUserByResetToken(@Param("reset_token")String token); 
}
