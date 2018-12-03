package com.prodevans.DevOpsAssessmentTool.assessment.process;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AssessmentProcessRepository extends CrudRepository<AssessmentProcess, Integer> {
	
	/**
	 * This method is created for fetch the Assessment process record using following fields
	 * @param assessment_id - unique assessment id
	 * @param category_id - unique category id
	 * @param question_id - unique question id
	 * @return
	 */
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess a JOIN a.assessment m JOIN a.questionCategory c JOIN a.assessmenQuestion q WHERE m.assessment_id=:assessment_id AND c.category_id=:category_id AND q.question_id=:question_id")
	Optional<AssessmentProcess> getAssessmentProcessByInfo( 
			@Param("assessment_id") Integer assessment_id, 
			@Param("category_id") Integer category_id, 
			@Param("question_id") Integer question_id);
	
	/**
	 * This method is created to get all answered question under an particular category
	 * @param assessment_id - Unique assessment id
	 * @param category_id - uniques category id
	 * @return
	 */
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess a JOIN a.assessment m JOIN a.questionCategory c WHERE m.assessment_id=:assessment_id AND c.category_id=:category_id ")
	List<AssessmentProcess> getAssessmentProcessDtails( 
			@Param("assessment_id") Integer assessment_id, 
			@Param("category_id") Integer category_id);
	
	/**
	 * Get all question and answer list for an particular assessment
	 * @param assessment_id 
	 * @return
	 */
	@Query("SELECT a FROM com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess a JOIN a.assessment m WHERE m.assessment_id=:assessment_id ")
	List<AssessmentProcess> getAssessmentProcessALLDtails(@Param("assessment_id") Integer assessment_id);
	
	/**
	 * This method is used for calculating the result
	 * @param assessment_id
	 * @return
	 */
	@Query("SELECT a.questionCategory, SUM(d.weightage) FROM "
			+ "com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess a "
			+ "JOIN a.assessment m "
			+ "JOIN a.questionCategory c "
			+ "JOIN a.question_answers d "
			+ "WHERE m.assessment_id=:assessment_id group by c.category_id ")
	List<?> calculateAssessmentResult( 
			@Param("assessment_id") Integer assessment_id);
	
	
}
