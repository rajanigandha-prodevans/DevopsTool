package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "assessment_id", "assessment_name", "assessment_description", "assessmentStatus", "created_date" })
public class AssessmentResponseWrapper {

	@JsonProperty("assessment_id")
	private Integer assessmentId;
	@JsonProperty("assessment_name")
	private String assessmentName;
	@JsonProperty("assessment_description")
	private String assessmentDescription;
	@JsonProperty("assessmentStatus")
	private String assessmentStatus;
	@JsonProperty("created_date")
	private Date createdDate;

	public AssessmentResponseWrapper() {
		super();
	}

	public AssessmentResponseWrapper(Integer assessmentId, String assessmentName, String assessmentDescription,
			String assessmentStatus, Date createdDate) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentName = assessmentName;
		this.assessmentDescription = assessmentDescription;
		this.assessmentStatus = assessmentStatus;
		this.createdDate = createdDate;
	}

	@JsonProperty("assessment_id")
	public Integer getAssessmentId() {
		return assessmentId;
	}

	@JsonProperty("assessment_id")
	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	@JsonProperty("assessment_name")
	public String getAssessmentName() {
		return assessmentName;
	}

	@JsonProperty("assessment_name")
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	@JsonProperty("assessment_description")
	public String getAssessmentDescription() {
		return assessmentDescription;
	}

	@JsonProperty("assessment_description")
	public void setAssessmentDescription(String assessmentDescription) {
		this.assessmentDescription = assessmentDescription;
	}

	@JsonProperty("assessmentStatus")
	public String getAssessmentStatus() {
		return assessmentStatus;
	}

	@JsonProperty("assessmentStatus")
	public void setAssessmentStatus(String assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

	@JsonProperty("created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	@JsonProperty("created_date")
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}