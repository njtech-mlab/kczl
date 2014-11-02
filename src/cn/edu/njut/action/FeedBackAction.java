package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.Feedback;

import com.opensymphony.xwork2.ActionContext;

public class FeedBackAction {
	private String schoolnumber;
	private String content;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}
	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void execute() throws IOException
	{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		if (CheckUser.checkUser() == false && CheckTeacher.checkTeacher() == false) {
			writer.write("{\"msg\":\"please log in\"}");
			writer.flush();
			return;
		}
		
		if(schoolnumber==null || content==null || schoolnumber.equals("") || content.equals(""))
		{
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		Dao dao=new Dao();
		Feedback feedback=new Feedback(schoolnumber,content);
		dao.save(feedback);
		writer.write("{\"msg\":\"feedback succeed\"}");
		writer.flush();
		return;
	}
}
