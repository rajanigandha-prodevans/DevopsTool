package com.prodevans.DevOpsAssessmentTool.user;

import java.util.List;

import java.util.Optional;

import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySize;
import com.prodevans.DevOpsAssessmentTool.user.country.Country;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryType;

public interface IUserService {
	
	/**
	 * This method return the list of users present in the database
	 * @return - List of users present in the database
	 */
	List<User> getUsers();
	
	/**
	 * This method is used to get the user details by using the user_id
	 * @param user_id - Unique user_id
	 * @return - return the user information
	 */
	Optional<User> getUser(int user_id);
	
	/**
	 * This method is used to get the user details by the email address.
	 * @param email - email address given by the user
	 * @return - user details.
	 */
	Optional<User> findUserByEmail(String email);
	
	/**
	 * This method is used for create the user object in the database
	 * @param user
	 * @return
	 */
	User saveUser(UserRequestWrapper user);
	
	/**
	 * This method return list of company sizes
	 * @return - List of company sizes
	 */
	List<CompanySize> getAllCompanySizes();
	
	/**
	 * This method return list of countries
	 * @return - List of countries
	 */
	List<Country> getAllCountries();
	
	/**
	 * This method return list of Industries
	 * @return - List of Industries
	 */
	List<IndustryType> getAllIndustries();
	

	//void resetPassword(String email);
}
