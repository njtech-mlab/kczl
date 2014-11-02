package cn.edu.njut.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private SchoolStudent schoolStudent;
	private String email;
	private String userpwd;
	private String sessioncode;
	private String androidDeviceToken;
	private String iosDeviceToken;
	private String lastloginSystemVersion;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer uid, String email) {
		this.uid = uid;
		this.email = email;
	}

	/** full constructor */
	public User(Integer uid, SchoolStudent schoolStudent, String email,
			String userpwd, String sessioncode, String androidDeviceToken,
			String iosDeviceToken, String lastloginSystemVersion) {
		this.uid = uid;
		this.schoolStudent = schoolStudent;
		this.email = email;
		this.userpwd = userpwd;
		this.sessioncode = sessioncode;
		this.androidDeviceToken = androidDeviceToken;
		this.iosDeviceToken = iosDeviceToken;
		this.lastloginSystemVersion = lastloginSystemVersion;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public SchoolStudent getSchoolStudent() {
		return this.schoolStudent;
	}

	public void setSchoolStudent(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getSessioncode() {
		return this.sessioncode;
	}

	public void setSessioncode(String sessioncode) {
		this.sessioncode = sessioncode;
	}

	public String getAndroidDeviceToken() {
		return this.androidDeviceToken;
	}

	public void setAndroidDeviceToken(String androidDeviceToken) {
		this.androidDeviceToken = androidDeviceToken;
	}

	public String getIosDeviceToken() {
		return this.iosDeviceToken;
	}

	public void setIosDeviceToken(String iosDeviceToken) {
		this.iosDeviceToken = iosDeviceToken;
	}

	public String getLastloginSystemVersion() {
		return this.lastloginSystemVersion;
	}

	public void setLastloginSystemVersion(String lastloginSystemVersion) {
		this.lastloginSystemVersion = lastloginSystemVersion;
	}

}