package com.prodevans.DevOpsAssessmentTool.category.option;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

@Entity
@Table(name="question_option")
public class QuestionOption {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_option_id")
	private int question_option_id;
	
	@Column(name="question_option", length=250, nullable=false)
	private String question_option;
	
	@JsonIgnore
	@Column(name="weightage", nullable=false)
	private float weightage;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "question_id")
	@NonNull
	private AssessmentQuestion assessmenQuestion;

	public QuestionOption() {
		super();
		this.question_option_id = 0;
		this.question_option = "";
		this.weightage = 0;
		this.assessmenQuestion = new AssessmentQuestion();
	}

	public QuestionOption(int question_option_id, String question_option, float weightage,
			AssessmentQuestion assessmenQuestion) {
		super();
		this.question_option_id = question_option_id;
		this.question_option = question_option;
		this.weightage = weightage;
		this.assessmenQuestion = assessmenQuestion;
	}

	public int getQuestion_option_id() {
		return question_option_id;
	}

	public void setQuestion_option_id(int question_option_id) {
		this.question_option_id = question_option_id;
	}

	public String getQuestion_option() {
		return question_option;
	}

	public void setQuestion_option(String question_option) {
		this.question_option = question_option;
	}

	public float getWeightage() {
		return weightage;
	}

	public void setWeightage(float weightage) {
		this.weightage = weightage;
	}
	
	public AssessmentQuestion getAssessmenQuestion() {
		return assessmenQuestion;
	}
	
	public void setAssessmenQuestion(AssessmentQuestion assessmenQuestion) {
		this.assessmenQuestion = assessmenQuestion;
	}

	@Override
	public String toString() {
		return "QuestionOption [question_option_id=" + question_option_id + ", question_option=" + question_option
				+ ", weightage=" + weightage + "]";
	}

	

}
