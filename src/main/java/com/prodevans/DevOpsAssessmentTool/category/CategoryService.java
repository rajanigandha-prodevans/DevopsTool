package com.prodevans.DevOpsAssessmentTool.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestionRepository;

@Service
public class CategoryService implements ICategoryService {

	final private static Logger logger=LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private QuestionCategoryRepository question_category_repository;
	
	@Autowired
	private AssessmentQuestionRepository assessment_question_repository;
	
	
	public void setQuestion_category_repository(QuestionCategoryRepository question_category_repository) {
		this.question_category_repository = question_category_repository;
	}

	public void setAssessment_question_repository(AssessmentQuestionRepository assessment_question_repository) {
		this.assessment_question_repository = assessment_question_repository;
	}
	
	@Override
	public List<QuestionCategory> getAllCategories() {
		
		List<QuestionCategory> list=new ArrayList<>();
		try 
		{
			question_category_repository.findAll().forEach(e->list.add(e));
		}
		catch (Exception e) {
			logger.error("No categories Found");
			return new ArrayList<QuestionCategory>();
		}
		logger.error("Category list"+list);

		// Sorting the categories
		Collections.sort(list);

		return list;
	}

	@Override
	public List<AssessmentQuestion> getAssessmentQuestionByCategoryId(int category_id) {
		
		List<AssessmentQuestion> list=assessment_question_repository.getAssessmentQuestionsByCategoryId(category_id);
		return list;
	}


}
