package com.prodevans.DevOpsAssessmentTool.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.prodevans.DevOpsAssessmentTool.category.question.AssessmentQuestion;

@Entity
@Table(name="question_category")
public class QuestionCategory implements Comparable<QuestionCategory> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int category_id;
	
	@Column(name="category_name", nullable=false, unique= true)
	private String category_name;


	@OneToMany(cascade=CascadeType.ALL, mappedBy="question_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AssessmentQuestion> assessmenQuestions;

	public QuestionCategory() {
		super();
		this.category_id = 0;
		this.category_name = "";
		this.assessmenQuestions = new ArrayList<>();
	}
	
	public QuestionCategory(int category_id, String category_name, List<AssessmentQuestion> assessmenQuestions) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.assessmenQuestions = assessmenQuestions;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "QuestionCategory [category_id=" + category_id + ", category_name=" + category_name + "]";
	}

	@Override
	public int compareTo(QuestionCategory o) {
		if (this.getCategory_id() <= o.getCategory_id())
			return -1;
		else
			return 0;
	}
}
