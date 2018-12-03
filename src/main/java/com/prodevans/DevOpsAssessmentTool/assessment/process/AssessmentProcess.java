package com.prodevans.DevOpsAssessmentTool.assessment.process;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prodevans.DevOpsAssessmentTool.assessment.Assessment;
import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;
import com.prodevans.DevOpsAssessmentTool.category.option.QuestionOption;
import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

@Entity
@Table(name="assessment_process")
public class AssessmentProcess {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assessment_process_id")
	private long assessment_process_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="question_id")
	@NonNull
	private AssessmentQuestion assessmenQuestion;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="assessment_answer_table", joinColumns= @JoinColumn(name = "assessment_process_id"), inverseJoinColumns =@JoinColumn(name="question_option_id") )
	private List<QuestionOption> question_answers;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	@NonNull
	private QuestionCategory questionCategory;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="assessment_id")
	@NonNull
	private Assessment assessment;
	

	public AssessmentProcess() {
		super();
		this.assessment_process_id = 0;
		this.assessmenQuestion = new AssessmentQuestion();
		this.question_answers = new ArrayList<>();
		this.questionCategory = new QuestionCategory();
		this.assessment = new Assessment();
	}
	

	
	public AssessmentProcess(long assessment_process_id, AssessmentQuestion assessmenQuestion,
			List<QuestionOption> question_answers, QuestionCategory questionCategory, Assessment assessment) {
		super();
		this.assessment_process_id = assessment_process_id;
		this.assessmenQuestion = assessmenQuestion;
		this.question_answers = question_answers;
		this.questionCategory = questionCategory;
		this.assessment = assessment;
	}

	public long getAssessment_process_id() {
		return assessment_process_id;
	}
	
	public void setAssessment_process_id(long assessment_process_id) {
		this.assessment_process_id = assessment_process_id;
	}

	public AssessmentQuestion getAssessmenQuestion() {
		return assessmenQuestion;
	}

	public void setAssessmenQuestion(AssessmentQuestion assessmenQuestion) {
		this.assessmenQuestion = assessmenQuestion;
	}

	public List<QuestionOption> getquestion_answers() {
		return question_answers;
	}

	public void setquestion_answers(List<QuestionOption> question_answers) {
		this.question_answers = question_answers;
	}

	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}



	@Override
	public String toString() {
		return "AssessmentProcess [assessment_process_id=" + assessment_process_id + ", assessmenQuestion="
				+ assessmenQuestion + ", question_answers=" + question_answers + ", questionCategory=" + questionCategory
				+ ", assessment=" + assessment + "]";
	}

}
