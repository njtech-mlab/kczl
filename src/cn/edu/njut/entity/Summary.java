package cn.edu.njut.entity;

import java.text.DateFormat;
import java.util.Date;

/**
 * Summary entity. @author MyEclipse Persistence Tools
 */

public class Summary implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String schoolnumber;
	private Integer ctid;
	private String content;
	private String date;

	// Constructors
	
	public Summary(String schoolnumber, Integer ctid, String content) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
		this.content = content;
		Date date=new Date();
		DateFormat dateFormat=DateFormat.getDateInstance();
		String datestr=dateFormat.format(date);
		this.date = datestr;
	}

	/** default constructor */
	public Summary() {
	}

	/** full constructor */
	public Summary(String schoolnumber, Integer ctid, String content,
			String date) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
		this.content = content;
		this.date = date;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public Integer getCtid() {
		return this.ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
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