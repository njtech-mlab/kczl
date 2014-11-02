package cn.edu.njut.subsidiary;

public class TeacherReplyInfo {
	private String teachername;
	private String coursename;
	private String content;
	private String datetime;
	
	public String getTeachername() {
		return teachername;
	}


	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	public TeacherReplyInfo(String teachername, String coursename, String content, String datetime) {
		this.teachername = teachername;
		this.coursename = coursename;
		this.content = content;
		this.datetime = datetime;
	}
}
