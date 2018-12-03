package com.prodevans.DevOpsAssessmentTool.category;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

@RestController
@RequestMapping(value="/api")
public class CategoryController {
	
	private final static Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private ICategoryService category_service;
	
	public void setCategory_service(ICategoryService category_service) {
		this.category_service = category_service;
	}
	
	@GetMapping(value="/categories")
	public List<QuestionCategory> getAllCategories()
	{
		logger.error("categories:"+category_service.getAllCategories());
		return category_service.getAllCategories();
		
	}

	@GetMapping(value="/categories/{category_id}/questions")
	public List<AssessmentQuestion> getAssessmentQuestionByCategoryId(@PathVariable(name="category_id")int category_id)
	{
		return category_service.getAssessmentQuestionByCategoryId(category_id);
		
	}
	
}
