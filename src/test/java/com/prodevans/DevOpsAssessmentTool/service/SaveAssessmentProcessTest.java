//package com.prodevans.DevOpsAssessmentTool.service;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
//import com.prodevans.DevOpsAssessmentTool.assessment.Assessment;
//import com.prodevans.DevOpsAssessmentTool.assessment.AssessmentRepository;
//import com.prodevans.DevOpsAssessmentTool.assessment.IAssessmentService;
//import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatusRepository;
//import com.prodevans.DevOpsAssessmentTool.category.ICategoryService;
//import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;
//import com.prodevans.DevOpsAssessmentTool.user.User;
//import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
//import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
//import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
//import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;
//
//@Transactional
//public class SaveAssessmentProcessTest extends DevOpsAssessmentToolApplicationTests {
//
//	// Initialization of logger
//	final static private Logger logger = LoggerFactory.getLogger(SaveAssessmentProcessTest.class);
//	
//	// Creating the object for the assessment service
//	@Autowired
//	private IAssessmentService assessment_service;
//
//	// Creating the object for the assessment category
//	@Autowired
//	private ICategoryService category_service;
//
//	// Creating the object of the question list
//	private List<AssessmentQuestion> questions;
//
//	@Autowired
//	private UserRepository user_repository;
//
//	@Autowired
//	private CountryRepository country_repository;
//
//	@Autowired
//	private IndustryTypeRepository industry_repository;
//
//	@Autowired
//	private CompanySizeRepository company_size_repository;
//
//	public void setAssessment_service(IAssessmentService assessment_service) {
//		this.assessment_service = assessment_service;
//	}
//
//	public void setCategory_service(ICategoryService category_service) {
//		this.category_service = category_service;
//	}
//
//	// Assessment object
//	private Assessment assessment;
//
//	// User object
//	private User user;
//
//	// Creating the assessment status repository object
//	@Autowired
//	private AssessmentStatusRepository assessment_status_repository;
//
//	// Creating the object for assessment repository
//	@Autowired
//	private AssessmentRepository assessment_repository;
//
//	@Before
//	public void init() {
//		//
//		User saved_user = new User();
//		saved_user.setFirst_name("Ram");
//		saved_user.setLast_name("Sharma");
//		saved_user.setUser_email("shyam@gmail.com");
//		saved_user.setCompanyName("ABC Technologies");
//		saved_user.setCompanySize(company_size_repository.findById(1).get());
//		saved_user.setCountry(country_repository.findById(1).get());
//		saved_user.setIndustryType(industry_repository.findById(1).get());
//		this.user = user_repository.save(saved_user);
//
//		assessment = new Assessment();
//		assessment.setAssessment_name("Devops 1 assessment");
//		assessment.setAssessment_description("Assessment for testing");
//		assessment.setAssessmentStatus(assessment_status_repository.findById(1).get());
//		assessment.setCreated_date(new Date());
//
//		assessment = assessment_service.saveAssessment(assessment, this.user.getUser_id());
//
//		questions = category_service.getAssessmentQuestionByCategoryId(1);
//	}
//
//	@Test
//	public void testingAssessmentAnswerSave() {
//		try {
//			// Calling the answer save method
//			assessment_service.saveAnswers(questions, user.getUser_id(), assessment.getAssessment_id(), 1);
//		} catch (Exception ee) {
//			logger.error("Error"+ ee.getStackTrace());
//		}
//
//	}
//}
