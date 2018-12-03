package com.prodevans.DevOpsAssessmentTool.service;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.user.IUserService;


@Transactional
public class CompanySizeTest extends DevOpsAssessmentToolApplicationTests {
	
	// Creating the object for the User service
	@Autowired
	private IUserService user_service;
	
	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void checkCompanySize() {
		
		// Calling the method
		List<com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySize> company_size_list = user_service.getAllCompanySizes();
		
		// Checking the result
		assertEquals(true, company_size_list.size() > 0);
		
	}
	
	@After
	public void cleanUp() {
		
	}
}
