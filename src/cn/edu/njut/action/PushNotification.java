package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.entity.User;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.opensymphony.xwork2.ActionContext;

public class PushNotification {
	private String username;
	private String password;
	private String content;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	static ApnsService service = null;
	static String payload = null;
	static {
		String basepath = PushNotification.class.getClassLoader()
				.getResource("/").getPath();
		service = APNS.newService()
				.withCert(basepath + "apns-production-cert.p12", "njutmlab123")
				.withProductionDestination().build();
	}
	public static void pushNoti(String token) {
		System.out.println(payload);
		service.push(token, payload);
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

		/*------------------------------------------------------------*/

		String method = ServletActionContext.getRequest().getMethod();
		if (method.equals("GET")) {
			writer.write("(╯‵□′)╯︵┻━┻");
			writer.flush();
			return;
		}

		if (!username.equals("woshiyuanshi")
				|| !password.equals("woyaotuisong!")) {
			writer.write("(╯‵□′)╯︵┻━┻");
			writer.flush();
			return;
		}

		payload = APNS.newPayload().alertBody(content).clearBadge().build();

		Dao dao = new Dao();
		/*
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) dao.getByHql("FROM User u where u.iosDeviceToken != ''");
		for (int i = 0; i < list.size(); i++) {
			User u = (User) list.get(i);
			PushNotification.pushNoti(u.getIosDeviceToken());
		}
		*/
		User user = (User) dao.getOne("FROM User u WHERE u.email='P2104120310'");
		PushNotification.pushNoti(user.getIosDeviceToken());
		writer.write("bingo!");
		writer.flush();
		return;
	}

	public static void main(String[] args) {
		service = APNS.newService()
				.withCert("src/apns-production-cert.p12", "njutmlab123")
				.withProductionDestination().build();
		Dao dao = new Dao();
		payload = APNS.newPayload().alertBody("qqqqqqqqqqqqqqqqqqqqqqqqqq!xsxsx").clearBadge().build();
		/*
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) dao
				.getByHql("FROM User u where u.iosDeviceToken != ''");
		for (int i = 0; i < list.size(); i++) {
			User u = (User) list.get(i); //
			PushNotification.pushNoti(u.getIosDeviceToken());
			count++;
			System.out.println(count);
		}
		*/
		User user = (User) dao.getOne("FROM User u WHERE u.email='1405110109'");
		System.out.println(user.getIosDeviceToken());
		PushNotification.pushNoti(user.getIosDeviceToken());
		System.out.println("xxx");
	}

}
