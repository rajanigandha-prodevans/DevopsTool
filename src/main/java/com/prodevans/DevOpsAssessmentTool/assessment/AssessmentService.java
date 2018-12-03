package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess;
import com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcessRepository;
import com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult;
import com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResultRepository;
import com.prodevans.DevOpsAssessmentTool.assessment.result_maturity.AssessmentResultMaturity;
import com.prodevans.DevOpsAssessmentTool.assessment.result_maturity.AssessmentResultMaturityRepository;
import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatusRepository;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategoryRepository;
import com.prodevans.DevOpsAssessmentTool.category.option.QuestionOption;
import com.prodevans.DevOpsAssessmentTool.category.option.QuestionOptionRepository;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestionRepository;
import com.prodevans.DevOpsAssessmentTool.user.User;
import com.prodevans.DevOpsAssessmentTool.user.UserRepository;

@Service
public class AssessmentService implements IAssessmentService {

	// Logger initialization
	final private static Logger logger = LoggerFactory.getLogger(AssessmentService.class);

	// Assessment repository object creating
	@Autowired
	private AssessmentRepository assessment_repository;

	// Assessment status repository object
	@Autowired
	private AssessmentStatusRepository assessment_status_repository;

	// User repository object
	@Autowired
	private UserRepository user_repository;

	// Creating object of the Assessment process repository
	@Autowired
	private AssessmentProcessRepository assessment_process_repository;

	@Autowired
	private QuestionCategoryRepository question_category_repository;

	@Autowired
	private AssessmentQuestionRepository assessment_question_repository;

	@Autowired
	private QuestionOptionRepository question_option_repository;

	@Autowired
	private AssessmentResultRepository assessment_result_repository;

	@Autowired
	private AssessmentResultMaturityRepository assessment_result_maturity_repository;

	public void setAssessment_repository(AssessmentRepository assessment_repository) {
		this.assessment_repository = assessment_repository;
	}

	public void setAssessment_status_repository(AssessmentStatusRepository assessment_status_repository) {
		this.assessment_status_repository = assessment_status_repository;
	}

	public void setUser_repository(UserRepository user_repository) {
		this.user_repository = user_repository;
	}

	public void setAssessment_process_repository(AssessmentProcessRepository assessment_process_repository) {
		this.assessment_process_repository = assessment_process_repository;
	}

	public void setQuestion_category_repository(QuestionCategoryRepository question_category_repository) {
		this.question_category_repository = question_category_repository;
	}

	public void setAssessment_question_repository(AssessmentQuestionRepository assessment_question_repository) {
		this.assessment_question_repository = assessment_question_repository;
	}

	public void setQuestion_option_repository(QuestionOptionRepository question_option_repository) {
		this.question_option_repository = question_option_repository;
	}

	public void setAssessment_result_repository(AssessmentResultRepository assessment_result_repository) {
		this.assessment_result_repository = assessment_result_repository;
	}

	public void setAssessment_result_maturity_repository(
			AssessmentResultMaturityRepository assessment_result_maturity_repository) {
		this.assessment_result_maturity_repository = assessment_result_maturity_repository;
	}

	@Override
	public Assessment saveAssessment(AssessmentRequestWrapper assessmentRequestWrapper, Integer user_id) {
		Assessment assessment =  new Assessment();
		
		// Setting the wrapper data to Assessment object
		assessment.setAssessment_id(0);
		assessment.setAssessment_name(assessmentRequestWrapper.getAssessmentName());
		assessment.setAssessment_description(assessmentRequestWrapper.getAssessmentDescription());
		assessment.setAssessmentStatus(assessment_status_repository.findById(1).get());
		assessment.setCreated_date(new Date());
		
		// Getting the user details
		User user = user_repository.findById(user_id).get();

		// Adding the user in assessment object;
		assessment.setUser(user);

		// performing the save operation on the Assessment.
		Assessment savedAssessment = assessment_repository.save(assessment);

		// Generate the assessment process table
		generateAssessmentProcess(savedAssessment);

		// Return the saved assessment
		return savedAssessment;
	}

	@Override
	public List<AssessmentResponseWrapper> getAssessmentsByUserId(int user_id) {
		// Assessment response wrapper list
		List<AssessmentResponseWrapper> list = new ArrayList<>();
		
		assessment_repository.getAssessmentByUserId(user_id).forEach(assessment ->{
			// Created object of response wrapper
			AssessmentResponseWrapper assessmentResponseWrapper = new AssessmentResponseWrapper();
			
			// Assigning the values
			assessmentResponseWrapper.setAssessmentId( assessment.getAssessment_id() );
			assessmentResponseWrapper.setAssessmentName( assessment.getAssessment_name() );
			assessmentResponseWrapper.setAssessmentDescription( assessment.getAssessment_description() );
			assessmentResponseWrapper.setAssessmentStatus( assessment.getAssessmentStatus().getStatus() );
			assessmentResponseWrapper.setCreatedDate( assessment.getCreated_date() );
			
			// Adding object in list
			list.add(assessmentResponseWrapper);
		});
		
		return list;
	}

	/**
	 * This method is created for generating the assessment process table.
	 * 
	 * @param assessment
	 */
	private void generateAssessmentProcess(Assessment assessment) {
		question_category_repository.findAll().forEach(category -> {
			assessment_question_repository.getAssessmentQuestionsByCategoryId(category.getCategory_id())
					.forEach(question -> {
						AssessmentProcess assessment_process = new AssessmentProcess();
						assessment_process.setAssessment(assessment);
						assessment_process.setAssessmenQuestion(question);
						assessment_process.setQuestionCategory(category);
						assessment_process_repository.save(assessment_process);
					});
		});
	}

	@Override
	public Optional<Assessment> getAssessment(int user_id, int assessment_id) {

		return assessment_repository.getAssessment(user_id, assessment_id);
	}

	@Override
	public void saveAnswers(List<QuestionResponseWrapper> questionsRequestWrapper, Integer user_id, Integer assessment_id,
			Integer category_id) {

		// Iterating over the assessment questions
		questionsRequestWrapper.forEach(question -> {
			// Getting the assessment process object using the question_id, category_id and
			// assessment_id
			Optional<AssessmentProcess> assessment_process = assessment_process_repository
					.getAssessmentProcessByInfo(assessment_id, category_id, question.getQuestionId());

			// Getting the options form database
			List<QuestionOption> db_options = new ArrayList<QuestionOption>();

			question.getQuestionOptions().forEach(option -> {
				// If options is selected then add into the database
				if(option.getIsSelected()) {
					db_options.add(question_option_repository.findById(option.getQuestionOptionId()).get());
				}
			});

			// Adding the answered information into the Assessment Process
			assessment_process.get().setquestion_answers(db_options);

			// Updating the information in assessment process table
			assessment_process_repository.save(assessment_process.get());
		});

	}

	@Override
	public List<QuestionResponseWrapper> getAnsweredQuestionByCategoryAndAssessment(Integer assessment_id,
			Integer category_id) {
		// Getting the information form the assessment repository
		List<AssessmentProcess> assessmentProcesses = assessment_process_repository.getAssessmentProcessDtails(assessment_id,category_id);

		// Creating list of question answer wrapper
        List<QuestionResponseWrapper> wrapper = new ArrayList<>();

		// Creating the object of the question wrapper process
        assessmentProcesses.forEach(assessmentProcess -> {

            QuestionResponseWrapper questionResponseWrapper = new QuestionResponseWrapper();
            questionResponseWrapper.setQuestion(assessmentProcess.getAssessmenQuestion().getQuestion());
            questionResponseWrapper.setQuestionId(assessmentProcess.getAssessmenQuestion().getQuestion_id());
            questionResponseWrapper.setQuestionType(assessmentProcess.getAssessmenQuestion().getQuestionType().getQuestion_type());
            questionResponseWrapper.setCategoryName(assessmentProcess.getQuestionCategory().getCategory_name());

            // List for store wrapper options
            List<QuestionOptionWrapper> questionOptionWrappers = new ArrayList<>();

            // Adding the question options and selected options
            assessmentProcess.getAssessmenQuestion().getQuestionOptions().forEach(questionOption -> {
                // Creating question option wrapper class
                QuestionOptionWrapper questionOptionWrapper = new QuestionOptionWrapper();

                // Adding values into the class
                questionOptionWrapper.setQuestionOptionId(questionOption.getQuestion_option_id());
                questionOptionWrapper.setQuestionOption(questionOption.getQuestion_option());

                // Checking the option is selected or not
                if(assessmentProcess.getquestion_answers().contains(questionOption)){
                    questionOptionWrapper.setIsSelected(true);
                }else{
                    questionOptionWrapper.setIsSelected(false);
                }

                // Adding the data into list
                questionOptionWrappers.add(questionOptionWrapper);
            });

            // Setting the question option
            questionResponseWrapper.setQuestionOptions(questionOptionWrappers);

            // Adding the question data into question list
            wrapper.add(questionResponseWrapper);

        });

        // Returning the response wrapper
		return wrapper;
	}

	@Override
	public Set<QuestionCategory> getUnansweredCategories(Integer assessment_id) {
		// List of categories having the non answered question
		Set<QuestionCategory> un_answered_categories = new HashSet<>();

		// // List of the Results
		// List<AssessmentResult> assessment_result = new ArrayList<>();
		//
		assessment_process_repository.getAssessmentProcessALLDtails(assessment_id).forEach(assessment_process -> {
			// Adding the categories having no answer for questions
			if (assessment_process.getquestion_answers().isEmpty()) {
				if (!un_answered_categories.contains(assessment_process.getQuestionCategory())) {
					un_answered_categories.add(assessment_process.getQuestionCategory());
				}
			}
		});

		// If the user answered all category questions then the result will be calculated
		if (un_answered_categories.isEmpty() || un_answered_categories.size() == 0) {
			// calculating the maturity and adding the information in the database
			assessment_process_repository.calculateAssessmentResult(assessment_id).forEach(result -> {
				// Converting the result into required format
				Object[] row = (Object[]) result;

				// Creating the objects for the saving the data
				QuestionCategory category = (QuestionCategory) row[0];
				Float category_score = Float.parseFloat(row[1].toString());

				// Converting the score into the maturity level
				int maturity_level = Math.round(convertScoreInLevels(category_score, category.getCategory_id()));

				logger.info("Maturity level in integer : " + maturity_level);

				// Getting the maturity from database
				AssessmentResultMaturity result_maturity = assessment_result_maturity_repository
						.findById(maturity_level).get();

				logger.debug("Result Category : " + row[0].toString());
				logger.debug("Result score : " + Float.parseFloat(row[1].toString()));

				// Checking weather the assessment and respective category score is present on
				// the data base or not
				Optional<AssessmentResult> present_result = assessment_result_repository
						.getAssessmentResultByCategoryAndAssessent(assessment_id, category.getCategory_id());

				if (present_result.isPresent()) {
					// If the result is present in the database
					AssessmentResult assessment_result = present_result.get();
					assessment_result.setResultMaturity(result_maturity);
					assessment_result.setCategory_total_score(category_score);

					// Saving the information in the database
					assessment_result_repository.save(assessment_result);

				} else {
					// If the result is not present in the database
					AssessmentResult assessment_result = new AssessmentResult();
					assessment_result.setAssessment(assessment_repository.findById(assessment_id).get());
					assessment_result.setCategory_total_score(category_score);
					assessment_result.setQuestion_category(category);
					assessment_result.setResultMaturity(result_maturity);

					// Saving the information in the database
					assessment_result_repository.save(assessment_result);
				}
				
				// Updating the assessment result
				updateAssessmentStatus(assessment_id);
			});
		}

		return un_answered_categories;
	}

	/**
	 * This method is created for updating the status of the assessment.
	 * @param assessment_id - assessment for update the result
	 */
	private void updateAssessmentStatus(Integer assessment_id) {
		// Getting the assessment by id
		Assessment assessment = assessment_repository.findById(assessment_id).get();
		
		// Updating the status as done for an assessment
		assessment.setAssessmentStatus(assessment_status_repository.findById(2).get());
		
		// Updating the assessment in the data base
		assessment_repository.save(assessment);
	}

	/**
	 * This method is convert the category score into the maturity level
	 * 
	 * @param category_score
	 *            - category score calculated
	 * @param category_id
	 *            - to check the how many questions are present in the category
	 * @return - Maturity level
	 */
	private float convertScoreInLevels(Float category_score, Integer category_id) {
		// Converting the category score into the maturity level [ 1 - 3 ]
		int question_count = assessment_question_repository.getQuestionCountInCategory(category_id);
		logger.info("Quesiton count  : " + question_count);
		return (category_score / question_count) * 3;
	}

	@Override
	public List<AssessmentResult> getResultForAssessment(Integer assessment_id) {
		return assessment_result_repository.getAssessmentResultByAssessent(assessment_id);
	}

}
