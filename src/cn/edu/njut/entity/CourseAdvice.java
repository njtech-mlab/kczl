package cn.edu.njut.entity;

/**
 * CourseAdvice entity. @author MyEclipse Persistence Tools
 */

public class CourseAdvice implements java.io.Serializable {

	// Fields

	private Integer caid;
	private String schoolnumber;
	private Integer ctid;
	private Integer learningEffect;
	private Integer arrangement;
	private Integer attendance;
	private Integer speed;
	private String content;
	private String timestamp;

	// Constructors

	/** default constructor */
	public CourseAdvice() {
	}

	/** minimal constructor */
	public CourseAdvice(String schoolnumber, Integer ctid) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
	}

	/** full constructor */
	public CourseAdvice(String schoolnumber, Integer ctid,
			Integer learningEffect, Integer arrangement, Integer attendance,
			Integer speed, String content, String timestamp) {
		this.schoolnumber = schoolnumber;
		this.ctid = ctid;
		this.learningEffect = learningEffect;
		this.arrangement = arrangement;
		this.attendance = attendance;
		this.speed = speed;
		this.content = content;
		this.timestamp = timestamp;
	}

	// Property accessors

	public Integer getCaid() {
		return this.caid;
	}

	public void setCaid(Integer caid) {
		this.caid = caid;
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

	public Integer getLearningEffect() {
		return this.learningEffect;
	}

	public void setLearningEffect(Integer learningEffect) {
		this.learningEffect = learningEffect;
	}

	public Integer getArrangement() {
		return this.arrangement;
	}

	public void setArrangement(Integer arrangement) {
		this.arrangement = arrangement;
	}

	public Integer getAttendance() {
		return this.attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	public Integer getSpeed() {
		return this.speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
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