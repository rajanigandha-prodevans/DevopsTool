package com.prodevans.DevOpsAssessmentTool.assessment.result;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prodevans.DevOpsAssessmentTool.assessment.Assessment;
import com.prodevans.DevOpsAssessmentTool.assessment.result_maturity.AssessmentResultMaturity;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;

@Entity
@Table(name="assessment_result")
public class AssessmentResult {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assessment_result_id")
	private int assessment_result_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	@NonNull
	private QuestionCategory question_category;
	
	@Column(name="category_total_score", nullable=false)
	private float category_total_score;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="assessment_id")
	@NonNull
	private Assessment assessment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="result_maturity_id")
	@NonNull
	private AssessmentResultMaturity resultMaturity;

	public AssessmentResult() {
		this.assessment_result_id = 0;
		this.question_category = new QuestionCategory();
		this.category_total_score = 0;
		this.assessment = new Assessment();
		this.resultMaturity = new AssessmentResultMaturity();
	}
	
	public AssessmentResult(int assessment_result_id, 
			QuestionCategory question_category, float category_total_score, Assessment assessment,
			AssessmentResultMaturity resultMaturity) {
		super();
		this.assessment_result_id = assessment_result_id;
		this.question_category = question_category;
		this.category_total_score = category_total_score;
		this.assessment = assessment;
		this.resultMaturity = resultMaturity;
	}

	public int getAssessment_result_id() {
		return assessment_result_id;
	}

	public void setAssessment_result_id(int assessment_result_id) {
		this.assessment_result_id = assessment_result_id;
	}

	public QuestionCategory getQuestion_category() {
		return question_category;
	}

	public void setQuestion_category(QuestionCategory question_category) {
		this.question_category = question_category;
	}

	public float getCategory_total_score() {
		return category_total_score;
	}

	public void setCategory_total_score(float category_total_score) {
		this.category_total_score = category_total_score;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public AssessmentResultMaturity getResultMaturity() {
		return resultMaturity;
	}

	public void setResultMaturity(AssessmentResultMaturity resultMaturity) {
		this.resultMaturity = resultMaturity;
	}

	@Override
	public String toString() {
		return "AssessmentResult [assessment_result_id=" + assessment_result_id + ",question_category=" + question_category + ", category_total_score="
				+ category_total_score + ", assessment=" + assessment + ", resultMaturity=" + resultMaturity + "]";
	}
	
}
