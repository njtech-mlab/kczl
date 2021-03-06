package cn.edu.njut.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.Spit;
import cn.edu.njut.entity.User;
import cn.edu.njut.subsidiary.InfoStream;

import com.opensymphony.xwork2.ActionContext;

public class AdviceStreamAction {
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
			List<CourseAdvice> temp = (List<CourseAdvice>)dao.getByHql("FROM CourseAdvice ca WHERE ca.ctid in " + ctidSet + " AND ca.content!=null AND ca.content!='' AND ca.content!=' ' ORDER BY ca.caid DESC");
			List<CourseAdvice> list = new ArrayList<CourseAdvice>();

			if(lastupdate == null) {
				int lastupdate = 0;
				for(int i = 0; i<temp.size() && i<20; i++) {
					list.add(temp.get(i));
					lastupdate = temp.get(i).getCaid();
				}
				InfoStream infostream = new InfoStream(list);
				String json = infostream.getInfoStreamJson("CourseAdvice");
				writer.write("json:" + json + " \n lastupdate:" + lastupdate);
				writer.flush();
				return;
			}
			
			if(lastupdate != null) {
				int lastup = lastupdate;
				int count = 0;
				for(int i = 0; i<temp.size() && count<20; i++) {
					if(temp.get(i).getCaid()<lastupdate) {
						list.add(temp.get(i));
						count++;
						lastup = temp.get(i).getCaid();
					}
				}
				InfoStream infostream = new InfoStream(list);
				String json = infostream.getInfoStreamJson("CourseAdvice");
				writer.write("json:" + json + " \n lastupdate:" + lastup);
				writer.flush();
				return;
			}
			return;
		}
		
		if(lastupdate == null) {
			@SuppressWarnings("unchecked")
			List<CourseAdvice> temp = (List<CourseAdvice>)dao.getByHql("FROM CourseAdvice ca WHERE ca.ctid=" + ctid + " AND ca.content!=null AND ca.content!='' AND ca.content!=' ' ORDER BY ca.caid DESC");
			List<CourseAdvice> list = new ArrayList<CourseAdvice>();
			int lastupdate = 0;
			for(int i = 0; i<temp.size() && i<20; i++) {
				list.add(temp.get(i));
				lastupdate = temp.get(i).getCaid();
			}
			InfoStream infostream = new InfoStream(list);
			String json = infostream.getInfoStreamJson("CourseAdvice");
			writer.write("json:" + json + " \n lastupdate:" + lastupdate);
			writer.flush();
			return;
		}
		
		if(lastupdate != null) {
			@SuppressWarnings("unchecked")
			List<CourseAdvice> temp = (List<CourseAdvice>)dao.getByHql("FROM CourseAdvice ca WHERE ca.ctid=" + ctid + " AND ca.content!=null AND ca.content!='' AND ca.content!=' ' ORDER BY ca.caid DESC");
			List<CourseAdvice> list = new ArrayList<CourseAdvice>();
			int lastup = lastupdate;
			int count = 0;
			for(int i = 0; i<temp.size() && count<20; i++) {
				if(temp.get(i).getCaid()<lastupdate) {
					list.add(temp.get(i));
					count++;
					lastup = temp.get(i).getCaid();
				}
			}
			InfoStream infostream = new InfoStream(list);
			String json = infostream.getInfoStreamJson("CourseAdvice");
			writer.write("json:" + json + " \n lastupdate:" + lastup);
			writer.flush();
			return;
		}
	}
}
