package cn.edu.njut.entity;

import java.text.DateFormat;
import java.util.Date;

/**
 * Advicecomment entity. @author MyEclipse Persistence Tools
 */

public class Advicecomment implements java.io.Serializable {

	// Fields

	private Integer commentid;
	private Integer infoid;
	private String fromuser;
	private String touser;
	private String timestamp;
	private String content;
	private String ts;

	// Constructors
	public Advicecomment(Integer infoid, String fromuser, String touser, String content, String ts) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
		this.content = content;
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance();
		String timestr = dateformat.format(date);
		this.timestamp = timestr;
		this.ts = ts;
	}

	/** default constructor */
	public Advicecomment() {
	}

	/** minimal constructor */
	public Advicecomment(Integer infoid, String fromuser, String touser) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
	}

	/** full constructor */
	public Advicecomment(Integer infoid, String fromuser, String touser,
			String timestamp, String content, String ts) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
		this.timestamp = timestamp;
		this.content = content;
		this.ts = ts;
	}

	// Property accessors

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
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

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}