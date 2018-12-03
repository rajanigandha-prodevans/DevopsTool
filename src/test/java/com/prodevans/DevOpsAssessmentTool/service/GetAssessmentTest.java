//package com.prodevans.DevOpsAssessmentTool.service;
//
//import static org.testng.Assert.assertEquals;
//
//import java.util.Date;
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
//import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatusRepository;
//import com.prodevans.DevOpsAssessmentTool.user.User;
//import com.prodevans.DevOpsAssessmentTool.user.UserRepository;
//import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
//import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
//import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;
//
//@Transactional
//public class GetAssessmentTest extends DevOpsAssessmentToolApplicationTests {
//
//	
//	private User user;
//	
//	private Assessment assessment;
//
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
//	@Autowired
//	private AssessmentService assessment_service;
//	
//	public void setCompany_size_repository(CompanySizeRepository company_size_repository) {
//		this.company_size_repository = company_size_repository;
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
//	public void setUser_repository(UserRepository user_repository) {
//		this.user_repository = user_repository;
//	}
//	public void setAssessment_status_repository(AssessmentStatusRepository assessment_status_repository) {
//		this.assessment_status_repository = assessment_status_repository;
//	}
//	public void setAssessment_service(AssessmentService assessment_service) {
//		this.assessment_service = assessment_service;
//	}
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
//	public void getAssessment()
//	{
//		Optional<Assessment> result=assessment_service.getAssessment(user.getUser_id(), assessment.getAssessment_id());
//		assertEquals(result.isPresent(), true);
//		System.out.println("Result of get assessment:"+result);
//	}
//	
//	@After
//	public void cleanUp()
//	{
//		
//	}
//}
