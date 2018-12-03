package com.prodevans.DevOpsAssessmentTool.service;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
import com.prodevans.DevOpsAssessmentTool.category.ICategoryService;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;

@Transactional
public class GetAllCategoriesTest extends DevOpsAssessmentToolApplicationTests {

	@Autowired
	private ICategoryService category_service;
	
	public void setCategory_service(ICategoryService category_service) {
		this.category_service = category_service;
	}
	
	@Before
	public void init()
	{
		
	}
	
	@Test
	public void getAllCountries()
	{
		List<QuestionCategory> categories=category_service.getAllCategories();
		//System.out.println("Categories: "+categories);
		assertEquals(true, categories.size()>0);
	}
	
	@After
	public void cleanUp()
	{
		
	}
	
}
