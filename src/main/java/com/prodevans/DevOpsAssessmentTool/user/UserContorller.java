package com.prodevans.DevOpsAssessmentTool.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prodevans.DevOpsAssessmentTool.user.country.Country;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryType;


@RestController
@RequestMapping(value = "/api")
public class UserContorller {

	// Logger initialization
	private static final Logger logger = LoggerFactory.getLogger(UserContorller.class);

	// Creating the user service object.
	@Autowired
	private IUserService user_service;
	
	@Autowired
	UserRepository user_repository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
	
	@Value("${spring.mail.username}")
	private String from_mail;
	
	@Value("${server.name}")
	private String host_name;
	

	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}

	/**
	 * The method is defined to get the all details of all users
	 * 
	 * @return - list of users
	 */
	@GetMapping(value ="/users")
	public List<User> getUsers() {
		// Getting the list of users present in the DB
		return user_service.getUsers();
	}

	/**
	 * The method is defined to get the all details of all users
	 * 
	 * @return - list of users
	 */
	@GetMapping(value = "/users/{id}")
	public Resource<UserWrapper> getUser(@PathVariable(name = "id") int user_id) {
		// Getting the user details form the DB
		Optional<User> user = user_service.getUser(user_id);
		
		UserWrapper user_wrap = new UserWrapper();
		
		// converting user to user wrapper
		if(user.isPresent()) {
			user_wrap.setUserId(user.get().getUser_id());
			user_wrap.setFirstName(user.get().getFirst_name());
			user_wrap.setLastName(user.get().getLast_name());
			user_wrap.setUserEmail(user.get().getUser_email());
			user_wrap.setCompanyName(user.get().getCompanyName());
			user_wrap.setCompanySize(user.get().getCompanySize().getSize());
			user_wrap.setIndustryType(user.get().getIndustryType().getIndustry_name());
			user_wrap.setCountry(user.get().getCountry().getcountry_name());
		}

		// IF use is not present then throw user not found exception
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + user_id);

		// creating the resource object to send data
		Resource<UserWrapper> resource = new Resource<UserWrapper>(user_wrap);

		// Returning the resource object
		return resource;
	}

	/**
	 * This API is created for login the user in the system
	 * @param email - getting the information by the user_email address
	 * @return
	 */
	@GetMapping(value = "/users/login/{email}")
	public Resource<UserWrapper> loginUser(@PathVariable(name = "email") String email) {
		// Getting the user details form the DB
		Optional<User> user = user_service.findUserByEmail(email);
		
		UserWrapper user_wrap = new UserWrapper();
		
		// converting user to user wrapper
		if(user.isPresent()) {
			user_wrap.setUserId(user.get().getUser_id());
			user_wrap.setFirstName(user.get().getFirst_name());
			user_wrap.setLastName(user.get().getLast_name());
			user_wrap.setUserEmail(user.get().getUser_email());
			user_wrap.setCompanyName(user.get().getCompanyName());
			user_wrap.setCompanySize(user.get().getCompanySize().getSize());
			user_wrap.setIndustryType(user.get().getIndustryType().getIndustry_name());
			user_wrap.setCountry(user.get().getCountry().getcountry_name());
		}

		// IF use is not present then throw user not found exception
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + email);

		// creating the resource object to send data
		Resource<UserWrapper> resource = new Resource<UserWrapper>(user_wrap);

		// Returning the resource object
		return resource;
	}
	
	/**
	 * This API is used to create the user object with all details
	 * 
	 * @param user
	 *            - user body
	 * @param user_password
	 *            - user password
	 * @return
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<Object> saveUser(@RequestBody UserRequestWrapper user) {
	
		try {
			// Saving the user information
			User savedUser = user_service.saveUser(user);
			
			// Creating the URI for new user
			URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(savedUser.getUser_id()).toUri();

			// Returning the response entity.
			return ResponseEntity.created(location).build();
			
		} catch(Exception ee) {
			// Returning the response entity.
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	/**
	 * This api created for the checking the email address is present in the
	 * database or not
	 * 
	 * @param email
	 *            - user email address
	 * @return
	 */
	@GetMapping(value = "/verifyemail")
	public ResponseEntity<Object> verifyEmail(@RequestParam(name = "email_address") String email) {
		// Checking the email address is present or not
		Boolean result = user_service.findUserByEmail(email).isPresent();
		if (result) {
			// If user with specified email address is present
			return ResponseEntity.ok().build();
		} else {
			// If user with specified email address is not present
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * This API get all the company sizes are present in the database
	 * 
	 * @return - list of the company sizes
	 */
	@GetMapping(value = "/companysize")
	public List<com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySize> getAllCompanySizes() {
		return user_service.getAllCompanySizes();
	}

	/**
	 * This API get all the countries are present in the database
	 * @return - list of the countries
	 */
	@GetMapping(value="/countries")
	public List<Country> getAllCountries()
	{
		// Returning the all countries form the DB
		return user_service.getAllCountries();
	}
	
	/**
	 * This API get all the industries are present in the database
	 * @return - list of the industries
	 */
	@GetMapping(value="/industries")
	public List<IndustryType> getAllIndustries()
	{
		// Get the all industry types form the database.
		return user_service.getAllIndustries();
	}
	
	@PostMapping(value="/forgetpassword")
	public ResponseEntity<?> forgetPassword(@RequestBody String request) throws JSONException
	{
		logger.info("Message : "+ request);
		 
		
		JSONObject jso = new JSONObject(request);
		String email = jso.getString("email");
		
		Optional<User> user_nm=user_repository.getUserByEmail(email);
		
		if(user_nm.isPresent())
		{
			// Creating the encryption
			String encrypted_email = bCrypt.encode(email);
			encrypted_email=encrypted_email.replaceAll("/", "-");
			
			// Saving the user information
			user_nm.get().setReset_token(encrypted_email);
			user_repository.save(user_nm.get());
			
			// Sending the password reset token
			String appUrl = host_name+"/#/resetpassword/"+user_nm.get().getReset_token();
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom(from_mail);
			passwordResetEmail.setTo(email);
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl);
			javaMailSender.send(passwordResetEmail);
			
			// Sending the response
			return ResponseEntity.ok().build();
			
		}
		else
		{
			logger.error("User not available");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/forgetpassword")
	public ResponseEntity<Object> updateUser(@RequestBody String request) throws JSONException {
		
		// Getting the token and password form the request
		JSONObject jso = new JSONObject(request);
		String token = jso.getString("token");
		String password = jso.getString("password");
		
		
		Optional<User> user_token = user_repository.findUserByResetToken(token);
		
		if (user_token.isPresent()) {
			
			//Updating user with new password
			user_token.get().setUser_password(password);
			user_repository.save(user_token.get());
			return ResponseEntity.ok().build();
			
		} else {
			System.out.println();
			logger.error("user not available");
			return ResponseEntity.notFound().build();
		}		
		

	}
	
	
}
