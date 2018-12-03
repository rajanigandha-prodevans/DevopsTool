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
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

@Transactional
public class GetQuestionsByCategoryIdTest extends DevOpsAssessmentToolApplicationTests{

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
	public void getQuestionsByCategoryId()
	{
		int category_id=1;
		List<AssessmentQuestion> list=category_service.getAssessmentQuestionByCategoryId(category_id);
		System.out.println("Questions : "+ list.toString());
		assertEquals(list.size()>0, true);
	}
	
	@After
	public void cleanUp()
	{
		
	}
	
}
