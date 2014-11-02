package cn.edu.njut.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.common.service.CheckUser;
import cn.edu.njut.common.service.SummaryControl;
import cn.edu.njut.entity.CourseTask;
import cn.edu.njut.entity.Summary;

import com.opensymphony.xwork2.ActionContext;

public class SummaryAction {
	private String schoolnumber;
	private Integer ctid;
	private String content;
	
	public String getSchoolnumber() {
		return schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void execute() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();

		if (CheckUser.checkUser() == false) {
			writer.write("{\"msg\":\"验证用户失败，请重新登录\"}");
			writer.flush();
			return;
		}

		if (schoolnumber == null || ctid == null || content == null) {
			writer.write("{\"msg\":\"请补充完整参数后重新提交\"}");
			writer.flush();
			return;
		}

		Dao dao = new Dao();
		String hql = "FROM CourseTask ct WHERE ct.ctid=" + ctid;
		CourseTask courseTask = (CourseTask) dao.getOne(hql);
		if (courseTask == null) {
			writer.write("{\"msg\":\"no course task found\"}");
			writer.flush();
			return;
		}
		
		int tag = SummaryControl.getSummaryControlInfo(schoolnumber, ctid);
		if (tag == 0) {
			writer.write("{\"msg\":\"提交失败：本次课程不可重复提交总结\"}");
			writer.flush();
			return;
		}

		if (tag == 1) {
			try {
				Summary summary = new Summary(schoolnumber, ctid, content);
				dao.save(summary);
				writer.write("{\"msg\":\"提交成功！ :)\"}");
				writer.flush();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			writer.write("{\"msg\":\"fail\"}");
			writer.flush();
			return;
		}
	}
}
