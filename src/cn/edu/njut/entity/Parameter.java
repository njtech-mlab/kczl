package cn.edu.njut.entity;

/**
 * Parameter entity. @author MyEclipse Persistence Tools
 */

public class Parameter implements java.io.Serializable {

	// Fields

	private Integer paramid;
	private Integer unid;
	private Integer campusCode;
	private String schoolyear;
	private String term;
	private String beginDate;
	private Integer currentCoursetimeSeason;

	// Constructors

	/** default constructor */
	public Parameter() {
	}

	/** full constructor */
	public Parameter(Integer unid, Integer campusCode, String schoolyear,
			String term, String beginDate, Integer currentCoursetimeSeason) {
		this.unid = unid;
		this.campusCode = campusCode;
		this.schoolyear = schoolyear;
		this.term = term;
		this.beginDate = beginDate;
		this.currentCoursetimeSeason = currentCoursetimeSeason;
	}

	// Property accessors

	public Integer getParamid() {
		return this.paramid;
	}

	public void setParamid(Integer paramid) {
		this.paramid = paramid;
	}

	public Integer getUnid() {
		return this.unid;
	}

	public void setUnid(Integer unid) {
		this.unid = unid;
	}

	public Integer getCampusCode() {
		return this.campusCode;
	}

	public void setCampusCode(Integer campusCode) {
		this.campusCode = campusCode;
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

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getCurrentCoursetimeSeason() {
		return this.currentCoursetimeSeason;
	}

	public void setCurrentCoursetimeSeason(Integer currentCoursetimeSeason) {
		this.currentCoursetimeSeason = currentCoursetimeSeason;
	}

}