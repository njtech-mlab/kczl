package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.User;

import com.opensymphony.xwork2.ActionContext;

public class DeleteDeviceInfoAction {
	private String deviceType;
	private String username;
	
	public String getDeviceToken() {
		return username;
	}


	public void setDeviceToken(String username) {
		this.username = username;
	}


	public String getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
		Dao dao = new Dao();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();
		String userEmail = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("email")) {
				userEmail = cookies[i].getValue();
				break;
			}
		}
		
		if(username != null || !username.equals("")) {
			User user = (User) dao.getOne("FROM User u WHERE u.email='" + username + "'");
			if(deviceType.equals("Android")) {
				user.setAndroidDeviceToken(null);
				dao.update(user);
			}
			if(deviceType.equals("iOS")) {
				user.setIosDeviceToken(null);
				dao.update(user);
			}
			return;
		}
		
		User user = (User) dao.getOne("FROM User u WHERE u.email='" + userEmail + "'");
		if(deviceType.equals("Android")) {
			user.setAndroidDeviceToken(null);
			dao.update(user);
		}
		if(deviceType.equals("iOS")) {
			user.setIosDeviceToken(null);
			dao.update(user);
		}
	}
}
