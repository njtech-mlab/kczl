package cn.edu.njut.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.TStudentCourse;
import cn.edu.njut.entity.TStudentCourseId;
import cn.edu.njut.entity.User;
import cn.edu.njut.subsidiary.InfoStream;

import com.opensymphony.xwork2.ActionContext;

public class InfoStreamAction {
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
		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"failed to check user\"}");
			writer.flush();
			return;
		}
		
		Dao dao = new Dao();
		if(ctid == null) {
			User user = (User) dao.getOne("FROM User u WHERE u.email='" + CheckUser.getSchoolnumber() + "'");
			Parameter parameter=(Parameter)dao.getOne("FROM Parameter p WHERE p.unid=1 AND p.campusCode=1");
			String hql = "SELECT ct FROM CourseTask ct,TStudentCourse tsc,SchoolStudent ss WHERE ct.choosenumber LIKE '%"+parameter.getSchoolyear()+"-"+parameter.getTerm()+"%' AND ss.ssid="
					+ user.getSchoolStudent().getSsid()
					+ "AND tsc.schoolStudent=ss AND tsc.courseTask=ct";
			@SuppressWarnings("unchecked")
			List<CourseTask> ctlist = (List<CourseTask>) (dao.getByHql(hql));
			String ctidSet = "(";
			int flag = 0;
			for(int i = 0; i<ctlist.size(); i++) {
				if(flag == 1)
					ctidSet += ",";
				ctidSet += "'" + ctlist.get(i).getCtid() + "'";
				flag = 1;
			}
			ctidSet += ")";
			@SuppressWarnings("unchecked")
			List<EvlDaily> temp = (List<EvlDaily>)dao.getByHql("FROM EvlDaily e WHERE e.ctid in " + ctidSet + " ORDER BY e.edid DESC");
			List<EvlDaily> list = new ArrayList<EvlDaily>();

			if(lastupdate == null) {
				int lastupdate = 0;
				for(int i = 0; i<temp.size() && i<20; i++) {
					list.add(temp.get(i));
					lastupdate = temp.get(i).getEdid();
				}
				InfoStream infostream = new InfoStream(list);
				String json = infostream.getInfoStreamJson("EvlDaily");
				writer.write("json:" + json + " \n lastupdate:" + lastupdate);
				writer.flush();
				return;
			}
			
			if(lastupdate != null) {
				int lastup = lastupdate;
				int count = 0;
				for(int i = 0; i<temp.size() && count<20; i++) {
					if(temp.get(i).getEdid()<lastupdate) {
						list.add(temp.get(i));
						count++;
						lastup = temp.get(i).getEdid();
					}
				}
				InfoStream infostream = new InfoStream(list);
				String json = infostream.getInfoStreamJson("EvlDaily");
				writer.write("json:" + json + " \n lastupdate:" + lastup);
				writer.flush();
				return;
			}
			return;
		}
		
		if(lastupdate == null) {
			@SuppressWarnings("unchecked")
			List<EvlDaily> temp = (List<EvlDaily>)dao.getByHql("FROM EvlDaily e WHERE e.ctid=" + ctid + " ORDER BY e.edid DESC");
			List<EvlDaily> list = new ArrayList<EvlDaily>();
			int lastupdate = 0;
			for(int i = 0; i<temp.size() && i<20; i++) {
				list.add(temp.get(i));
				lastupdate = temp.get(i).getEdid();
			}
			InfoStream infostream = new InfoStream(list);
			String json = infostream.getInfoStreamJson("EvlDaily");
			writer.write("json:" + json + " \n lastupdate:" + lastupdate);
			writer.flush();
			return;
		}
		
		if(lastupdate != null) {
			@SuppressWarnings("unchecked")
			List<EvlDaily> temp = (List<EvlDaily>)dao.getByHql("FROM EvlDaily e WHERE e.ctid=" + ctid + " ORDER BY e.edid DESC");
			List<EvlDaily> list = new ArrayList<EvlDaily>();
			int lastup = lastupdate;
			int count = 0;
			for(int i = 0; i<temp.size() && count<20; i++) {
				if(temp.get(i).getEdid()<lastupdate) {
					list.add(temp.get(i));
					count++;
					lastup = temp.get(i).getEdid();
				}
			}
			InfoStream infostream = new InfoStream(list);
			String json = infostream.getInfoStreamJson("EvlDaily");
			writer.write("json:" + json + " \n lastupdate:" + lastup);
			writer.flush();
			return;
		}
	}
}

















