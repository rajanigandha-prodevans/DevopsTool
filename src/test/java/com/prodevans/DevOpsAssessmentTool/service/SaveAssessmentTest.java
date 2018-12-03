//package com.prodevans.DevOpsAssessmentTool.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.testng.Assert.assertEquals;
//
//import java.util.Date;
//
//import javax.transaction.Transactional;
//
//import org.junit.After;
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
//import com.prodevans.DevOpsAssessmentTool.user.User;
//import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
//import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
//import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
//import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;
//
//@Transactional
//public class SaveAssessmentTest extends DevOpsAssessmentToolApplicationTests {
//
//	// Logger initialization
//	final static private Logger logger = LoggerFactory.getLogger(UserRepository.class);
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
//	// Creating the assessment service object
//	@Autowired
//	private IAssessmentService assessment_service;
//	
//	public void setAssessment_status_repository(AssessmentStatusRepository assessment_status_repository) {
//		this.assessment_status_repository = assessment_status_repository;
//	}
//	
//	public void setAssessment_service(IAssessmentService assessment_service) {
//		this.assessment_service = assessment_service;
//	}
//	
//	public void setAssessment_repository(AssessmentRepository assessment_repository) {
//		this.assessment_repository = assessment_repository;
//	}
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
//	public void setUser_repository(UserRepository user_repository) {
//		this.user_repository = user_repository;
//	}
//
//	public void setCountry_repository(CountryRepository country_repository) {
//		this.country_repository = country_repository;
//	}
//
//	public void setIndustry_repository(IndustryTypeRepository industry_repository) {
//		this.industry_repository = industry_repository;
//	}
//
//	public void setCompany_size_repository(CompanySizeRepository company_size_repository) {
//		this.company_size_repository = company_size_repository;
//	}
//	
//	@Before
//	public void init() {
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
//	}
//	
//	/**
//	 * Valid assessment save test
//	 */
//	@Test
//	public void saveAssessmentTest() {
//		// Calling the assessment save method
//		logger.info("User : "+ user.toString());
//		assessment = assessment_service.saveAssessment(assessment, this.user.getUser_id());
//		
//		// Checking the result for the assessment
//		assertEquals(true, assessment != null);
//		
//		logger.info("Assessment save test successful...");
//	}
//	
//	/**
//	 * invalid assessment save test
//	 */
//	@Test
//	public void saveAssessmentTest2() {
//		try {
//		// Calling the assessment save method
//		assessment = assessment_service.saveAssessment(assessment, 0);
//		
//		}catch(Exception ee) {
//			// Checking the result for the assessment
//			assertThat("Test has been passed");
//		}
//		
//	}
//	
//	@After
//	public void cleanup() {
//		// Deleting the assessment from the database.
//		assessment_repository.delete(assessment);
//		
//		// Deleting the user
//		//user_repository.delete(user);
//	}
//}
