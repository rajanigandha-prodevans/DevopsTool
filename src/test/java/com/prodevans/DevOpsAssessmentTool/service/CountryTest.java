package com.prodevans.DevOpsAssessmentTool.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.user.IUserService;
import com.prodevans.DevOpsAssessmentTool.user.country.Country;



@Transactional
public class CountryTest extends DevOpsAssessmentToolApplicationTests{
	
	@Autowired
	private IUserService user_service;
	
	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}
	
	@Before
	public void init() {
		
	}
	
	/**
	 * This test case is defined to get all the countries are present in the database
	 */
	@Test
	public void checkCountry() {
		
		// Calling the method
		List<Country> countries=user_service.getAllCountries();
		
		// Checking the result
		assertEquals(true, countries.size()>0);
	}
	
	@After
	public void cleanUp() {
		
	}
	

}
