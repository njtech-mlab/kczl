package cn.edu.njut.common.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.User;

public class CheckUser {
	public static boolean checkUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 1) //排除JSESSIONID
			return false;

		String userEmail = null;
		String sessioncode = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("email"))
				userEmail = cookies[i].getValue();
			if (cookies[i].getName().equals("sessioncode"))
				sessioncode = cookies[i].getValue();
		}

		String str = (String) ServletActionContext.getContext()
				.getApplication().get(userEmail);
		if (sessioncode.equals(str)) {
			return true;
		}
		String hql = "FROM User u WHERE u.email='" + userEmail + "'";
		Dao dao = new Dao();
		User user = (User) dao.getOne(hql);
		if (user!=null && sessioncode.equals(user.getSessioncode()))
			return true;
		return false;
	}
	
	public static String getSchoolnumber() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		String schoolnumber = null;
		for (int i = 0; i < cookies.length; i++)
			if (cookies[i].getName().equals("email"))
				schoolnumber = cookies[i].getValue();
		return schoolnumber;
	}
}
