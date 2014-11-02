package cn.edu.njut.common.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.njut.entity.User;

public class SaveCookie {
	public static void saveCookie(User user) throws NoSuchAlgorithmException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		String sessioncode = CreateLicence.createLicence(user.getEmail()+user.getUserpwd());

		user.setSessioncode(sessioncode);

		Cookie sessioncodeCookie = new Cookie("sessioncode", sessioncode);
		sessioncodeCookie.setMaxAge(60 * 60 * 24 * 365);
		Cookie emailCookie = new Cookie("email", user.getEmail());
		emailCookie.setMaxAge(60 * 60 * 24 * 365);
		
		response.addCookie(sessioncodeCookie);
		response.addCookie(emailCookie);
	}
}
