package cn.edu.njut.entity;

/**
 * MessageLog entity. @author MyEclipse Persistence Tools
 */

public class MessageLog implements java.io.Serializable {

	// Fields

	private Integer mlid;
	private String sender;
	private String destination;
	private String time;
	private String content;

	// Constructors

	/** default constructor */
	public MessageLog() {
	}

	/** full constructor */
	public MessageLog(String sender, String destination, String time,
			String content) {
		this.sender = sender;
		this.destination = destination;
		this.time = time;
		this.content = content;
	}

	// Property accessors

	public Integer getMlid() {
		return this.mlid;
	}

	public void setMlid(Integer mlid) {
		this.mlid = mlid;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}