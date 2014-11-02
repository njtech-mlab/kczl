package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.NotifyService;
import cn.edu.njut.entity.Comment;
import cn.edu.njut.entity.Notification;

import com.opensymphony.xwork2.ActionContext;

public class TeacherReplyAction {
	private Integer edid;
	private String from;
	private String to;
	private String content;
	private Integer tag;
	private Integer commentid;
	
	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		if (CheckTeacher.checkTeacher() == false) 
		{
			writer.write("{\"msg\":\"failed to check teacher\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		if(edid == null || edid.equals("") || from == null || from.equals("") || to == null || to.equals("") || content == null || content.equals("") || tag == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		if(tag == 1) {	// comment
			String notifyContent = content;
			content = "[T]" + content;
			Comment c = new Comment(edid, from, to, content, "[T]");
			dao.save(c);
			Notification n = new Notification(edid, from, to, "[T]you get a COMMENT");
			dao.save(n);
			writer.write("{\"msg\":\"succeed\"}");
			writer.flush();
			NotifyService.pushSingleAccount(to, "new COMMENT", "[T,SPIT,"+ edid + "]" + notifyContent);
			return;
		}
		
		if(tag == 0) {	// cancel
			if(commentid == null) {
				writer.write("{\"msg\":error\"}");
				writer.flush();
				return;
			}
			Comment c = (Comment)dao.getOne("FROM Comment c WHERE c.commentid=" + commentid);
			dao.delete(c);
			Notification n = (Notification)dao.getOne("FROM Notification n WHERE n.content='[T]you get a COMMENT' AND n.infoid=" + edid + " AND n.fromuser='" + from + "' AND n.touser='" + to + "'");
			if(n != null)
				dao.delete(n);
			writer.write("{\"msg\":\"deleting succeed\"}");
			writer.flush();
			return;
		}
	}
}
