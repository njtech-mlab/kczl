package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.TStudentCourse;
import cn.edu.njut.subsidiary.Infocard;

import com.opensymphony.xwork2.ActionContext;

public class InfoCardStreamAction {
	private Integer ctid;
	private Integer lastupdate;

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public Integer getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Integer lastupdate) {
		this.lastupdate = lastupdate;
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

		Dao dao = new Dao();
		String sql = null;
		Date date = new Date();
		String datestamp = DateFormat.getDateInstance().format(date);
		List<Infocard> iclist = new ArrayList<Infocard>();
		@SuppressWarnings("unchecked")
		int total = ((List<TStudentCourse>) dao.getByHql("FROM TStudentCourse tsc WHERE tsc.courseTask.ctid=" + ctid)).size();
		int loopCount = 0;
		if (lastupdate == null) {
			List tmp = dao.findBySQL("select dayofyear('" + datestamp + "')");
			lastupdate = Integer.parseInt(tmp.get(0).toString());
			while(iclist.size() == 0 && loopCount < 10) {
				sql = "select count(case when learning_effect=1 then 1 else null end),count(case when learning_effect=2 then 1 else null end),count(case when learning_effect=3 then 1 else null end),count(case when learning_effect=4 then 1 else null end),count(case when learning_effect=5 then 1 else null end),count(schoolnumber),avg(learning_effect),avg(arrangement),avg(attendance),avg(speed),substring_index(`timestamp`,' ',1) from course_advice where ctid=" + ctid + " and dayofyear(substring_index(`timestamp`,' ',1))<=" + lastupdate + " and dayofyear(substring_index(`timestamp`,' ',1))>" + lastupdate + "-14 group by substring_index(`timestamp`,' ',1)";
				List l = dao.findBySQL(sql);
				for (int i = 0; i < l.size(); i++) {
					int onestar = Integer.parseInt((((Object[]) l.get(i))[0].toString()));
					int twostar = Integer.parseInt((((Object[]) l.get(i))[1].toString()));
					int threestar = Integer.parseInt((((Object[]) l.get(i))[2].toString()));
					int fourstar = Integer.parseInt((((Object[]) l.get(i))[3].toString()));
					int fivestar = Integer.parseInt((((Object[]) l.get(i))[4].toString()));
					int num = Integer.parseInt((((Object[]) l.get(i))[5].toString()));
					int learningEffect = (int) Double.parseDouble((((Object[]) l.get(i))[6].toString()));
					int arrangement = (int) Double.parseDouble((((Object[]) l.get(i))[7].toString()));
					int attendance = (int) Double.parseDouble((((Object[]) l.get(i))[8].toString()));
					int speed = (int) Double.parseDouble((((Object[]) l.get(i))[9].toString()));
					String datestamptmp = ((Object[]) l.get(i))[10].toString();
					Infocard ic = new Infocard(learningEffect, arrangement,attendance,speed,num,total,onestar,twostar,threestar,fourstar,fivestar,datestamptmp);
					iclist.add(ic);
				}
				lastupdate -= 14;
				loopCount++;
				
			}
			JSONArray array = JSONArray.fromObject(iclist);
			String json = array.toString();
			writer.write("json:" + json + " \n lastupdate:" + lastupdate);
			writer.flush();
			return;
		}
		
		// lastupdate != null 
		while(iclist.size() == 0 && loopCount < 10) {
			sql = "select count(case when learning_effect=1 then 1 else null end),count(case when learning_effect=2 then 1 else null end),count(case when learning_effect=3 then 1 else null end),count(case when learning_effect=4 then 1 else null end),count(case when learning_effect=5 then 1 else null end),count(schoolnumber),avg(learning_effect),avg(arrangement),avg(attendance),avg(speed),substring_index(`timestamp`,' ',1) from course_advice where ctid=" + ctid + " and dayofyear(substring_index(`timestamp`,' ',1))<=" + lastupdate + " and dayofyear(substring_index(`timestamp`,' ',1))>" + lastupdate + "-14 group by substring_index(`timestamp`,' ',1)";
			List l = dao.findBySQL(sql);
			for (int i = 0; i < l.size(); i++) {
				int onestar = Integer.parseInt((((Object[]) l.get(i))[0].toString()));
				int twostar = Integer.parseInt((((Object[]) l.get(i))[1].toString()));
				int threestar = Integer.parseInt((((Object[]) l.get(i))[2].toString()));
				int fourstar = Integer.parseInt((((Object[]) l.get(i))[3].toString()));
				int fivestar = Integer.parseInt((((Object[]) l.get(i))[4].toString()));
				int num = Integer.parseInt((((Object[]) l.get(i))[5].toString()));
				int learningEffect = (int) Double.parseDouble((((Object[]) l.get(i))[6].toString()));
				int arrangement = (int) Double.parseDouble((((Object[]) l.get(i))[7].toString()));
				int attendance = (int) Double.parseDouble((((Object[]) l.get(i))[8].toString()));
				int speed = (int) Double.parseDouble((((Object[]) l.get(i))[9].toString()));
				String datestamptmp = ((Object[]) l.get(i))[10].toString();
				Infocard ic = new Infocard(learningEffect, arrangement,attendance,speed,num,total,onestar,twostar,threestar,fourstar,fivestar,datestamptmp);
				iclist.add(ic);
			}
			lastupdate -= 14;
			loopCount++;
		}
		JSONArray array = JSONArray.fromObject(iclist);
		String json = array.toString();
		writer.write("json:" + json + " \n lastupdate:" + lastupdate);
		writer.flush();
		return;
	}
}
