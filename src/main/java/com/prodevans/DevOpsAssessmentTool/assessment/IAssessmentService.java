
package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess;
import com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

public interface IAssessmentService {
	/**
	 * This method is created for the creating assessment for the particular user
	 * @param assessment - Assessment object to store the assessment data
	 * @param user_id - user id for linking the newly created assessment
	 * @return - newly created assessment object
	 */
	public Assessment saveAssessment(AssessmentRequestWrapper assessment,Integer user_id);
	
	/**
	 * This method return all assessments based on user id
	 * @return - List of assessments based on user id
	 */
	List<AssessmentResponseWrapper> getAssessmentsByUserId(int user_id);
	
	Optional<Assessment> getAssessment(int user_id, int assessment_id);

	/**
	 * This method saves the answered question in the database for a particular assessment
	 * @param answered_questions 	- Assessment questions and answer list
	 * @param user_id 				- User id to identify user
	 * @param assessment_id			- Assessment id to identify assessment
	 * @param category_id			- Category id to identify the category
	 */
	public void saveAnswers(List<QuestionResponseWrapper> questionsRequestWrapper, Integer user_id, Integer assessment_id, Integer category_id);
	
	
	/**
	 * This method is created for get all answered question form DB
	 * @param assessment_id		- Assessment id to identify assessment
	 * @param category_id		- Category id to identify the category
	 * @return					- List of assessment process entity
	 */
	public List<QuestionResponseWrapper> getAnsweredQuestionByCategoryAndAssessment(Integer assessment_id, Integer category_id);
	
	/**
	 * Get all unanswered categories for an assessment
	 * @param assessment_id
	 * @return
	 */
	public Set<QuestionCategory> getUnansweredCategories(Integer assessment_id);
	
	/**
	 * This method is created for to fetch result for an assessment
	 * @param assessment_id		- Assessment to fetch the result
	 * @return 					- Result list for an particular assessment
	 */
	public List<AssessmentResult> getResultForAssessment(Integer assessment_id);
}
