package cn.edu.njut.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.Notification;

import com.opensymphony.xwork2.ActionContext;

public class NewNotificationAction {
	private String schoolnumber;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}
	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
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
		if(schoolnumber == null) {
			writer.write("{\"msg\":\"uncompleted params\"}");
			writer.flush();
			return;
		}
		
		@SuppressWarnings("unchecked")
		List<Notification> list = (List<Notification>) dao.getByHql("FROM Notification n WHERE n.touser='" + schoolnumber + "'");
		JSONArray jsonarray = JSONArray.fromObject(list);
		String json = jsonarray.toString();
		writer.write(json);
		writer.flush();
		return;
	}
}
