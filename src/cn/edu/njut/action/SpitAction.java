package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.DateTimeService;
import cn.edu.njut.common.service.EvaluationControl;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Spit;

import com.opensymphony.xwork2.ActionContext;

public class SpitAction {
	private String schoolnumber;
	private Integer ctid;
	private String content;
	private String starttime;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}
	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"fail to check user\"}");
			writer.flush();
			return;
		}

		if (schoolnumber == null || ctid == null || starttime == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}

		Dao dao = new Dao();
		String hql = "FROM CourseTask ct WHERE ct.ctid=" + ctid;
		CourseTask courseTask = (CourseTask) dao.getOne(hql);
		if (courseTask == null) {
			writer.write("{\"msg\":\"no course task found\"}");
			writer.flush();
			return;
		}
		
		Date date=new Date();
		DateFormat d=DateFormat.getTimeInstance();
		String timestr=d.format(date);
		String[] temp=timestr.split(":");
		if(temp[0].length()==1)
			temp[0]="0"+temp[0];
		timestr=temp[0]+":"+temp[1];
		if(timestr.compareTo(starttime)<0) {
			writer.write("{\"msg\":\"out of coursetime scope\"}");
			writer.flush();
			return;
		}
		
		String timestamp = d.getDateTimeInstance().format(date);
		String weekday = DateTimeService.getWeekday();
		timestamp = timestamp + " " + weekday;
		Spit spit = new Spit(schoolnumber, ctid, content, timestamp);
		dao.save(spit);
		writer.write("{\"msg\":\"succeed\"}");
		writer.flush();
		return;
	}
}
