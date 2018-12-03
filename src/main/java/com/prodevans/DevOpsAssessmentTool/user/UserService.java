package com.prodevans.DevOpsAssessmentTool.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySize;
import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySizeRepository;
import com.prodevans.DevOpsAssessmentTool.user.country.Country;
import com.prodevans.DevOpsAssessmentTool.user.country.CountryRepository;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryType;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryTypeRepository;

@Service
public class UserService implements IUserService {

	// Logger initialization
	private static final Logger logger = LoggerFactory.getLogger(UserContorller.class);

	// Creating the object for the user repository
	@Autowired
	private UserRepository user_repository;

	// Creating the object for Industry type repository
	@Autowired
	private IndustryTypeRepository industryTypeRepository;

	// Creating the object for Country repository
	@Autowired
	private CountryRepository countryRepository;
	
	// Creating the object for company size repository
	@Autowired
	private CompanySizeRepository company_size_repository; 
	
	// Creating the object for notification service

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
	
	@Value("${spring.mail.username}")
	private String from_mail;
	
	@Override
	public List<User> getUsers() {
		List<User> list = new ArrayList<>();
		try {
			user_repository.findAll().forEach(e -> list.add(e));
		} catch (Exception ee) {
			logger.error("No user list found");
			return new ArrayList<User>();
		}
		return list;
	}

	@Override
	public User saveUser(UserRequestWrapper user) {
		// Preparing the user object to save in the database
		User saved_user = new User();
		saved_user.setFirst_name(user.getFirstName());
		saved_user.setLast_name(user.getLastName());
		saved_user.setUser_email(user.getUserEmail());
		saved_user.setCompanySize(company_size_repository.findById(user.getCompanySizeId()).get());
		saved_user.setCountry(countryRepository.findById(user.getCountryId()).get());
		saved_user.setIndustryType(industryTypeRepository.findById(user.getIndustryTypeId()).get());
		saved_user.setCompanyName(user.getCompanyName());
		saved_user.setUser_password(user.getUserPassword());
		
		// Saving data into the database
		return user_repository.save(saved_user);
	}

	@Override
	public Optional<User> getUser(int user_id) {
		return user_repository.findById(user_id);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return user_repository.getUserByEmail(email);
	}
	
	@Override
	public List<CompanySize> getAllCompanySizes() {
		List<CompanySize> list = new ArrayList<>();
		try {
			company_size_repository.findAll().forEach(e -> list.add(e));
		} catch (Exception ee) {
			logger.error("No company size list found");
			return new ArrayList<CompanySize>();
		}
		return list;
	}

	@Override
	public List<Country> getAllCountries() {
		List<Country> list=new ArrayList<>();
		try {
			countryRepository.findAll().forEach(e->list.add(e));
		} catch (Exception e) {
			logger.error("No country list found");
			return new ArrayList<Country>();
		}
		return list;
	}

	@Override
	public List<IndustryType> getAllIndustries() {
		List<IndustryType> list=new ArrayList<>();
		
		try {
			industryTypeRepository.findAll().forEach(e->list.add(e));
		} catch (Exception e) {
			logger.error("No industry list found");
			return new ArrayList<IndustryType>();
		}
		return list;
	}

	/*@Override
	public void resetPassword(String email) {
		// TODO Auto-generated method stub
		
		Boolean result=user_repository.getUserByEmail(email).isPresent();
		System.out.println("Result="+result);
		if(result)
		{
			String encrypted_email = bCrypt.encode(email);
			User user=new User();
			user.setReset_token(encrypted_email);
			System.out.println("" + user.getReset_token());
			String appUrl = "http:8080/reset_?token="+user.getReset_token();
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom(from_mail);
			passwordResetEmail.setTo(email);
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl);
			javaMailSender.send(passwordResetEmail);			
		}
		else
		{
			System.out.println("User is not present");
		}
		

		
	}*/
	

}
