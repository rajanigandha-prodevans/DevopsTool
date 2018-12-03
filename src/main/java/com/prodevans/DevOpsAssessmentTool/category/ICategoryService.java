package com.prodevans.DevOpsAssessmentTool.category;

import java.util.List;

import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

public interface ICategoryService {

	
	List<QuestionCategory> getAllCategories();
	
	List<AssessmentQuestion> getAssessmentQuestionByCategoryId(int category_id);
}
