package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CourseTask entity. @author MyEclipse Persistence Tools
 */

public class CourseTask implements java.io.Serializable {

	// Fields

	private Integer ctid;
	private SchoolCourse schoolCourse;
	private SchoolTeacher schoolTeacher;
	private String term;
	private String year;
	private String choosenumber;
	private String teachernameview;
	private String tab;
	private String courseNature;
	private String courseCategory;
	private String examMethod;
	private String courseBelonging;
	private String credit;
	private String natureclass;
	private Set courseSchedules = new HashSet(0);
	private Set TStudentCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CourseTask() {
	}

	/** full constructor */
	public CourseTask(SchoolCourse schoolCourse, SchoolTeacher schoolTeacher,
			String term, String year, String choosenumber,
			String teachernameview, String tab, String courseNature,
			String courseCategory, String examMethod, String courseBelonging,
			String credit, String natureclass, Set courseSchedules,
			Set TStudentCourses) {
		this.schoolCourse = schoolCourse;
		this.schoolTeacher = schoolTeacher;
		this.term = term;
		this.year = year;
		this.choosenumber = choosenumber;
		this.teachernameview = teachernameview;
		this.tab = tab;
		this.courseNature = courseNature;
		this.courseCategory = courseCategory;
		this.examMethod = examMethod;
		this.courseBelonging = courseBelonging;
		this.credit = credit;
		this.natureclass = natureclass;
		this.courseSchedules = courseSchedules;
		this.TStudentCourses = TStudentCourses;
	}

	// Property accessors

	public Integer getCtid() {
		return this.ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public SchoolCourse getSchoolCourse() {
		return this.schoolCourse;
	}

	public void setSchoolCourse(SchoolCourse schoolCourse) {
		this.schoolCourse = schoolCourse;
	}

	public SchoolTeacher getSchoolTeacher() {
		return this.schoolTeacher;
	}

	public void setSchoolTeacher(SchoolTeacher schoolTeacher) {
		this.schoolTeacher = schoolTeacher;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getChoosenumber() {
		return this.choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
	}

	public String getTeachernameview() {
		return this.teachernameview;
	}

	public void setTeachernameview(String teachernameview) {
		this.teachernameview = teachernameview;
	}

	public String getTab() {
		return this.tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getCourseNature() {
		return this.courseNature;
	}

	public void setCourseNature(String courseNature) {
		this.courseNature = courseNature;
	}

	public String getCourseCategory() {
		return this.courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public String getExamMethod() {
		return this.examMethod;
	}

	public void setExamMethod(String examMethod) {
		this.examMethod = examMethod;
	}

	public String getCourseBelonging() {
		return this.courseBelonging;
	}

	public void setCourseBelonging(String courseBelonging) {
		this.courseBelonging = courseBelonging;
	}

	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getNatureclass() {
		return this.natureclass;
	}

	public void setNatureclass(String natureclass) {
		this.natureclass = natureclass;
	}

	public Set getCourseSchedules() {
		return this.courseSchedules;
	}

	public void setCourseSchedules(Set courseSchedules) {
		this.courseSchedules = courseSchedules;
	}

	public Set getTStudentCourses() {
		return this.TStudentCourses;
	}

	public void setTStudentCourses(Set TStudentCourses) {
		this.TStudentCourses = TStudentCourses;
	}

}