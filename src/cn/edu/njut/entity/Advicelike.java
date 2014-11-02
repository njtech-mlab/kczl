package cn.edu.njut.entity;

/**
 * Advicelike entity. @author MyEclipse Persistence Tools
 */

public class Advicelike implements java.io.Serializable {

	// Fields

	private Integer likeid;
	private Integer infoid;
	private String fromuser;
	private String touser;

	// Constructors

	/** default constructor */
	public Advicelike() {
	}

	/** full constructor */
	public Advicelike(Integer infoid, String fromuser, String touser) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
	}

	// Property accessors

	public Integer getLikeid() {
		return this.likeid;
	}

	public void setLikeid(Integer likeid) {
		this.likeid = likeid;
	}

	public Integer getInfoid() {
		return this.infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}

	public String getFromuser() {
		return this.fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	public String getTouser() {
		return this.touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

}