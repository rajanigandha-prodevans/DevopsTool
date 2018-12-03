package com.prodevans.DevOpsAssessmentTool.user.companysize;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_size")
public class CompanySize implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_size_id")
	private int company_size_id;
	
	@Column(name="size", nullable=false, unique=true)
	private String size;

	public CompanySize() {
		super();
		this.company_size_id = 0;
		this.size = "";
	}
	
	public CompanySize(int company_size_id, String size) {
		super();
		this.company_size_id = company_size_id;
		this.size = size;
	}

	public int getCompany_size_id() {
		return company_size_id;
	}

	public void setCompany_size_id(int company_size_id) {
		this.company_size_id = company_size_id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "CompanySize [company_size_id=" + company_size_id + ", size=" + size + "]";
	}
	

}
