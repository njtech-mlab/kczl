package cn.edu.njut.entity;

/**
 * SchoolCalendar entity. @author MyEclipse Persistence Tools
 */

public class SchoolCalendar implements java.io.Serializable {

	// Fields

	private Integer schcaid;
	private String schoolyear;
	private String term;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer week;
	private Integer weekday;
	private String date;
	private String festival;

	// Constructors

	/** default constructor */
	public SchoolCalendar() {
	}

	/** full constructor */
	public SchoolCalendar(String schoolyear, String term, Integer year,
			Integer month, Integer day, Integer week, Integer weekday,
			String date, String festival) {
		this.schoolyear = schoolyear;
		this.term = term;
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
		this.weekday = weekday;
		this.date = date;
		this.festival = festival;
	}

	// Property accessors

	public Integer getSchcaid() {
		return this.schcaid;
	}

	public void setSchcaid(Integer schcaid) {
		this.schcaid = schcaid;
	}

	public String getSchoolyear() {
		return this.schoolyear;
	}

	public void setSchoolyear(String schoolyear) {
		this.schoolyear = schoolyear;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getWeek() {
		return this.week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Integer getWeekday() {
		return this.weekday;
	}

	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFestival() {
		return this.festival;
	}

	public void setFestival(String festival) {
		this.festival = festival;
	}

}