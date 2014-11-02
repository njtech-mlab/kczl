package cn.edu.njut.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.TStudentCourse;
import cn.edu.njut.subsidiary.Infocard;

import com.opensymphony.xwork2.ActionContext;

public class InfocardAction {
	private Integer ctid;
	private String date;
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if (CheckTeacher.checkTeacher() == false) {
			writer.write("{\"msg\":\"fail to check teacher\"}");
			writer.flush();
			return;
		}

		if (ctid == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		if(date == null)
			date = DateFormat.getDateInstance().format(new Date());
		
		Dao dao = new Dao();
		String hql = "FROM CourseAdvice ca WHERE ca.ctid=" + ctid + " AND ca.timestamp LIKE '" + date + "%'";
		@SuppressWarnings("unchecked")
		List<CourseAdvice> l = (List<CourseAdvice>) dao.getByHql(hql);
		if(l == null || l.size() == 0) {
			writer.write("no data");
			writer.flush();
			return;
		}
		int learningEffect = 0;
		int arrangement = 0;
		int attendance = 0;
		int speed = 0;
		int one = 0, two = 0, three = 0, four = 0, five = 0;
		for(int i=0; i<l.size(); i++) {
			CourseAdvice ca = l.get(i);
			learningEffect += ca.getLearningEffect();
			arrangement += ca.getArrangement();
			attendance += ca.getAttendance();
			speed += ca.getSpeed();
			switch(ca.getLearningEffect())
			{
			case 1:
				one++;
				break;
			case 2:
				two++;
				break;
			case 3:
				three++;
				break;
			case 4:
				four++;
				break;
			case 5:
				five++;
				break;
			}
		}
		learningEffect /= l.size();
		arrangement /= l.size();
		attendance /= l.size();
		speed /= l.size();
		
		//total of a class students
		hql = "FROM TStudentCourse tsc WHERE tsc.courseTask.ctid=" + ctid;
		@SuppressWarnings("unchecked")
		List<TStudentCourse> tscl = (List<TStudentCourse>) dao.getByHql(hql);
		
		Infocard ic = new Infocard(learningEffect, arrangement, attendance, speed, l.size(), tscl.size(), one, two, three, four, five,date);
		JSONObject object = JSONObject.fromObject(ic);
		String json = object.toString();
		writer.write(json);
		writer.flush();
		return;
	}
}
