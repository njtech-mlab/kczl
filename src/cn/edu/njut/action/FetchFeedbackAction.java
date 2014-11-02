package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.Feedback;

import com.opensymphony.xwork2.ActionContext;

public class FetchFeedbackAction {
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
		
		if(userEmail.equals("1405110109") || userEmail.equals("1501100114") || userEmail.equals("zhanghao") || userEmail.equals("slanren")) {
			List<Feedback> fb = (List<Feedback>)dao.getByHql("FROM Feedback");
			JSONArray array = JSONArray.fromObject(fb);
			//String str = array.toString();
			for(int i=0; i<array.size(); i++)
			{
				writer.write(array.get(i).toString());
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write("<br/><br/>");
				writer.flush();
				response.setContentType("application/json;charset=UTF-8");
			}
			writer.flush();
		}
	}
}
