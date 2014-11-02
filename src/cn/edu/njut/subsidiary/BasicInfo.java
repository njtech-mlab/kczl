package cn.edu.njut.subsidiary;

import cn.edu.njut.entity.SchoolCalendar;

public class BasicInfo {
	private String realname;
	private String email;
	private String schoolnumber;
	private String sessioncode;
	private String tel;
	private String sex;
	private String birthday;
	private String natureclassname;
	private String fieldname;
	private String collegename;
	private String universityname;
	private String campusname;
	private Integer grade;
	private SchoolCalendar schoolCalendar;
	private String begindate;
	

	public BasicInfo(String realname, String email, String schoolnumber,
			String sessioncode, String tel, String sex, String birthday,
			String natureclassname, String fieldname, String collegename,
			String universityname, String campusname,Integer grade,SchoolCalendar schoolCalendar,String begindate) {
		this.realname = realname;
		this.email = email;
		this.schoolnumber = schoolnumber;
		this.sessioncode = sessioncode;
		this.tel = tel;
		this.sex = sex;
		this.birthday=birthday;
		this.natureclassname=natureclassname;
		this.fieldname=fieldname;
		this.collegename=collegename;
		this.universityname=universityname;
		this.campusname=campusname;
		this.grade=grade;
		this.schoolCalendar=schoolCalendar;
		this.begindate=begindate;
	}

	public String getBegindate() {
		return begindate;
	}



	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}



	public SchoolCalendar getSchoolCalendar() {
		return schoolCalendar;
	}



	public void setSchoolCalendar(SchoolCalendar schoolCalendar) {
		this.schoolCalendar = schoolCalendar;
	}



	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNatureclassname() {
		return natureclassname;
	}

	public void setNatureclassname(String natureclassname) {
		this.natureclassname = natureclassname;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getUniversityname() {
		return universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}

	public String getCampusname() {
		return campusname;
	}

	public void setCampusname(String campusname) {
		this.campusname = campusname;
	}

	public BasicInfo() {
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolnumber() {
		return schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getSessioncode() {
		return sessioncode;
	}

	public void setSessioncode(String sessioncode) {
		this.sessioncode = sessioncode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
