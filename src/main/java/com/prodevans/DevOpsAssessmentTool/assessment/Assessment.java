package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.ArrayList;
import java.util.Date;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prodevans.DevOpsAssessmentTool.assessment.process.AssessmentProcess;
import com.prodevans.DevOpsAssessmentTool.assessment.result.AssessmentResult;
import com.prodevans.DevOpsAssessmentTool.assessment.status.AssessmentStatus;
import com.prodevans.DevOpsAssessmentTool.user.User;

@Entity
@Table(name="assessment")
public class Assessment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assessment_id")
	private int assessment_id;
	
	@Column(name="created_date", nullable=false)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date created_date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="assessment_status_id")
	@NonNull
	private AssessmentStatus assessmentStatus;
	
	@Column(name="assessment_name", nullable= false)
	private String assessment_name;
	
	@Column(name="assessment_description", nullable=false)
	private String assessment_description;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@NonNull
	private User user;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AssessmentResult> assessmentResults;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AssessmentProcess> assessmentProcesses;
	
	public Assessment() {
		super();
		this.assessment_id = 0;
		this.created_date = new Date();
		this.assessmentStatus = new AssessmentStatus();
		this.user=new User();
		this.assessmentResults = new ArrayList<>();
		this.assessmentProcesses = new ArrayList<>();
		
		this.assessment_name="";
		this.assessment_description="";
	}

	public Assessment(int assessment_id, Date created_date, AssessmentStatus assessmentStatus, String assessment_name,
			String assessment_description, User user, List<AssessmentResult> assessmentResults,
			List<AssessmentProcess> assessmentProcesses) {
		super();
		this.assessment_id = assessment_id;
		this.created_date = created_date;
		this.assessmentStatus = assessmentStatus;
		this.assessment_name = assessment_name;
		this.assessment_description = assessment_description;
		this.user = user;
		this.assessmentResults = assessmentResults;
		this.assessmentProcesses = assessmentProcesses;
	}

	public int getAssessment_id() {
		return assessment_id;
	}

	public void setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	

	public AssessmentStatus getAssessmentStatus() {
		return assessmentStatus;
	}


	public void setAssessmentStatus(AssessmentStatus assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

	public User getUser() {
		return user;
	}


	public String getAssessment_name() {
		return assessment_name;
	}

	public void setAssessment_name(String assessment_name) {
		this.assessment_name = assessment_name;
	}

	public String getAssessment_description() {
		return assessment_description;
	}

	public void setAssessment_description(String assessment_description) {
		this.assessment_description = assessment_description;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AssessmentResult> getAssessmentResults() {
		return assessmentResults;
	}

	public void setAssessmentResults(List<AssessmentResult> assessmentResults) {
		this.assessmentResults = assessmentResults;
	}

	public List<AssessmentProcess> getAssessmentProcesses() {
		return assessmentProcesses;
	}

	public void setAssessmentProcesses(List<AssessmentProcess> assessmentProcesses) {
		this.assessmentProcesses = assessmentProcesses;
	}


	@Override
	public String toString() {
		return "Assessment [assessment_id=" + assessment_id + ", created_date=" + created_date + ", assessmentStatus="
				+ assessmentStatus + ", assessment_name=" + assessment_name + ", assessment_description="
				+ assessment_description + ", user=" + user + "]";
	}

}
