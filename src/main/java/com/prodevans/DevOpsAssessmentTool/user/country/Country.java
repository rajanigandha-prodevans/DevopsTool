/**
 * @author rajanigandhakhot
 * Title: Country.java
 * Date: 18/07/2018
 * Description: This Entity class contains Country table configuration
 */

package com.prodevans.DevOpsAssessmentTool.user.country;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private int country_id;
	
	@Column(name="country_name", nullable=false, unique=true)
	private String country_name;
	
	public Country() {
		super();
		this.country_id = 0;
		this.country_name = "";
	}
	
	public Country(int country_id, String country_name) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getcountry_name() {
		return country_name;
	}
	public void setcountry_name(String country_name) {
		this.country_name = country_name;
	}
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country_name=" + country_name + "]";
	}

	
}
