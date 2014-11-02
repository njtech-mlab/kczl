package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.subsidiary.CourseAdviceInfo;

import com.opensymphony.xwork2.ActionContext;

public class TeacherInfoDetailAdviceAction {
private Integer edid;
	
	public Integer getEdid() {
		return edid;
	}

	public void setEdid(Integer edid) {
		this.edid = edid;
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
		if(edid == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		CourseAdvice advice = (CourseAdvice) dao.getOne("FROM CourseAdvice ca WHERE ca.caid=" + edid);
		CourseAdviceInfo info = new CourseAdviceInfo(advice);
		JSONObject object = JSONObject.fromObject(info);
		String json = object.toString();
		writer.write(json);
		writer.flush();
		return;
	}
}
