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
import cn.edu.njut.entity.MessageUnsent;

import com.opensymphony.xwork2.ActionContext;

public class CheckMessageAction {
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
		@SuppressWarnings("unchecked")
		List<MessageUnsent> list = (List<MessageUnsent>)dao.getByHql("FROM MessageUnsent mu WHERE mu.destination='" + userEmail + "'");
		String json = JSONArray.fromObject(list).toString();
		writer.write(json);
		writer.flush();
		
		for(int i=0; i<list.size();i++) {
			MessageUnsent mu = list.get(i);
			dao.delete(mu);
		}
	}
}
