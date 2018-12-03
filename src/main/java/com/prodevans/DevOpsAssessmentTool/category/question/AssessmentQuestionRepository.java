package com.prodevans.DevOpsAssessmentTool.category.question;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AssessmentQuestionRepository extends CrudRepository<AssessmentQuestion, Integer> {
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion a JOIN a.questionCategory c where c.category_id=:category_id")
	List<AssessmentQuestion> getAssessmentQuestionsByCategoryId(@Param("category_id")int category_id);
	
	/**
	 * This method is created for getting the count of questions present in the particular category 
	 * @param category_id	- category id for the identify the category
	 * @return				- count of question present in the category
	 */
	@Query("SELECT COUNT(q) FROM AssessmentQuestion q "
			+ "JOIN q.questionCategory c "
			+ "WHERE c.category_id=:category_id")
	public Integer getQuestionCountInCategory(@Param("category_id") Integer category_id);
}
