package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * University entity. @author MyEclipse Persistence Tools
 */

public class University implements java.io.Serializable {

	// Fields

	private Integer unid;
	private String universityname;
	private Set districts = new HashSet(0);
	private Set colleges = new HashSet(0);

	// Constructors

	/** default constructor */
	public University() {
	}

	/** full constructor */
	public University(String universityname, Set districts, Set colleges) {
		this.universityname = universityname;
		this.districts = districts;
		this.colleges = colleges;
	}

	// Property accessors

	public Integer getUnid() {
		return this.unid;
	}

	public void setUnid(Integer unid) {
		this.unid = unid;
	}

	public String getUniversityname() {
		return this.universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}

	public Set getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set districts) {
		this.districts = districts;
	}

	public Set getColleges() {
		return this.colleges;
	}

	public void setColleges(Set colleges) {
		this.colleges = colleges;
	}

}