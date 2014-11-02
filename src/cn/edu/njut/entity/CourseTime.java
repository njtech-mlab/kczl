package cn.edu.njut.entity;

/**
 * CourseTime entity. @author MyEclipse Persistence Tools
 */

public class CourseTime implements java.io.Serializable {

	// Fields

	private Integer cotiid;
	private District district;
	private Integer unid;
	private Integer season;
	private Integer section;
	private String begintime;
	private String endtime;

	// Constructors

	/** default constructor */
	public CourseTime() {
	}

	/** full constructor */
	public CourseTime(District district, Integer unid, Integer season,
			Integer section, String begintime, String endtime) {
		this.district = district;
		this.unid = unid;
		this.season = season;
		this.section = section;
		this.begintime = begintime;
		this.endtime = endtime;
	}

	// Property accessors

	public Integer getCotiid() {
		return this.cotiid;
	}

	public void setCotiid(Integer cotiid) {
		this.cotiid = cotiid;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Integer getUnid() {
		return this.unid;
	}

	public void setUnid(Integer unid) {
		this.unid = unid;
	}

	public Integer getSeason() {
		return this.season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getSection() {
		return this.section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public String getBegintime() {
		return this.begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}