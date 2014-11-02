package cn.edu.njut.common.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.SchoolTeacher;

public class CheckTeacher {
	public static boolean checkTeacher() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 1)
			return false;

		String personnelnumber = null;
		String sessioncode = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("personnelnumber"))
				personnelnumber = cookies[i].getValue();
			if (cookies[i].getName().equals("sessioncode"))
				sessioncode = cookies[i].getValue();
		}

		String str = (String) ServletActionContext.getContext()
				.getApplication().get(personnelnumber);
		if (sessioncode.equals(str)) {
			return true;
		}
		String hql = "FROM SchoolTeacher st WHERE st.personnelNumber='" + personnelnumber + "'";
		Dao dao = new Dao();
		SchoolTeacher schoolTeacher= (SchoolTeacher) dao.getOne(hql);
		if (schoolTeacher!=null && sessioncode.equals(schoolTeacher.getSessioncode()))
			return true;
		return false;
	}
}
