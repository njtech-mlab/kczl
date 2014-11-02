package cn.edu.njut.subsidiary;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Likelist;
import cn.edu.njut.entity.SchoolCourse;

public class EvlDailyInfo {
	private EvlDaily evldaily;
	private int likenum;
	private CommentList commentlist;
	private String coursename;
	private String everlike;
	
	public EvlDaily getEvldaily() {
		return evldaily;
	}
	public void setEvldaily(EvlDaily evldaily) {
		this.evldaily = evldaily;
	}
	public String getEverlike() {
		return everlike;
	}
	public void setEverlike(String everlike) {
		this.everlike = everlike;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public CommentList getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(CommentList commentlist) {
		this.commentlist = commentlist;
	}
	
	public EvlDailyInfo(EvlDaily evldaily) {
		this.evldaily = evldaily;
		Dao dao = new Dao();
		int likenum = (dao.getByHql("FROM Likelist l WHERE l.infoid=" + evldaily.getEdid())).size();
		this.likenum = likenum;
		this.commentlist = new CommentList(evldaily, "EvlDaily");
		CourseTask ct = (CourseTask) dao.getOne("FROM CourseTask ct WHERE ct.ctid=" + evldaily.getCtid());
		SchoolCourse sc = (SchoolCourse) dao.getOne("FROM SchoolCourse sc WHERE sc.scid=" + ct.getSchoolCourse().getScid());
		coursename = sc.getCoursename();
		
		/*
		 * * 检查用户是否赞过这条状态
		 */
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		String schoolnumber = null;
		for (int i = 0; i < cookies.length; i++)
			if (cookies[i].getName().equals("email"))
				schoolnumber = cookies[i].getValue();
		Likelist ll = (Likelist) dao.getOne("FROM Likelist ll WHERE ll.infoid=" + evldaily.getEdid() + " AND ll.fromuser='" + schoolnumber + "' AND ll.touser='" + evldaily.getSchoolnumber() + "'");
		if(ll == null)
			everlike = "false";
		else 
			everlike = "true";
	}
}
