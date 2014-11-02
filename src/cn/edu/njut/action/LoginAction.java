package cn.edu.njut.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.AESEncrypt;
import cn.edu.njut.common.service.BasicInfoJSON;
import cn.edu.njut.common.service.Reserve;
import cn.edu.njut.common.service.ValidateUser;
import cn.edu.njut.entity.User;

public class LoginAction {
	private String email;
	private String password;
	private String deviceType;
	private String deviceToken;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		
		if(email==null || password==null || email.equals("") || password.equals(""))
		{
			writer.write("{\"msg\":\"login denied: email or password cannot be empty\"}");
			writer.flush();
			return;
		}
		password = AESEncrypt.encrypt(password);
		String hql = "FROM User u WHERE u.email='" + email + "'";
		Dao dao = new Dao();
		User user = (User) dao.getOne(hql);
		if (user == null){
			writer.write("{\"msg\":\"login denied: no such user\"}");
			writer.flush();
			return;
		}
		else if (password.equals(user.getUserpwd()) == false){
			writer.write("{\"msg\":\"login denied: wrong password\"}");
			writer.flush();
			return;
		}
		else {
			ValidateUser.validateUser(user);
			writer.write(BasicInfoJSON.createJSON(user));
			writer.flush();
			return;
		}
	}
}
