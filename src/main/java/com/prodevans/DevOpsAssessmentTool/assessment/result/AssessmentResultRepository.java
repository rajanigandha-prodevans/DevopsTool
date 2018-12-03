package com.prodevans.DevOpsAssessmentTool.assessment.result;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentResultRepository extends CrudRepository<AssessmentResult, Integer>{
	
	/**
	 * This method is created for the checking weather the result is present for particular assessment and category id
	 * @param asssessment_id	- identify the particular assessment
	 * @param category_id		- The category
	 * @return 					- The present result information for update 
	 */
	@Query("SELECT r FROM com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult r "
			+ "JOIN r.assessment a JOIN r.question_category c "
			+ "WHERE a.assessment_id=:asssessment_id AND c.category_id=:category_id")
	public Optional<AssessmentResult> getAssessmentResultByCategoryAndAssessent(@Param("asssessment_id") Integer asssessment_id, @Param("category_id") Integer category_id);
	
	
	/**
	 * This method is created for getting the assessment result
	 * @param asssessment_id	- identify the particular assessment
	 * @return 					- The result information for an assessment 
	 */
	@Query("SELECT r FROM com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult r "
			+ "JOIN r.assessment a JOIN r.question_category c "
			+ "WHERE a.assessment_id=:asssessment_id")
	public List<AssessmentResult> getAssessmentResultByAssessent(@Param("asssessment_id") Integer asssessment_id);
}
