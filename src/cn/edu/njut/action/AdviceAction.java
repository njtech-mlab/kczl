package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.DateTimeService;
import cn.edu.njut.common.service.EvaluationControl;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.EvlDaily;

import com.opensymphony.xwork2.ActionContext;

public class AdviceAction {
	private Integer effect = null;
	private Integer arrangement = null;
	private Integer attendance = null;
	private Integer speed = null;
	private String content = null;
	private Integer ctid = null;
	private String schoolnumber = null;
	private String endtime = null;
	private String starttime = null;

	public Integer getEffect() {
		return effect;
	}


	public void setEffect(Integer effect) {
		this.effect = effect;
	}


	public Integer getArrangement() {
		return arrangement;
	}


	public void setArrangement(Integer arrangement) {
		this.arrangement = arrangement;
	}


	public Integer getAttendance() {
		return attendance;
	}


	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}


	public Integer getSpeed() {
		return speed;
	}


	public void setSpeed(Integer speed) {
		this.speed = speed;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getCtid() {
		return ctid;
	}


	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}


	public String getSchoolnumber() {
		return schoolnumber;
	}


	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public void execute() throws IOException {
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

		if (schoolnumber == null || ctid == null || endtime == null || starttime == null) {
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
		
		int tag = EvaluationControl.getEvaluationControlInfo(schoolnumber,
				ctid, endtime, starttime);
		if (tag == 0) {
			writer.write("{\"msg\":\"out of coursetime scope\"}");
			writer.flush();
			return;
		}

		if (tag == 1) {
			writer.write("{\"msg\":\"please donot duplicate submissions\"}");
			writer.flush();
			return;
		}
		
		if (tag == 2) {
			try {
				Date date = new Date();
				DateFormat d = DateFormat.getDateTimeInstance();
				String timestamp = d.getDateTimeInstance().format(date);
				String weekday = DateTimeService.getWeekday();
				timestamp = timestamp + " " + weekday;
				CourseAdvice ca = new CourseAdvice(schoolnumber, ctid, effect, arrangement, attendance, speed, content, timestamp);
				dao.save(ca);
				writer.write("{\"msg\":\"succeed :)\"}");
				writer.flush();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			writer.write("{\"msg\":\"evaluation failed\"}");
			writer.flush();
			return;
		}
	}
}
