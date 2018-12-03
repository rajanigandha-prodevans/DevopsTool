/**
 * @author rajanigandhakhot

 * Title: KycQuestion.java
 * Date: 23/06/2018
 * Description: This Entity class contains kyc_question table configuration
 */
package com.prodevans.DevOpsAssessmentTool.category.question;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.prodevans.DevOpsAssessmentTool.category.QuestionCategory;
import com.prodevans.DevOpsAssessmentTool.category.option.QuestionOption;
import com.prodevans.DevOpsAssessmentTool.category.question.type.QuestionType;

@Entity
@Table(name="assessment_question")
public class AssessmentQuestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private int question_id;
	
	@Column(name="question", nullable=false)
	private String question;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_type_id")
	@NonNull
	private QuestionType questionType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	@NonNull
	private QuestionCategory questionCategory;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="assessmenQuestion", fetch=FetchType.EAGER) 
	private List<QuestionOption> questionOptions;
	
	public AssessmentQuestion() {
		super();
		this.question_id = 0;
		this.question = "";
		this.questionType = new QuestionType();
		this.questionCategory = new QuestionCategory();
		this.questionOptions =  new ArrayList<>();
	}
	
	public AssessmentQuestion(int question_id, String question, QuestionType questionType, QuestionCategory questionCategory, List<QuestionOption> questionOptions) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.questionType = questionType;
		this.questionCategory = questionCategory;
		this.questionOptions =  questionOptions;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}

	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}

	@Override
	public String toString() {
		return "AssessmentQuestion [question_id=" + question_id + ", question=" + question + ", questionType="
				+ questionType.toString() + ", questionCategory=" + questionCategory.toString() + ", questionOptions=" + questionOptions.toString()
				+ "]";
	}

	
}
