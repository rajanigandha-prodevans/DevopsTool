package com.prodevans.DevOpsAssessmentTool.assessment;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess;
import com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;

@RestController
@RequestMapping(value = "/api/users/{user_id}")
public class AssessmentController {

	// Logger initialization
	final private static Logger logger = LoggerFactory.getLogger(AssessmentController.class);

	// Assessment service object
	@Autowired
	private IAssessmentService assessment_service;

	public void setAssessment_service(IAssessmentService assessment_service) {
		this.assessment_service = assessment_service;
	}

	/**
	 * This API is created for saving the assessment information in the database
	 * 
	 * @param assessment
	 *            - assessment information
	 * @param user_id
	 *            - user id
	 * @return
	 */
	@PostMapping(value = "/assessments")
	public ResponseEntity<?> saveAssessment(@RequestBody AssessmentRequestWrapper assessment,
			@PathVariable(name = "user_id") Integer user_id) {
		try {
			// Saving the Assessment in the database
			Assessment savedAssessment = assessment_service.saveAssessment(assessment, user_id);

			// Creating the uri for the assessment
			URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(savedAssessment.getAssessment_id()).toUri();

			// Returning the response
			return ResponseEntity.created(location).build();

		} catch (Exception e) {
			logger.error("Error form save assessment : " + e.getMessage().toString());
			// Returning the response entity.
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@GetMapping(value = "/assessments")
	public List<AssessmentResponseWrapper> getAssessmentByUserId(@PathVariable(name = "user_id") Integer user_id) {
		logger.info("User id : " + user_id);
		return assessment_service.getAssessmentsByUserId(user_id);
	}

	@GetMapping(value = "/assessments/{assessment_id}")
	public ResponseEntity<AssessmentResponseWrapper> getAssessment(@PathVariable("user_id") int user_id,
			@PathVariable("assessment_id") int assessment_id) {
		Optional<Assessment> result = assessment_service.getAssessment(user_id, assessment_id);
		if (result.isPresent()) {
			// Creating the wrapper
			AssessmentResponseWrapper assessmentResponseWrapper = new AssessmentResponseWrapper();
			
			// Inserting the data in wrapper
			assessmentResponseWrapper.setAssessmentId( result.get().getAssessment_id() );
			assessmentResponseWrapper.setAssessmentName( result.get().getAssessment_name() );
			assessmentResponseWrapper.setAssessmentDescription( result.get().getAssessment_description() );
			assessmentResponseWrapper.setAssessmentStatus( result.get().getAssessmentStatus().getStatus() );
			assessmentResponseWrapper.setCreatedDate( result.get().getCreated_date() );
			
			
			// If user with specified email address is present
			return ResponseEntity.ok().body(assessmentResponseWrapper);
		} else {
			// If user with specified email address is not present
			return ResponseEntity.notFound().build();
		}

	}

	/**
	 * This API is created for save the answers give by the user for particular
	 * assessment
	 * 
	 * @param questions
	 *            - list of questions and answers given by the user
	 * @param user_id
	 *            - user id to check the valid user
	 * @param assessment_id
	 *            - assessment id to detect the assessment
	 * @param category_id
	 *            - category id to detect the category
	 * @return
	 */
	@PutMapping(value = "/assessments/{assessment_id}/categories/{category_id}/questions")
	public ResponseEntity<?> saveAnswers(@RequestBody List<QuestionResponseWrapper> questions,
			@PathVariable("user_id") int user_id, @PathVariable("assessment_id") int assessment_id,
			@PathVariable("category_id") int category_id) {

		logger.info("Send data : " + questions.toString());
		try {
			// Saving the answer in the database
			assessment_service.saveAnswers(questions, user_id, assessment_id, category_id);

			// If user with specified email address is present
			return ResponseEntity.noContent().build();

		} catch (Exception ee) {
			logger.error("Error : " + ee.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	/**
	 * This API is created for the get all questions and answers
	 * @param assessment_id	- assessment id to detect the assessment
	 * @param category_id	- category id to detect the category
	 * @return
	 */
	@GetMapping(value="/assessments/{assessment_id}/categories/{category_id}/questions")
	public List<QuestionResponseWrapper> getAllAnsweredQuestion( @PathVariable("assessment_id") int assessment_id,
			@PathVariable("category_id") int category_id){
		// Returning the all assessment process question
		
		return assessment_service.getAnsweredQuestionByCategoryAndAssessment(assessment_id, category_id);
	}
	
	/**
	 * This API is created for the submit the assessment
	 * @param user_id
	 * @param assessment_id
	 * @return
	 */
	@GetMapping(value = "/assessments/{assessment_id}/submit")
	public ResponseEntity<?> submitAssessment(@PathVariable("user_id") int user_id,
			@PathVariable("assessment_id") int assessment_id) {
		Set<QuestionCategory> result = assessment_service.getUnansweredCategories(assessment_id);
		if (result.isEmpty()) {
			// If user with specified email address is present
			return ResponseEntity.ok().build();
		} else {
			// If user with specified email address is not present
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}

	}
	
	/**
	 * This API is created for get the result for an particular assessment
	 * @param assessment_id
	 * @return
	 */
	@GetMapping("/assessments/{assessment_id}/result")
	public List<AssessmentResult> getResult(@PathVariable(name = "assessment_id")Integer assessment_id){
		return assessment_service.getResultForAssessment(assessment_id);
	}
	
}
