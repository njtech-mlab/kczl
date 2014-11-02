package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.Likelist;
import cn.edu.njut.entity.Notification;

import com.opensymphony.xwork2.ActionContext;

public class LikeAction {
	private Integer edid;
	private String from;
	private String to;
	private Integer tag;
	
	public Integer getEdid() {
		return edid;
	}
	public void setEdid(Integer edid) {
		this.edid = edid;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	
	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"failed to check user\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		if(edid == null || from == null || to == null || tag == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		if(tag == 1) {	// like
			Likelist like = new Likelist(edid, from, to);
			dao.save(like);
			Notification n = new Notification(edid, from, to, "[S]you get a LIKE");
			dao.save(n);
			/*
			 * notify
			 */
			writer.write("{\"msg\":\"+1\"}");
			writer.flush();
			return;
		}
		
		if(tag == 0) {	// cancel
			Likelist like = (Likelist)dao.getOne("FROM Likelist l WHERE l.infoid=" + edid + " AND l.fromuser='" + from + "'");
			dao.delete(like);
			Notification n = (Notification)dao.getOne("FROM Notification n WHERE n.content='[S]you get a LIKE' AND n.infoid=" + edid + " AND n.fromuser='" + from + "'");
			if(n != null)
				dao.delete(n);
			writer.write("{\"msg\":\"-1\"}");
			writer.flush();
			return;
		}
	}
}

















