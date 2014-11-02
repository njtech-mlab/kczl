package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.TeacherInfoJSON;
import cn.edu.njut.common.service.ValidateTeacher;
import cn.edu.njut.entity.SchoolTeacher;

import com.opensymphony.xwork2.ActionContext;

public class TeacherLoginAction {
	private String personnelnumber;
	private String password;

	public String getPersonnelnumber() {
		return personnelnumber;
	}

	public void setPersonnelnumber(String personnelnumber) {
		this.personnelnumber = personnelnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if(personnelnumber==null || password==null || personnelnumber.equals("") || password.equals(""))
		{
			writer.write("{\"msg\":\"login denied: personnelnumber or password cannot be empty\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		SchoolTeacher schoolTeacher = (SchoolTeacher) dao.getOne("FROM SchoolTeacher st WHERE SUBSTRING(st.personnelNumber,9,4)='"+personnelnumber+"'");
		if (schoolTeacher == null){
			writer.write("{\"msg\":\"login denied: no such teacher\"}");
			writer.flush();
			return;
		}
		else if (password.equals(schoolTeacher.getPassword()) == false){
			writer.write("{\"msg\":\"login denied: wrong password\"}");
			writer.flush();
			return;
		}
		else {
			ValidateTeacher.validateTeacher(schoolTeacher);
			writer.write(TeacherInfoJSON.createJSON(schoolTeacher));
			writer.flush();
			return;
		}
	}
}
