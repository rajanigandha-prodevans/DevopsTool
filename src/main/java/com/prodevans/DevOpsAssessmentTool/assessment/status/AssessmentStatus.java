package com.prodevans.DevOpsAssessmentTool.assessment.status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assessment_status")
public class AssessmentStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assessment_status_id")
	private int assessment_status_id;
	
	@Column(name="status", nullable=false, unique=true)
	private String status;

	public AssessmentStatus() {
		super();
		this.assessment_status_id = 0;
		this.status = "";
	}
	
	public AssessmentStatus(int assessment_status_id, String status) {
		super();
		this.assessment_status_id = assessment_status_id;
		this.status = status;
	}

	public int getAssessment_status_id() {
		return assessment_status_id;
	}

	public void setAssessment_status_id(int assessment_status_id) {
		this.assessment_status_id = assessment_status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AssessmentStatus [assessment_status_id=" + assessment_status_id + ", status=" + status + "]";
	}
	
	

}
