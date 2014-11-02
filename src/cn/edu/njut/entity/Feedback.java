package cn.edu.njut.entity;

import java.text.DateFormat;
import java.util.Date;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private Integer fbid;
	private String schoolnumber;
	private String content;
	private String date;

	// Constructors
	
	public Feedback(String schoolnumber,String content)
	{
		this.schoolnumber=schoolnumber;
		this.content=content;
		Date date=new Date();
		DateFormat dateFormat=DateFormat.getDateInstance();
		String datestr=dateFormat.format(date);
		this.date=datestr;
	}

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(String schoolnumber, String content, String date) {
		this.schoolnumber = schoolnumber;
		this.content = content;
		this.date = date;
	}

	// Property accessors

	public Integer getFbid() {
		return this.fbid;
	}

	public void setFbid(Integer fbid) {
		this.fbid = fbid;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}