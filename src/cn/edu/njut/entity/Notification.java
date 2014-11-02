package cn.edu.njut.entity;

import java.text.DateFormat;
import java.util.Date;

/**
 * Notification entity. @author MyEclipse Persistence Tools
 */

public class Notification implements java.io.Serializable {

	// Fields

	private Integer notificationid;
	private Integer infoid;
	private String fromuser;
	private String touser;
	private String timestamp;
	private String content;

	// Constructors

	public Notification(Integer infoid, String fromuser, String touser, String content) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
		this.content = content;
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance();
		String timestr = dateformat.format(date);
		this.timestamp = timestr;
	}
	
	/** default constructor */
	public Notification() {
	}

	/** full constructor */
	public Notification(Integer infoid, String fromuser, String touser,
			String timestamp, String content) {
		this.infoid = infoid;
		this.fromuser = fromuser;
		this.touser = touser;
		this.timestamp = timestamp;
		this.content = content;
	}

	// Property accessors

	public Integer getNotificationid() {
		return this.notificationid;
	}

	public void setNotificationid(Integer notificationid) {
		this.notificationid = notificationid;
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

}