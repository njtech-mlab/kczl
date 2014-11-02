package cn.edu.njut.entity;

/**
 * StudentInfo entity. @author MyEclipse Persistence Tools
 */

public class StudentInfo implements java.io.Serializable {

	// Fields

	private Integer siid;
	private String schoolnumber;
	private String realname;
	private String ncid;
	private String fiid;
	private String natureclass;
	private String field;
	private Integer grade;
	private String userpwd;
	private String email;
	private String tel;
	private String sex;
	private String birthday;
	private String identity;
	private String level;
	private String eduDirection;
	private String majorDirection;
	private String politicalStatus;
	private String hometown;
	private String dormitory;
	private String highschoolNumber;
	private String highschoolName;
	private String englishLevel;

	// Constructors

	/** default constructor */
	public StudentInfo() {
	}

	/** full constructor */
	public StudentInfo(String schoolnumber, String realname, String ncid,
			String fiid, String natureclass, String field, Integer grade,
			String userpwd, String email, String tel, String sex,
			String birthday, String identity, String level,
			String eduDirection, String majorDirection, String politicalStatus,
			String hometown, String dormitory, String highschoolNumber,
			String highschoolName, String englishLevel) {
		this.schoolnumber = schoolnumber;
		this.realname = realname;
		this.ncid = ncid;
		this.fiid = fiid;
		this.natureclass = natureclass;
		this.field = field;
		this.grade = grade;
		this.userpwd = userpwd;
		this.email = email;
		this.tel = tel;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.level = level;
		this.eduDirection = eduDirection;
		this.majorDirection = majorDirection;
		this.politicalStatus = politicalStatus;
		this.hometown = hometown;
		this.dormitory = dormitory;
		this.highschoolNumber = highschoolNumber;
		this.highschoolName = highschoolName;
		this.englishLevel = englishLevel;
	}

	// Property accessors

	public Integer getSiid() {
		return this.siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
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

	public String getNcid() {
		return this.ncid;
	}

	public void setNcid(String ncid) {
		this.ncid = ncid;
	}

	public String getFiid() {
		return this.fiid;
	}

	public void setFiid(String fiid) {
		this.fiid = fiid;
	}

	public String getNatureclass() {
		return this.natureclass;
	}

	public void setNatureclass(String natureclass) {
		this.natureclass = natureclass;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
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

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEduDirection() {
		return this.eduDirection;
	}

	public void setEduDirection(String eduDirection) {
		this.eduDirection = eduDirection;
	}

	public String getMajorDirection() {
		return this.majorDirection;
	}

	public void setMajorDirection(String majorDirection) {
		this.majorDirection = majorDirection;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getDormitory() {
		return this.dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getHighschoolNumber() {
		return this.highschoolNumber;
	}

	public void setHighschoolNumber(String highschoolNumber) {
		this.highschoolNumber = highschoolNumber;
	}

	public String getHighschoolName() {
		return this.highschoolName;
	}

	public void setHighschoolName(String highschoolName) {
		this.highschoolName = highschoolName;
	}

	public String getEnglishLevel() {
		return this.englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

}