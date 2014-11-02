package cn.edu.njut.entity;

/**
 * TeacherReply entity. @author MyEclipse Persistence Tools
 */

public class TeacherReply implements java.io.Serializable {

	// Fields

	private Integer trid;
	private Integer stid;
	private Integer ctid;
	private String schoolnumber;
	private String datetime;
	private String content;

	// Constructors

	/** default constructor */
	public TeacherReply() {
	}

	/** full constructor */
	public TeacherReply(Integer stid, Integer ctid, String schoolnumber,
			String datetime, String content) {
		this.stid = stid;
		this.ctid = ctid;
		this.schoolnumber = schoolnumber;
		this.datetime = datetime;
		this.content = content;
	}

	// Property accessors

	public Integer getTrid() {
		return this.trid;
	}

	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	public Integer getStid() {
		return this.stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public Integer getCtid() {
		return this.ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}