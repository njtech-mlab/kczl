package cn.edu.njut.entity;

/**
 * TeacherInfo entity. @author MyEclipse Persistence Tools
 */

public class TeacherInfo implements java.io.Serializable {

	// Fields

	private Integer tiid;
	private String teachername;
	private String teachernumber;
	private Integer coid;
	private String email;
	private String tel;
	private String birthday;
	private String sex;
	private String job;
	private String professionalTitle;
	private String education;
	private String introduction;
	private String major;
	private String graduatedUniversity;
	private String studyDirection;
	private String hometown;

	// Constructors

	/** default constructor */
	public TeacherInfo() {
	}

	/** full constructor */
	public TeacherInfo(String teachername, String teachernumber, Integer coid,
			String email, String tel, String birthday, String sex, String job,
			String professionalTitle, String education, String introduction,
			String major, String graduatedUniversity, String studyDirection,
			String hometown) {
		this.teachername = teachername;
		this.teachernumber = teachernumber;
		this.coid = coid;
		this.email = email;
		this.tel = tel;
		this.birthday = birthday;
		this.sex = sex;
		this.job = job;
		this.professionalTitle = professionalTitle;
		this.education = education;
		this.introduction = introduction;
		this.major = major;
		this.graduatedUniversity = graduatedUniversity;
		this.studyDirection = studyDirection;
		this.hometown = hometown;
	}

	// Property accessors

	public Integer getTiid() {
		return this.tiid;
	}

	public void setTiid(Integer tiid) {
		this.tiid = tiid;
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

	public Integer getCoid() {
		return this.coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
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

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGraduatedUniversity() {
		return this.graduatedUniversity;
	}

	public void setGraduatedUniversity(String graduatedUniversity) {
		this.graduatedUniversity = graduatedUniversity;
	}

	public String getStudyDirection() {
		return this.studyDirection;
	}

	public void setStudyDirection(String studyDirection) {
		this.studyDirection = studyDirection;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}