package cn.edu.njut.common.service;

import java.text.DateFormat;
import java.util.Date;

import net.sf.json.JSONObject;
import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.College;
import cn.edu.njut.entity.District;
import cn.edu.njut.entity.Field;
import cn.edu.njut.entity.NatureClass;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.SchoolCalendar;
import cn.edu.njut.entity.SchoolStudent;
import cn.edu.njut.entity.University;
import cn.edu.njut.entity.User;
import cn.edu.njut.subsidiary.BasicInfo;

public class BasicInfoJSON {
	public static String createJSON(User user) {
		Dao dao = new Dao();
		String hql = "FROM SchoolStudent ss WHERE ss.ssid="
				+ user.getSchoolStudent().getSsid();
		SchoolStudent schoolStudent = (SchoolStudent) dao.getOne(hql);
		
		hql = "FROM Field f WHERE f.fiid=" + schoolStudent.getField().getFiid();
		Field field = (Field) dao.getOne(hql);

		hql = "FROM College c WHERE c.coid=" + field.getCollege().getCoid();
		College college = (College) dao.getOne(hql);

		hql = "FROM NatureClass nc WHERE nc.ncid="
				+ schoolStudent.getNatureClass().getNcid();
		NatureClass natureClass = (NatureClass) dao.getOne(hql);

		hql = "FROM District d WHERE d.campusCode="
				+ natureClass.getCampusCode();
		District district = (District) dao.getOne(hql);

		hql = "FROM University u WHERE u.unid="
				+ district.getUniversity().getUnid();
		University university = (University) dao.getOne(hql);

		String date=DateFormat.getDateInstance().format(new Date());
		hql="FROM SchoolCalendar sc WHERE sc.date='"+date+"'";
		SchoolCalendar schoolCalendar=(SchoolCalendar)dao.getOne(hql);
		
		Parameter parameter=(Parameter)dao.getOne("FROM Parameter p WHERE p.paramid=1");

		BasicInfo basicInfo = new BasicInfo(schoolStudent.getRealname(),
				user.getEmail(), schoolStudent.getSchoolnumber(),
				user.getSessioncode(), schoolStudent.getTel(),
				schoolStudent.getSex(), schoolStudent.getBirthday(),
				natureClass.getNatureclassname(), field.getFieldname(),
				college.getCollegename(), university.getUniversityname(),
				district.getCampusName(),schoolStudent.getGrade(),schoolCalendar,parameter.getBeginDate());
		JSONObject jsonObject = JSONObject.fromObject(basicInfo);
		return jsonObject.toString();
	}
}
