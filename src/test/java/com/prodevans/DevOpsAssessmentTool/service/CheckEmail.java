package com.prodevans.DevOpsAssessmentTool.service;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.user.IUserService;
import com.prodevans.DevOpsAssessmentTool.user.User;
import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;

@Transactional
public class CheckEmail extends DevOpsAssessmentToolApplicationTests  {
	
	// User object to insert data into the database
	private User user;
	
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
		user_repository.save(user);
	}
	
	/**
	 * This test case is defined for checking the email is present on the database or not
	 */
	@Test
	public void verifyEmail() {
		// user email address
		String user_email = "shyam@gmail.com";
		
		// checking the email address present or not
		Boolean result = user_service.findUserByEmail(user_email).isPresent();
		
		
		// Asserting the information in the console
		assertEquals(true, result);
	}
	
	
	@After
	public void cleanUp() {
		user_repository.delete(user);
	}
}
