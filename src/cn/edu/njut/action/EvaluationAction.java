package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.EvaluationControl;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.EvlDaily;

public class EvaluationAction {
	private Integer effect = null;
	private Integer discipline = null;
	private Integer attendance = null;
	private Integer speed = null;
	private String advice = null;
	private Integer ctid = null;
	private String schoolnumber = null;
	private String endtime = null;

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

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

	public Integer getEffect() {
		return effect;
	}

	public void setEffect(Integer effect) {
		this.effect = effect;
	}

	public Integer getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
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

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public void execute() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"��֤�û�ʧ�ܣ������µ�¼\"}");
			writer.flush();
			return;
		}

		if (schoolnumber == null || ctid == null || endtime == null) {
			writer.write("{\"msg\":\"�벹���������������ύ\"}");
			writer.flush();
			return;
		}

		writer.write("您所使用的课程助理版本过低，我们已不再为此版本提供服务，请升级到最新版本，享受更多功能");
		writer.flush();
		return;
		/*
		Dao dao = new Dao();
		String hql = "FROM CourseTask ct WHERE ct.ctid=" + ctid;
		CourseTask courseTask = (CourseTask) dao.getOne(hql);
		if (courseTask == null) {
			writer.write("{\"msg\":\"no course task found\"}");
			writer.flush();
			return;
		}
		
		int tag = EvaluationControl.getEvaluationControlInfo(schoolnumber,
				ctid, endtime);
		if (tag == 0) {
			writer.write("{\"msg\":\"����ʧ�ܣ���û�¿���.....\"}");
			writer.flush();
			return;
		}

		if (tag == 1) {
			writer.write("{\"msg\":\"�˿γ̵��첻�����ظ�����\"}");
			writer.flush();
			return;
		}
		
		if (tag == 2) {
			try {
				Date date=new Date();
				DateFormat d1 = DateFormat.getDateTimeInstance();
				String timestamp = d1.format(date);
				CourseAdvice ca = new CourseAdvice(schoolnumber, ctid, effect, discipline, attendance, speed, advice, timestamp);
				EvlDaily ed = new EvlDaily(schoolnumber, effect, discipline, attendance, speed, advice, ctid, timestamp);
				dao.save(ca);
				dao.save(ed);
				writer.write("{\"msg\":\"�ѳɹ��ύ��������������ʦ��лл :)\"}");
				writer.flush();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			writer.write("{\"msg\":\"evaluation failed\"}");
			writer.flush();
			return;
		}
		*/
	}
}
