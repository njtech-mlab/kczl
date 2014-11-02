package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SchoolCourse entity. @author MyEclipse Persistence Tools
 */

public class SchoolCourse implements java.io.Serializable {

	// Fields

	private Integer scid;
	private College college;
	private String coursename;
	private String coursenumber;
	private Set courseTasks = new HashSet(0);

	// Constructors

	/** default constructor */
	public SchoolCourse() {
	}

	/** minimal constructor */
	public SchoolCourse(String coursenumber) {
		this.coursenumber = coursenumber;
	}

	/** full constructor */
	public SchoolCourse(College college, String coursename,
			String coursenumber, Set courseTasks) {
		this.college = college;
		this.coursename = coursename;
		this.coursenumber = coursenumber;
		this.courseTasks = courseTasks;
	}

	// Property accessors

	public Integer getScid() {
		return this.scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursenumber() {
		return this.coursenumber;
	}

	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}

	public Set getCourseTasks() {
		return this.courseTasks;
	}

	public void setCourseTasks(Set courseTasks) {
		this.courseTasks = courseTasks;
	}

}