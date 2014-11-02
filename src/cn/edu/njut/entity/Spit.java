package cn.edu.njut.entity;

/**
 * Spit entity. @author MyEclipse Persistence Tools
 */

public class Spit implements java.io.Serializable {

	// Fields

	private Integer spitid;
	private String schoolnumber;
	private Integer ctid;
	private String content;
	private String timestamp;

	// Constructors

	/** default constructor */
	public Spit() {
	}

	/** minimal constructor */
	public Spit(String schoolnumber, Integer ctid) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
	}

	/** full constructor */
	public Spit(String schoolnumber, Integer ctid, String content,
			String timestamp) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
		this.content = content;
		this.timestamp = timestamp;
	}

	// Property accessors

	public Integer getSpitid() {
		return this.spitid;
	}

	public void setSpitid(Integer spitid) {
		this.spitid = spitid;
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

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}