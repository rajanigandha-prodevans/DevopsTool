package com.prodevans.DevOpsAssessmentTool.assessment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "assessment_id", "assessment_name", "assessment_description" })
public class AssessmentRequestWrapper {

	@JsonProperty("assessment_id")
	private Integer assessmentId;
	@JsonProperty("assessment_name")
	private String assessmentName;
	@JsonProperty("assessment_description")
	private String assessmentDescription;

	
	public AssessmentRequestWrapper() {
		super();
	}

	public AssessmentRequestWrapper(Integer assessmentId, String assessmentName, String assessmentDescription) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentName = assessmentName;
		this.assessmentDescription = assessmentDescription;
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

	@Override
	public String toString() {
		return "AssessmentRequestWrapper [assessmentId=" + assessmentId + ", assessmentName=" + assessmentName
				+ ", assessmentDescription=" + assessmentDescription + "]";
	}

	
}