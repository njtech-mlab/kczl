package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Field entity. @author MyEclipse Persistence Tools
 */

public class Field implements java.io.Serializable {

	// Fields

	private Integer fiid;
	private College college;
	private String fieldcode;
	private String fieldname;
	private Set schoolStudents = new HashSet(0);
	private Set natureClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Field() {
	}

	/** full constructor */
	public Field(College college, String fieldcode, String fieldname,
			Set schoolStudents, Set natureClasses) {
		this.college = college;
		this.fieldcode = fieldcode;
		this.fieldname = fieldname;
		this.schoolStudents = schoolStudents;
		this.natureClasses = natureClasses;
	}

	// Property accessors

	public Integer getFiid() {
		return this.fiid;
	}

	public void setFiid(Integer fiid) {
		this.fiid = fiid;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getFieldcode() {
		return this.fieldcode;
	}

	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}

	public String getFieldname() {
		return this.fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Set getSchoolStudents() {
		return this.schoolStudents;
	}

	public void setSchoolStudents(Set schoolStudents) {
		this.schoolStudents = schoolStudents;
	}

	public Set getNatureClasses() {
		return this.natureClasses;
	}

	public void setNatureClasses(Set natureClasses) {
		this.natureClasses = natureClasses;
	}

}