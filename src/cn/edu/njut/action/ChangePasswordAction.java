package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.AESEncrypt;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.CreateLicence;
import cn.edu.njut.entity.User;

import com.opensymphony.xwork2.ActionContext;

public class ChangePasswordAction {
	private String email;
	private String originalpassword;
	private String newpassword;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		
		if (CheckUser.checkUser() == false) 
		{
			writer.write("{\"msg\":\"failed to check user\"}");
			writer.flush();
			return;
		}
		
		if(email==null || originalpassword==null || newpassword==null || email.equals("") || originalpassword.equals("") || newpassword.equals(""))
		{
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		User user=(User)dao.getOne("FROM User u WHERE u.email='"+email+"'");
		if(user==null)
		{
			writer.write("{\"msg\":\"no such user\"}");
			writer.flush();
			return;
		}
		
		String password = AESEncrypt.encrypt(originalpassword);
		
		if(!password.equals(user.getUserpwd()))
		{
			writer.write("{\"msg\":\"fail:please input correct original password\"}");
			writer.flush();
			return;
		}
		
		String sessioncode = CreateLicence.createLicence(user.getEmail()+user.getUserpwd());
		user.setSessioncode(sessioncode);
		user.setUserpwd(AESEncrypt.encrypt(newpassword));
		dao.update(user);
		writer.write("{\"msg\":\"change password succeed\"}");
		writer.flush();
		return;
	}
}
