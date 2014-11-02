package cn.edu.njut.common.service;


import net.sf.json.JSONObject;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.subsidiary.TeacherBasicInfo;

public class TeacherInfoJSON {
	public static String createJSON(SchoolTeacher schoolTeacher) {
		TeacherBasicInfo teacherBasicInfo=new TeacherBasicInfo(schoolTeacher.getTeachername(),schoolTeacher.getTeachernumber(),schoolTeacher.getPersonnelNumber());
		JSONObject jsonObject = JSONObject.fromObject(teacherBasicInfo);
		return jsonObject.toString();
	}
}
