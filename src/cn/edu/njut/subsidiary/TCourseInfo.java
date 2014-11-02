package cn.edu.njut.subsidiary;

import java.util.List;

public class TCourseInfo {
	private Integer ctid;
	private String coursename;
	private String courseNature;
	private String courseCategory;
	private String credit;
	private String natureclass;
	private List schedule;
	
	
	public TCourseInfo(Integer ctid, String coursename, String courseNature, String courseCategory, String credit, String natureclass, List schedule)
	{
		this.ctid=ctid;
		this.coursename=coursename;
		this.courseNature=courseNature;
		this.courseCategory=courseCategory;
		this.credit=credit;
		this.natureclass=natureclass;
		this.setSchedule(schedule);
	}
	
	public TCourseInfo()
	{}
	
	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseNature() {
		return courseNature;
	}
	public void setCourseNature(String courseNature) {
		this.courseNature = courseNature;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getNatureclass() {
		return natureclass;
	}
	public void setNatureclass(String natureclass) {
		this.natureclass = natureclass;
	}

	public List getSchedule() {
		return schedule;
	}

	public void setSchedule(List schedule) {
		this.schedule = schedule;
	}
	
	
}
