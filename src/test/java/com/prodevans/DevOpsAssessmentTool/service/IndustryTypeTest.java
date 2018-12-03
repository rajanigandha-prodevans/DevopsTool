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
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryType;

@Transactional
public class IndustryTypeTest extends DevOpsAssessmentToolApplicationTests{
	
	@Autowired
	private IUserService user_services;
	
	public void setUser_services(IUserService user_services) {
		this.user_services = user_services;
	}
	
	@Before
	public void init()
	{
		
	}
	
	/**
	 * This test case is defined to get all the industries are present in the database
	 */
	@Test
	public void getAllIndustries()
	{
		// Calling the method
		List<IndustryType> industry_type=user_services.getAllIndustries();
		
		// Checking the result
		assertEquals(true, industry_type.size()>0);
		
	}
	
	@After
	public void cleanUP()
	{
		
	}

}
