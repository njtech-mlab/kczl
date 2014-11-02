package cn.edu.njut.common.service;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.SchoolCourse;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.entity.TeacherReply;
import cn.edu.njut.subsidiary.CourseInfo;
import cn.edu.njut.subsidiary.CurriculumInfo;
import cn.edu.njut.subsidiary.TeacherReplyInfo;

public class TeacherReplyJSON {
	public static String createJSON(List<TeacherReply> list) {
		Dao dao = new Dao();
		List<TeacherReplyInfo> info = new ArrayList<TeacherReplyInfo>();
		for(int i=0; i<list.size(); i++) {
			SchoolTeacher st = (SchoolTeacher) dao.getOne("FROM SchoolTeacher st WHERE st.stid=" + list.get(i).getStid());
			SchoolCourse sc = (SchoolCourse) dao.getOne("FROM SchoolCourse sc WHERE sc.scid=" + list.get(i).getStid());
			info.add(new TeacherReplyInfo(st.getTeachername(), sc.getCoursename(), list.get(i).getContent(), list.get(i).getDatetime()));
		}
		JSONArray jsonArray = JSONArray.fromObject(info);
		return jsonArray.toString();
	}

}
