package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.NotifyService;
import cn.edu.njut.entity.Advicecomment;
import cn.edu.njut.entity.Comment;
import cn.edu.njut.entity.Notification;

import com.opensymphony.xwork2.ActionContext;

public class AdviceCommmentAction {
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
		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"failed to check user\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		if(edid == null || edid.equals("") || from == null || from.equals("") || to == null || to.equals("") || content == null || content.equals("") || tag == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		String notifyContent = content;
		String temp = "[S]" + content;
		content = temp;
		if(tag == 1) {	// comment
			Advicecomment c = new Advicecomment(edid, from, to, content, "[S]");
			dao.save(c);
			Notification n = new Notification(edid, from, to, "[S]you get a COMMENT[ADVICE]");
			dao.save(n);
			writer.write("{\"msg\":\"succeed\"}");
			writer.flush();
			NotifyService.pushSingleAccount(to, "new COMMENT", "[S,ADVICE,"+ edid + "]" + notifyContent);
			return;
		}
		
		if(tag == 0) {	// cancel
			if(commentid == null) {
				writer.write("{\"msg\":error\"}");
				writer.flush();
				return;
			}
			Advicecomment c = (Advicecomment)dao.getOne("FROM Advicecomment c WHERE c.commentid=" + commentid);
			dao.delete(c);
			Notification n = (Notification)dao.getOne("FROM Notification n WHERE n.content='[S]you get a COMMENT[ADVICE]' AND n.infoid=" + edid + " AND n.fromuser='" + from + "' AND n.touser='" + to + "'");
			if(n != null)
				dao.delete(n);
			writer.write("{\"msg\":\"deleting succeed\"}");
			writer.flush();
			return;
		}
	}
}
