package com.prodevans.DevOpsAssessmentTool.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "first_name", "last_name", "user_email", "company_size_id", "country_id", "industry_type_id",
		"companyName", "user_password" })
public class UserRequestWrapper {

	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("user_email")
	private String userEmail;
	@JsonProperty("company_size_id")
	private Integer companySizeId;
	@JsonProperty("country_id")
	private Integer countryId;
	@JsonProperty("industry_type_id")
	private Integer industryTypeId;
	@JsonProperty("companyName")
	private String companyName;
	@JsonProperty("user_password")
	private String userPassword;

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	@JsonProperty("company_size_id")
	public Integer getCompanySizeId() {
		return companySizeId;
	}

	@JsonProperty("company_size_id")
	public void setCompanySizeId(Integer companySizeId) {
		this.companySizeId = companySizeId;
	}

	@JsonProperty("country_id")
	public Integer getCountryId() {
		return countryId;
	}

	@JsonProperty("country_id")
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@JsonProperty("industry_type_id")
	public Integer getIndustryTypeId() {
		return industryTypeId;
	}

	@JsonProperty("industry_type_id")
	public void setIndustryTypeId(Integer industryTypeId) {
		this.industryTypeId = industryTypeId;
	}

	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("user_password")
	public String getUserPassword() {
		return userPassword;
	}

	@JsonProperty("user_password")
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}