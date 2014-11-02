package cn.edu.njut.common.service;

import java.security.NoSuchAlgorithmException;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.SchoolTeacher;

public class ValidateTeacher {
	public static void validateTeacher(SchoolTeacher schoolTeacher) throws NoSuchAlgorithmException
	{
		TeacherCookie.saveCookie(schoolTeacher);
		ServletActionContext.getContext().getApplication().put(schoolTeacher.getPersonnelNumber(),schoolTeacher.getSessioncode());
		Dao dao=new Dao();
		dao.update(schoolTeacher);
	}
}
