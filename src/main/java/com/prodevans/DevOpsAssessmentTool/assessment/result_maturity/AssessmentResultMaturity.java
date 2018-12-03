package com.prodevans.DevOpsAssessmentTool.assessment.result_maturity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="result_maturity")
public class AssessmentResultMaturity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="result_maturity_id")
	private int result_maturity_id;
	
	@Column(name="maturity_level", nullable=false, unique=true)
	private String maturity_level;

	public AssessmentResultMaturity() {
		super();
		this.result_maturity_id = 0;
		this.maturity_level = "";
	}
	
	public AssessmentResultMaturity(int result_maturity_id, String maturity_level) {
		super();
		this.result_maturity_id = result_maturity_id;
		this.maturity_level = maturity_level;
	}

	public int getResult_maturity_id() {
		return result_maturity_id;
	}

	public void setResult_maturity_id(int result_maturity_id) {
		this.result_maturity_id = result_maturity_id;
	}

	public String getMaturity_level() {
		return maturity_level;
	}

	public void setMaturity_level(String maturity_level) {
		this.maturity_level = maturity_level;
	}

	@Override
	public String toString() {
		return "ResultMaturity [result_maturity_id=" + result_maturity_id + ", maturity_level=" + maturity_level + "]";
	}
	
	
	

}
