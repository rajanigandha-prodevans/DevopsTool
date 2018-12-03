/**
 * @author rajanigandhakhot
 * Title: Company.java
 * Date: 23/06/2018
 * Description: This Entity class contains company table configuration
 */
package com.prodevans.DevOpsAssessmentTool.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prodevans.DevOpsAssessmentTool.assessment.Assessment;
import com.prodevans.DevOpsAssessmentTool.user.companysize.CompanySize;
import com.prodevans.DevOpsAssessmentTool.user.country.Country;
import com.prodevans.DevOpsAssessmentTool.user.industry.IndustryType;

@Entity
@Table(name="user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783794551542823834L;
	/**
	 *using BCryptPassword to Encrypt Password
	 */
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="first_name", nullable = false)
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="user_email", nullable = false, unique= true)
	private String user_email;

	@Column(name="company_name", nullable = false)
	private String CompanyName;
	
	@Column(name="reset_token")
	private String reset_token;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_size_id")
	@NotNull
	private CompanySize companySize;

	@JsonIgnore(value = true)
	@Column(name="user_password")
	@NotNull
	private String user_password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	@NotNull
	private Country country;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "industry_type_id")
	@NotNull
	private IndustryType industryType;

	@JsonIgnore(value = true)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Assessment> assessments;

	public User() {
		this.user_id = 0;
		this.first_name = "";
		this.last_name = "";
		this.user_email = "";
		this.reset_token="";
		CompanyName = "";
		this.companySize = new CompanySize();
		this.user_password = "";
		this.country = new Country();
		this.industryType = new IndustryType();
		this.assessments = new ArrayList<>();
	}

	

	public User(int user_id, String first_name, String last_name, String user_email, String reset_token, String companyName,
			CompanySize companySize, String user_password, Country country, IndustryType industryType,
			List<Assessment> assessments) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.reset_token=reset_token;
		CompanyName = companyName;
		this.companySize = companySize;
		this.user_password = user_password;
		this.country = country;
		this.industryType = industryType;
		this.assessments = assessments;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getReset_token() {
		return reset_token;
	}

	public void setReset_token(String reset_token) {
		this.reset_token = reset_token;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public CompanySize getCompanySize() {
		return companySize;
	}

	public void setCompanySize(CompanySize companySize) {
		this.companySize = companySize;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password =PASSWORD_ENCODER.encode(user_password); 
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public List<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_email="
				+ user_email + ", CompanyName=" + CompanyName + ", reset_token=" + reset_token + ", companySize="
				+ companySize + ", user_password=" + user_password + ", country=" + country + ", industryType="
				+ industryType + ", assessments=" + assessments + "]";
	}
}
