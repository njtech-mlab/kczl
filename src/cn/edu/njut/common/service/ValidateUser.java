package cn.edu.njut.common.service;

import java.security.NoSuchAlgorithmException;

import org.apache.struts2.ServletActionContext;


import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.User;

public class ValidateUser {
	public static void validateUser(User user) throws NoSuchAlgorithmException
	{
		SaveCookie.saveCookie(user);
		ServletActionContext.getContext().getApplication().put(user.getEmail(),user.getSessioncode());
		Dao dao=new Dao();
		dao.update(user);
	}
}
