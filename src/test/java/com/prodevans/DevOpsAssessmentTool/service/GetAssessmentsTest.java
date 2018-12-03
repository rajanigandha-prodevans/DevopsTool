//package com.prodevans.DevOpsAssessmentTool.service;
//
//import static org.testng.Assert.assertEquals;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.prodevans.DevOpsAssessmentTool.DevOpsAssessmentToolApplicationTests;
//import com.prodevans.DevOpsAssessmentTool.assessment.Assessment;
//import com.prodevans.DevOpsAssessmentTool.assessment.AssessmentService;
//import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatus;
//import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatusRepository;
//import com.prodevans.DevOpsAssessmentTool.user.User;
//import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
//import com.prodevans.DevOpsAssessmentTool.user.UserService;
//import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
//import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
//import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;
//
//@Transactional
//public class GetAssessmentsTest extends DevOpsAssessmentToolApplicationTests{
//
//	// User object
//		private User user;
//	
//	private Assessment assessment;
//	
//	@Autowired
//	private AssessmentService assessment_service;
//	@Autowired
//	private CompanySizeRepository company_size_repository;
//	@Autowired
//	private CountryRepository country_repository;
//	@Autowired
//	private IndustryTypeRepository industry_repository;
//	@Autowired
//	private UserRepository user_repository;
//	@Autowired
//	private AssessmentStatusRepository assessment_status_repository;
//	
//	@Before
//	public void init()
//	{
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
//		assessment_service.saveAssessment(assessment, user.getUser_id());
//	}
//	
//	@Test
//	public void getAssessmentsByUserId()
//	{
//		
//		List<Assessment> result=assessment_service.getAssessmentsByUserId(user.getUser_id());
//		System.out.println("Result : " + result.toString());
//		assertEquals(result.size() > 0, true);
//		
//	}
//	
//	@After
//	public void cleanUp()
//	{
//		
//	}
//	
//}
