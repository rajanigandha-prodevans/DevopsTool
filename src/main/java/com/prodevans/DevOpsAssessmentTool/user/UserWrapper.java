package com.prodevans.DevOpsAssessmentTool.user;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWrapper {
	@JsonProperty("companyName")
	private String companyName;
	@JsonProperty("companySize")
	private String companySize;
	@JsonProperty("country")
	private String country;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("industryType")
	private String industryType;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("user_email")
	private String userEmail;
	@JsonProperty("user_id")
	private Integer userId;

	
	
	public UserWrapper() {
		super();
	}

	public UserWrapper(String companyName, String companySize, String country, String firstName, String industryType,
			String lastName, String userEmail, Integer userId) {
		super();
		this.companyName = companyName;
		this.companySize = companySize;
		this.country = country;
		this.firstName = firstName;
		this.industryType = industryType;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userId = userId;
	}

	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("companySize")
	public String getCompanySize() {
		return companySize;
	}

	@JsonProperty("companySize")
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("industryType")
	public String getIndustryType() {
		return industryType;
	}

	@JsonProperty("industryType")
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("user_email")
	public String getUserEmail() {
		return userEmail;
	}

	@JsonProperty("user_email")
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@JsonProperty("user_id")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserWrapper [companyName=" + companyName + ", companySize=" + companySize + ", country=" + country
				+ ", firstName=" + firstName + ", industryType=" + industryType + ", lastName=" + lastName
				+ ", userEmail=" + userEmail + ", userId=" + userId + "]";
	}
	
	
}