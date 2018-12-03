package com.prodevans.DevOpsAssessmentTool.user.industry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="industry_type")
public class IndustryType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="industry_type_id")
	private int industry_type_id;
	
	@Column(name="industry_name", nullable = false, unique=true)
	private String industry_name;

	public IndustryType() {
		super();
		this.industry_type_id = 0;
		this.industry_name = "";
	}
	

	public IndustryType(int industry_type_id, String industry_name) {
		super();
		this.industry_type_id = industry_type_id;
		this.industry_name = industry_name;
	}

	public int getIndustry_type_id() {
		return industry_type_id;
	}

	public void setIndustry_type_id(int industry_type_id) {
		this.industry_type_id = industry_type_id;
	}

	public String getIndustry_name() {
		return industry_name;
	}

	public void setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
	}


	@Override
	public String toString() {
		return "IndustryType [industry_type_id=" + industry_type_id + ", industry_name=" + industry_name + "]";
	}
	
}
