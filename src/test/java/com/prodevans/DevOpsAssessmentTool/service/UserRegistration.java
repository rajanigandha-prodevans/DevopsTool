/**
 * Title	: UserRegistration.java
 * Date		: 2nd Aug 2018
 * Description	: This file is created for testing of user registration API and Service
 */
package com.prodevans.DevOpsAssessmentTool.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.user.IUserService;
import com.prodevans.DevOpsAssessmentTool.user.User;
import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
import com.prodevans.DevOpsAssessmentTool.user.UserRequestWrapper;
import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;

@Transactional
public class UserRegistration  extends DevOpsAssessmentToolApplicationTests {

	// Logger initialization
	final static private Logger logger  =  LoggerFactory.getLogger(UserRepository.class);
	
	// User object to insert data into the database
	private UserRequestWrapper user;
	
	// User service initialization
	@Autowired
	private IUserService user_service;	
	
	@Before
	public void setUserDetails() {
		user = new UserRequestWrapper();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setUserEmail("shyam@gmail.com");
		user.setCompanyName("ABC Technologies");
		user.setCompanySizeId(1);
		user.setCountryId(1);
		user.setIndustryTypeId(1);
		user.setUserPassword("admin");
		//user_repository.save(user);
	}
	
	@Test
	public void saveUser() {
		User newUser = null;
		 
		try {
			// Calling the register method
			newUser = user_service.saveUser(user);
			assertNotEquals(notNullValue(), newUser);
		}catch(Exception ee)
		{
			logger.error(ee.getStackTrace().toString());		
		}
	
		
	}
	
	
}
