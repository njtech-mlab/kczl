package cn.edu.njut.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.CurriculumInfoJSON;
import cn.edu.njut.entity.CourseSchedule;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.SchoolCourse;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.entity.User;
import cn.edu.njut.subsidiary.CourseInfo;

public class CurriculumAction {
	public void execute() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"failed to check user\"}");
			writer.flush();
			return;
		}
		Dao dao = new Dao();
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		Cookie[] cookies = request.getCookies();
		String userEmail = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("email")) {
				userEmail = cookies[i].getValue();
				break;
			}
		}
		String hql;
		if (userEmail != null) {
			hql = "FROM User u WHERE u.email='" + userEmail + "'";
			User user = (User) dao.getOne(hql);
			Parameter parameter=(Parameter)dao.getOne("FROM Parameter p WHERE p.unid=1 AND p.campusCode=1");
			hql = "SELECT ct FROM CourseTask ct,TStudentCourse tsc,SchoolStudent ss WHERE ct.choosenumber LIKE '%"+parameter.getSchoolyear()+"-"+parameter.getTerm()+"%' AND ss.ssid="
					+ user.getSchoolStudent().getSsid()
					+ "AND tsc.schoolStudent=ss AND tsc.courseTask=ct";
			@SuppressWarnings("unchecked")
			List<CourseTask> list = (List<CourseTask>) (dao.getByHql(hql));
			ArrayList<CourseInfo> courseInfo = new ArrayList<CourseInfo>();
			for (int i = 0; i < list.size(); i++) {
				CourseTask courseTask = (CourseTask) list.get(i);
				hql = "SELECT ct FROM CourseTask ct WHERE ct.ctid="
						+ courseTask.getCtid();
				courseTask = (CourseTask) dao.getOne(hql);
				hql = "SELECT sc FROM SchoolCourse sc WHERE sc.scid="
						+ courseTask.getSchoolCourse().getScid();
				SchoolCourse schoolCourse = (SchoolCourse) dao.getOne(hql);
				hql = "SELECT st FROM SchoolTeacher st WHERE st.stid="
						+ courseTask.getSchoolTeacher().getStid();
				SchoolTeacher schoolTeacher = (SchoolTeacher) dao.getOne(hql);
				hql = "SELECT cs FROM CourseSchedule cs,CourseTask ct WHERE cs.courseTask=ct AND cs.courseTask.ctid="
						+ courseTask.getCtid();
				@SuppressWarnings("unchecked")
				List<CourseSchedule> listTemp = dao.getByHql(hql);
				if (listTemp != null)
					for (int j = 0; j < listTemp.size(); j++) {
						CourseSchedule courseSchedule = (CourseSchedule) (listTemp
								.get(j));
						if (courseSchedule != null && schoolCourse != null)
							courseInfo.add(new CourseInfo(courseSchedule,
									schoolCourse, schoolTeacher, user,
									courseTask.getChoosenumber(), courseTask
											.getCourseNature(), courseTask
											.getCourseCategory(), courseTask
											.getExamMethod(), courseTask
											.getCourseBelonging(),courseTask.getCredit(),courseTask.getTeachernameview()));
					}
			}
			request.setAttribute("courseInfo", courseInfo);
			CurriculumInfoJSON.createJSON(courseInfo);
			/**
			 * 输出CurriculumInfo-json到客户端
			 */
			writer.write(CurriculumInfoJSON.createJSON(courseInfo));
			writer.flush();
			return;
		}
	}
}
