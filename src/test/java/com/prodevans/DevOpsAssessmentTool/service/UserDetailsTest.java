/**
 * Title	: UserDetailsTest.java
 * Date		: 10th Aug 2018
 * Description	: This test is created for the checking of user details for specific user
 */
package com.prodevans.DevOpsAssessmentTool.service;

import static org.testng.Assert.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.user.IUserService;
import com.prodevans.DevOpsAssessmentTool.user.User;
import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;

@Transactional
public class UserDetailsTest extends DevOpsAssessmentToolApplicationTests {
	// Logger initialization
	final static private Logger logger = LoggerFactory.getLogger(UserRepository.class);

	// User object to insert data into the database
	private User user;
	
	private User newUser;

	// User service initialization
	@Autowired
	private IUserService user_service;

	@Autowired
	private UserRepository user_repository;

	@Autowired
	private CountryRepository country_repository;

	@Autowired
	private IndustryTypeRepository industry_repository;

	@Autowired
	private CompanySizeRepository company_size_repository;

	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}

	public void setUser_repository(UserRepository user_repository) {
		this.user_repository = user_repository;
	}

	public void setCountry_repository(CountryRepository country_repository) {
		this.country_repository = country_repository;
	}

	public void setIndustry_repository(IndustryTypeRepository industry_repository) {
		this.industry_repository = industry_repository;
	}

	public void setCompany_size_repository(CompanySizeRepository company_size_repository) {
		this.company_size_repository = company_size_repository;
	}

	@Before
	public void setUserDetails() {
		user = new User();
		user.setFirst_name("Ram");
		user.setLast_name("Sharma");
		user.setUser_email("shyam@gmail.com");
		user.setCompanyName("ABC Technologies");
		user.setCompanySize(company_size_repository.findById(1).get());
		user.setCountry(country_repository.findById(1).get());
		user.setIndustryType(industry_repository.findById(1).get());
		newUser = user_repository.save(user);
	}

	/**
	 * Checking for valid user the method is performing the expected tasks
	 */
	@Test
	public void checkValidUser() {
		// Getting the user details form the DB
		Optional<User> users = user_service.getUser(user.getUser_id());

		// Checking the result
		assertEquals(users.isPresent(), true);
		
		logger.info("Checking for valid user test passed");
	}

	/**
	 * Checking for invalid user the method is showing the null or empty details.
	 */
	@Test
	public void checkInvalidUser() {
		// Getting the user details form the DB
		Optional<User> student = user_service.getUser(0);

		// Checking the result
		assertEquals( student.isPresent(), false);
		
		logger.info("Checking for invalid user test passed");
	}

	@After
	public void cleanUp() {
		user_repository.delete(newUser);
	}

}
