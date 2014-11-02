package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.TeacherReplyJSON;
import cn.edu.njut.entity.TeacherReply;

import com.opensymphony.xwork2.ActionContext;

public class FetchTeacherReplyAction {
	private String schoolnumber;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public void execute() throws IOException {
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
		if(schoolnumber == null) {
			writer.write("{\"msg\":\"schoolnumber cannot be empty\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		@SuppressWarnings("unchecked")
		List<TeacherReply> list = (List<TeacherReply>) dao.getByHql("FROM TeacherReply tr WHERE tr.schoolnumber='" + schoolnumber + "'");
		String json = TeacherReplyJSON.createJSON(list);
		
		for(int i=0; i<list.size(); i++) {
			dao.delete(list.get(i));
		}
		
		writer.write(json);
		writer.flush();
		return;
	}
}
