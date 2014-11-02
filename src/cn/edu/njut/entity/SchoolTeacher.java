package cn.edu.njut.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SchoolTeacher entity. @author MyEclipse Persistence Tools
 */

public class SchoolTeacher implements java.io.Serializable {

	// Fields

	private Integer stid;
	private College college;
	private String teachername;
	private String teachernumber;
	private String email;
	private String tel;
	private String birthday;
	private String sex;
	private String job;
	private String professionalTitle;
	private String personnelNumber;
	private String password;
	private String sessioncode;
	private Set courseTasks = new HashSet(0);

	// Constructors

	/** default constructor */
	public SchoolTeacher() {
	}

	/** full constructor */
	public SchoolTeacher(College college, String teachername,
			String teachernumber, String email, String tel, String birthday,
			String sex, String job, String professionalTitle,
			String personnelNumber, String password, String sessioncode,
			Set courseTasks) {
		this.college = college;
		this.teachername = teachername;
		this.teachernumber = teachernumber;
		this.email = email;
		this.tel = tel;
		this.birthday = birthday;
		this.sex = sex;
		this.job = job;
		this.professionalTitle = professionalTitle;
		this.personnelNumber = personnelNumber;
		this.password = password;
		this.sessioncode = sessioncode;
		this.courseTasks = courseTasks;
	}

	// Property accessors

	public Integer getStid() {
		return this.stid;
	}

	public void setStid(Integer stid) {
		this.stid = stid;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeachernumber() {
		return this.teachernumber;
	}

	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
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

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getProfessionalTitle() {
		return this.professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public String getPersonnelNumber() {
		return this.personnelNumber;
	}

	public void setPersonnelNumber(String personnelNumber) {
		this.personnelNumber = personnelNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessioncode() {
		return this.sessioncode;
	}

	public void setSessioncode(String sessioncode) {
		this.sessioncode = sessioncode;
	}

	public Set getCourseTasks() {
		return this.courseTasks;
	}

	public void setCourseTasks(Set courseTasks) {
		this.courseTasks = courseTasks;
	}

}