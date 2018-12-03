package com.prodevans.DevOpsAssessmentTool.category.question.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_type")
public class QuestionType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_type_id")
	private int question_type_id;
	
	@Column(name="question_type", nullable= false, unique= true)
	private String question_type;

	public QuestionType() {
		super();
		this.question_type_id = 0;
		this.question_type = "";
	}
	public QuestionType(int question_type_id, String type) {
		super();
		this.question_type_id = question_type_id;
		this.question_type = type;
	}
	public int getQuestion_type_id() {
		return question_type_id;
	}
	public void setQuestion_type_id(int question_type_id) {
		this.question_type_id = question_type_id;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	@Override
	public String toString() {
		return "QuestionType [question_type_id=" + question_type_id + ", question_type=" + question_type + "]";
	}
	
}
