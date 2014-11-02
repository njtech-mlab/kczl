package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.AESEncrypt;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.CreateLicence;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.entity.User;

import com.opensymphony.xwork2.ActionContext;

public class TeacherChangePasswordAction {
	private String personnelnumber;
	private String originalpassword;
	private String newpassword;
	
	public String getPersonnelnumber() {
		return personnelnumber;
	}

	public void setPersonnelnumber(String personnelnumber) {
		this.personnelnumber = personnelnumber;
	}

	public String getOriginalpassword() {
		return originalpassword;
	}

	public void setOriginalpassword(String originalpassword) {
		this.originalpassword = originalpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void execute() throws IOException, NoSuchAlgorithmException
	{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		Dao dao=new Dao();
		
		if (CheckTeacher.checkTeacher() == false) 
		{
			writer.write("{\"msg\":\"failed to check teacher\"}");
			writer.flush();
			return;
		}
		
		if(personnelnumber==null || originalpassword==null || newpassword==null || personnelnumber.equals("") || originalpassword.equals("") || newpassword.equals(""))
		{
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		SchoolTeacher schoolTeacher = (SchoolTeacher) dao.getOne("FROM SchoolTeacher st WHERE SUBSTRING(st.personnelNumber,9,4)='"+personnelnumber+"'");
		if(schoolTeacher == null)
		{
			writer.write("{\"msg\":\"no such user\"}");
			writer.flush();
			return;
		}
		
		if(!originalpassword.equals(schoolTeacher.getPassword()))
		{
			writer.write("{\"msg\":\"fail:please input correct original password\"}");
			writer.flush();
			return;
		}
		
		String sessioncode = CreateLicence.createLicence(schoolTeacher.getPersonnelNumber()+schoolTeacher.getPassword());
		schoolTeacher.setSessioncode(sessioncode);
		schoolTeacher.setPassword(newpassword);
		dao.update(schoolTeacher);
		writer.write("{\"msg\":\"change password succeed\"}");
		writer.flush();
		return;
	}
}
