package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * District entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable {

	// Fields

	private Integer disid;
	private University university;
	private Integer campusCode;
	private String campusName;
	private Set courseTimes = new HashSet(0);

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(University university, Integer campusCode) {
		this.university = university;
		this.campusCode = campusCode;
	}

	/** full constructor */
	public District(University university, Integer campusCode,
			String campusName, Set courseTimes) {
		this.university = university;
		this.campusCode = campusCode;
		this.campusName = campusName;
		this.courseTimes = courseTimes;
	}

	// Property accessors

	public Integer getDisid() {
		return this.disid;
	}

	public void setDisid(Integer disid) {
		this.disid = disid;
	}

	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Integer getCampusCode() {
		return this.campusCode;
	}

	public void setCampusCode(Integer campusCode) {
		this.campusCode = campusCode;
	}

	public String getCampusName() {
		return this.campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public Set getCourseTimes() {
		return this.courseTimes;
	}

	public void setCourseTimes(Set courseTimes) {
		this.courseTimes = courseTimes;
	}

}