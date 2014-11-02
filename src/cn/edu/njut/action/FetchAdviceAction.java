package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckTeacher;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.Spit;
import cn.edu.njut.subsidiary.InfoStream;

import com.opensymphony.xwork2.ActionContext;

public class FetchAdviceAction {
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

	public void execute() throws IOException
	{

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		Dao dao=new Dao();
		
		if (CheckTeacher.checkTeacher() == false) 
		{
			writer.write("{\"msg\":\"failed to check teacher\"}");
			writer.flush();
			return;
		}
		
		if(ctid==null || ctid.equals(""))
		{
			writer.write("{\"msg\":\"param ctid cannot be empty\"}");
			writer.flush();
			return;
		}
		
		if(lastupdate == null) {
			@SuppressWarnings("unchecked")
			List<CourseAdvice> temp = (List<CourseAdvice>)dao.getByHql("FROM CourseAdvice ca WHERE ca.ctid=" + ctid + " AND ca.content!=null AND ca.content!='' AND ca.content!=' ' ORDER BY ca.caid DESC");
			List<CourseAdvice> list = new ArrayList<CourseAdvice>();
			int lastupdate = 0;
			for(int i = 0; i<temp.size() && i<5; i++) {
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
			for(int i = 0; i<temp.size() && count<5; i++) {
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
