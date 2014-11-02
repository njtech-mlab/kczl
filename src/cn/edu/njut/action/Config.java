package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.AESEncrypt;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.Reserve;
import cn.edu.njut.entity.User;

public class Config {
	public void execute() throws IOException {
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
		if(!userEmail.equals("1405110109")) {
			writer.write("{\"msg\":\"no permission\"}");
			writer.flush();
			return;
		}
		
		/////////////////////////////////////////
		/*
		System.out.println("start");
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) dao.getByHql("FROM User u WHERE u.userpwd = NULL");
		System.out.println(users.size());
		
		for(int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			String password = AESEncrypt.encrypt(u.getLastloginSystemVersion());
			u.setUserpwd(password);
			dao.update(u);
			System.out.println(i);
		}
		writer.write("DONE");
		writer.flush();
		return;
		*/
	}
}





