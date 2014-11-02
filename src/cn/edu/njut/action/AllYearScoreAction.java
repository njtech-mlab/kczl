package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.Score;

import com.opensymphony.xwork2.ActionContext;

public class AllYearScoreAction {
	private String schoolnumber;
	private String year;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}



	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public void execute() throws IOException {
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
		
		if(schoolnumber==null || schoolnumber.equals("") || year==null || year.equals(""))
		{
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		Dao dao=new Dao();
		String hql=null;
		
		hql="FROM Score s WHERE s.schoolnumber='"+schoolnumber+"'"+"AND s.year='"+year+"'";
		@SuppressWarnings("unchecked")
		List<Score> scores=(List<Score>)dao.getByHql(hql);
		JSONArray jsonArray=JSONArray.fromObject(scores);
		writer.write(jsonArray.toString());
		writer.flush();
		return;
	}
}
