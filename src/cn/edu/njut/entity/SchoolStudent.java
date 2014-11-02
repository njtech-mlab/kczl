package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SchoolStudent entity. @author MyEclipse Persistence Tools
 */

public class SchoolStudent implements java.io.Serializable {

	// Fields

	private Integer ssid;
	private NatureClass natureClass;
	private Field field;
	private String schoolnumber;
	private String realname;
	private Integer grade;
	private String userpwd;
	private String email;
	private String tel;
	private String sex;
	private String birthday;
	private Float qareference;
	private Set users = new HashSet(0);
	private Set TStudentCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SchoolStudent() {
	}

	/** full constructor */
	public SchoolStudent(NatureClass natureClass, Field field,
			String schoolnumber, String realname, Integer grade,
			String userpwd, String email, String tel, String sex,
			String birthday, Float qareference, Set users, Set TStudentCourses) {
		this.natureClass = natureClass;
		this.field = field;
		this.schoolnumber = schoolnumber;
		this.realname = realname;
		this.grade = grade;
		this.userpwd = userpwd;
		this.email = email;
		this.tel = tel;
		this.sex = sex;
		this.birthday = birthday;
		this.qareference = qareference;
		this.users = users;
		this.TStudentCourses = TStudentCourses;
	}

	// Property accessors

	public Integer getSsid() {
		return this.ssid;
	}

	public void setSsid(Integer ssid) {
		this.ssid = ssid;
	}

	public NatureClass getNatureClass() {
		return this.natureClass;
	}

	public void setNatureClass(NatureClass natureClass) {
		this.natureClass = natureClass;
	}

	public Field getField() {
		return this.field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Float getQareference() {
		return this.qareference;
	}

	public void setQareference(Float qareference) {
		this.qareference = qareference;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getTStudentCourses() {
		return this.TStudentCourses;
	}

	public void setTStudentCourses(Set TStudentCourses) {
		this.TStudentCourses = TStudentCourses;
	}

}