package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * NatureClass entity. @author MyEclipse Persistence Tools
 */

public class NatureClass implements java.io.Serializable {

	// Fields

	private Integer ncid;
	private Field field;
	private String natureclassnumber;
	private String natureclassname;
	private Integer campusCode;
	private Set schoolStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public NatureClass() {
	}

	/** full constructor */
	public NatureClass(Field field, String natureclassnumber,
			String natureclassname, Integer campusCode, Set schoolStudents) {
		this.field = field;
		this.natureclassnumber = natureclassnumber;
		this.natureclassname = natureclassname;
		this.campusCode = campusCode;
		this.schoolStudents = schoolStudents;
	}

	// Property accessors

	public Integer getNcid() {
		return this.ncid;
	}

	public void setNcid(Integer ncid) {
		this.ncid = ncid;
	}

	public Field getField() {
		return this.field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public String getNatureclassnumber() {
		return this.natureclassnumber;
	}

	public void setNatureclassnumber(String natureclassnumber) {
		this.natureclassnumber = natureclassnumber;
	}

	public String getNatureclassname() {
		return this.natureclassname;
	}

	public void setNatureclassname(String natureclassname) {
		this.natureclassname = natureclassname;
	}

	public Integer getCampusCode() {
		return this.campusCode;
	}

	public void setCampusCode(Integer campusCode) {
		this.campusCode = campusCode;
	}

	public Set getSchoolStudents() {
		return this.schoolStudents;
	}

	public void setSchoolStudents(Set schoolStudents) {
		this.schoolStudents = schoolStudents;
	}

}