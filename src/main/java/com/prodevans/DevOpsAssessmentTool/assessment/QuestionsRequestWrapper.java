package com.prodevans.DevOpsAssessmentTool.assessment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "question_id", "questionOptions" })
public class QuestionsRequestWrapper {

	@JsonProperty("question_id")
	private Integer questionId;
	
	@JsonProperty("questionOptions")
	private List<QuestionOption> questionOptions = null;


	@JsonProperty("question_id")
	public Integer getQuestionId() {
		return questionId;
	}

	@JsonProperty("question_id")
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@JsonProperty("questionOptions")
	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	@JsonProperty("questionOptions")
	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public QuestionsRequestWrapper() {
		super();
		this.questionId = 0;
	}
	
	public QuestionsRequestWrapper(Integer questionId) {
		super();
		this.questionId = questionId;

	}

	@Override
	public String toString() {
		return "QuestionsRequestWrapper [questionId=" + questionId + ", questionOptions=" + questionOptions + "]";
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "question_option_id" })
class QuestionOption {

	@JsonProperty("question_option_id")
	private Integer questionOptionId;
	
	@JsonProperty("question_option_id")
	public Integer getQuestionOptionId() {
		return questionOptionId;
	}

	@JsonProperty("question_option_id")
	public void setQuestionOptionId(Integer questionOptionId) {
		this.questionOptionId = questionOptionId;
	}
	
	public QuestionOption() {
		super();
		this.questionOptionId = 0;
	}

	public QuestionOption(Integer questionOptionId) {
		super();
		this.questionOptionId = questionOptionId;
	}

	@Override
	public String toString() {
		return "QuestionOption [questionOptionId=" + questionOptionId + "]";
	}

}