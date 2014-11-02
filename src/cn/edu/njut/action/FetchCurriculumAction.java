package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.dao.JDBC;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.SchoolCourse;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.subsidiary.Schedule;
import cn.edu.njut.subsidiary.TCourseInfo;

import com.opensymphony.xwork2.ActionContext;

public class FetchCurriculumAction {
	public void execute() throws IOException, SQLException
	{
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		if (CheckTeacher.checkTeacher() == false) {
			writer.write("{\"msg\":\"failed to check teacher\"}");
			writer.flush();
			return;
		}
		Dao dao = new Dao();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();
		String personnelnumber = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("personnelnumber")) {
				personnelnumber = cookies[i].getValue();
				break;
			}
		}
		String hql=null;
		if (personnelnumber != null) {
			Parameter parameter=(Parameter)dao.getOne("FROM Parameter p WHERE p.unid=1 AND p.campusCode=1");
			
			hql = "FROM SchoolTeacher st WHERE st.personnelNumber='" + personnelnumber + "'";
			SchoolTeacher schoolTeacher = (SchoolTeacher) dao.getOne(hql);
			
			hql = "FROM CourseTask ct WHERE ct.schoolTeacher.stid="+schoolTeacher.getStid() + " AND ct.choosenumber LIKE '%"+parameter.getSchoolyear()+"-"+parameter.getTerm()+"%'";
			@SuppressWarnings("unchecked")
			List<CourseTask> courseTask=(List<CourseTask>)dao.getByHql(hql);
			ArrayList<TCourseInfo> list=new ArrayList<TCourseInfo>();
			for(int i=0;i<courseTask.size();i++)
			{
				SchoolCourse schoolCourse=(SchoolCourse)dao.getOne("FROM SchoolCourse sc WHERE sc.scid="+courseTask.get(i).getSchoolCourse().getScid());
				List<Schedule> schedule = new ArrayList<Schedule>();
				try {
					Connection conn = JDBC.getConnection();
					Statement st = (Statement) conn.createStatement();
					ResultSet rs = st.executeQuery("select * from v_schedule where ctid=" + courseTask.get(i).getCtid());
					while(rs.next()) {
						String beginweek = rs.getString("beginweek");
						String endweek = rs.getString("endweek");
						String beginsection = rs.getString("beginsection");
						String endsection = rs.getString("endsection");
						String day = rs.getString("day");
						String place = rs.getString("place");
						String oddoreven = rs.getString("oddoreven");
						Schedule s = new Schedule(beginweek, endweek, beginsection, endsection, day, place, oddoreven);
						schedule.add(s);
					}
					conn.close();
				} catch (SQLException e) {
				}
				list.add(new TCourseInfo(courseTask.get(i).getCtid(),schoolCourse.getCoursename(),courseTask.get(i).getCourseNature(),courseTask.get(i).getCourseCategory(),courseTask.get(i).getCredit(),courseTask.get(i).getNatureclass(),schedule));
			}
			String json=JSONArray.fromObject(list).toString();
			writer.write(json);
			writer.flush();
			return;
		}
	}
}
