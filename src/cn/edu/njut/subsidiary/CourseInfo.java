package cn.edu.njut.subsidiary;

import java.util.List;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.CourseSchedule;
import cn.edu.njut.entity.CourseTime;
import cn.edu.njut.entity.District;
import cn.edu.njut.entity.NatureClass;
import cn.edu.njut.entity.Parameter;
import cn.edu.njut.entity.SchoolCourse;
import cn.edu.njut.entity.SchoolStudent;
import cn.edu.njut.entity.SchoolTeacher;
import cn.edu.njut.entity.User;

public class CourseInfo {
	private CourseSchedule courseSchedule;
	private SchoolCourse schoolCourse;
	private SchoolTeacher schoolTeacher;
	private String starttime;
	private String endtime;
	private String choosenumber;
	private String courseNature;
	private String courseCategory;
	private String examMethod;
	private String courseBelonging;
	private String credit;
	private String teacherrealname;
	
	public String getTeacherrealname() {
		return teacherrealname;
	}

	public void setTeacherrealname(String teacherrealname) {
		this.teacherrealname = teacherrealname;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCourseNature() {
		return courseNature;
	}

	public void setCourseNature(String courseNature) {
		this.courseNature = courseNature;
	}

	public String getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public String getExamMethod() {
		return examMethod;
	}

	public void setExamMethod(String examMethod) {
		this.examMethod = examMethod;
	}

	public String getCourseBelonging() {
		return courseBelonging;
	}

	public void setCourseBelonging(String courseBelonging) {
		this.courseBelonging = courseBelonging;
	}

	public String getChoosenumber() {
		return choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
	}

	public SchoolTeacher getSchoolTeacher() {
		return schoolTeacher;
	}

	public void setSchoolTeacher(SchoolTeacher schoolTeacher) {
		this.schoolTeacher = schoolTeacher;
	}

	public CourseInfo(CourseSchedule courseSchedule,SchoolCourse schoolCourse,SchoolTeacher schoolTeacher,User user,String choosenumber,String courseNature,String courseCategory,String examMethod,String courseBelonging,String credit, String teachernameview)
	{
		this.courseSchedule=courseSchedule;
		this.schoolCourse=schoolCourse;
		this.schoolTeacher=schoolTeacher;
		this.choosenumber=choosenumber;
		this.courseNature=courseNature;
		this.courseCategory=courseCategory;
		this.examMethod=examMethod;
		this.courseBelonging=courseBelonging;
		this.credit=credit;
		this.teacherrealname = teachernameview;
		Dao dao=new Dao();
		SchoolStudent schoolStudent=(SchoolStudent)dao.getOne("FROM SchoolStudent ss WHERE ss.ssid="+user.getSchoolStudent().getSsid());
		NatureClass natureClass=(NatureClass)dao.getOne("FROM NatureClass nc WHERE nc.ncid="+schoolStudent.getNatureClass().getNcid());
		District district=(District)dao.getOne("FROM District di WHERE di.campusCode="+natureClass.getCampusCode());
		Parameter parameter=(Parameter)dao.getOne("FROM Parameter p WHERE p.unid=1 AND p.campusCode="+district.getCampusCode());
		@SuppressWarnings("unchecked")
		List<CourseTime> courseTime=dao.getByHql("FROM CourseTime ct WHERE ct.unid=1 AND ct.district.campusCode="+district.getCampusCode()+" AND ct.season="+parameter.getCurrentCoursetimeSeason());

		if(courseTime!=null)
			for(int i=0;i<courseTime.size();i++)
			{
				if(courseTime.get(i).getSection()==courseSchedule.getBeginsection()+1-1)	// -��-|| ԭ���д����
					starttime=courseTime.get(i).getBegintime();
				if(courseTime.get(i).getSection()==courseSchedule.getBeginsection()+1)
					endtime=courseTime.get(i).getEndtime();
			}

	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public CourseSchedule getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	public SchoolCourse getSchoolCourse() {
		return schoolCourse;
	}

	public void setSchoolCourse(SchoolCourse schoolCourse) {
		this.schoolCourse = schoolCourse;
	}
	
	
}
