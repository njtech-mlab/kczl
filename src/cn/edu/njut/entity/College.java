package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College implements java.io.Serializable {

	// Fields

	private Integer coid;
	private University university;
	private String collegecode;
	private String collegename;
	private Set fields = new HashSet(0);
	private Set schoolCourses = new HashSet(0);
	private Set schoolTeachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public College() {
	}

	/** full constructor */
	public College(University university, String collegecode,
			String collegename, Set fields, Set schoolCourses,
			Set schoolTeachers) {
		this.university = university;
		this.collegecode = collegecode;
		this.collegename = collegename;
		this.fields = fields;
		this.schoolCourses = schoolCourses;
		this.schoolTeachers = schoolTeachers;
	}

	// Property accessors

	public Integer getCoid() {
		return this.coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public University getUniversity() {
		return this.university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public String getCollegecode() {
		return this.collegecode;
	}

	public void setCollegecode(String collegecode) {
		this.collegecode = collegecode;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public Set getFields() {
		return this.fields;
	}

	public void setFields(Set fields) {
		this.fields = fields;
	}

	public Set getSchoolCourses() {
		return this.schoolCourses;
	}

	public void setSchoolCourses(Set schoolCourses) {
		this.schoolCourses = schoolCourses;
	}

	public Set getSchoolTeachers() {
		return this.schoolTeachers;
	}

	public void setSchoolTeachers(Set schoolTeachers) {
		this.schoolTeachers = schoolTeachers;
	}

}