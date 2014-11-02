package cn.edu.njut.common.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.entity.SchoolTeacher;

import com.opensymphony.xwork2.ActionContext;

public class TeacherCookie {
	public static void saveCookie(SchoolTeacher schoolTeacher) throws NoSuchAlgorithmException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		String sessioncode = CreateLicence.createLicence(schoolTeacher.getPersonnelNumber()+schoolTeacher.getPassword());

		schoolTeacher.setSessioncode(sessioncode);

		Cookie sessioncodeCookie = new Cookie("sessioncode", sessioncode);
		sessioncodeCookie.setMaxAge(60 * 60 * 24 * 365);
		Cookie personnelnumberCookie = new Cookie("personnelnumber", schoolTeacher.getPersonnelNumber());
		personnelnumberCookie.setMaxAge(60 * 60 * 24 * 365);
		
		response.addCookie(sessioncodeCookie);
		response.addCookie(personnelnumberCookie);
	}
}
