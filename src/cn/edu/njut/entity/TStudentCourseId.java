package cn.edu.njut.entity;

/**
 * TStudentCourseId entity. @author MyEclipse Persistence Tools
 */

public class TStudentCourseId implements java.io.Serializable {

	// Fields

	private SchoolStudent schoolStudent;
	private CourseTask courseTask;
	private String schoolnumber;
	private String choosenumber;
	private String retakeTag;

	// Constructors

	/** default constructor */
	public TStudentCourseId() {
	}

	/** minimal constructor */
	public TStudentCourseId(String schoolnumber, String choosenumber) {
		this.schoolnumber = schoolnumber;
		this.choosenumber = choosenumber;
	}

	/** full constructor */
	public TStudentCourseId(SchoolStudent schoolStudent, CourseTask courseTask,
			String schoolnumber, String choosenumber, String retakeTag) {
		this.schoolStudent = schoolStudent;
		this.courseTask = courseTask;
		this.schoolnumber = schoolnumber;
		this.choosenumber = choosenumber;
		this.retakeTag = retakeTag;
	}

	// Property accessors

	public SchoolStudent getSchoolStudent() {
		return this.schoolStudent;
	}

	public void setSchoolStudent(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

	public CourseTask getCourseTask() {
		return this.courseTask;
	}

	public void setCourseTask(CourseTask courseTask) {
		this.courseTask = courseTask;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getChoosenumber() {
		return this.choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
	}

	public String getRetakeTag() {
		return this.retakeTag;
	}

	public void setRetakeTag(String retakeTag) {
		this.retakeTag = retakeTag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TStudentCourseId))
			return false;
		TStudentCourseId castOther = (TStudentCourseId) other;

		return ((this.getSchoolStudent() == castOther.getSchoolStudent()) || (this
				.getSchoolStudent() != null
				&& castOther.getSchoolStudent() != null && this
				.getSchoolStudent().equals(castOther.getSchoolStudent())))
				&& ((this.getCourseTask() == castOther.getCourseTask()) || (this
						.getCourseTask() != null
						&& castOther.getCourseTask() != null && this
						.getCourseTask().equals(castOther.getCourseTask())))
				&& ((this.getSchoolnumber() == castOther.getSchoolnumber()) || (this
						.getSchoolnumber() != null
						&& castOther.getSchoolnumber() != null && this
						.getSchoolnumber().equals(castOther.getSchoolnumber())))
				&& ((this.getChoosenumber() == castOther.getChoosenumber()) || (this
						.getChoosenumber() != null
						&& castOther.getChoosenumber() != null && this
						.getChoosenumber().equals(castOther.getChoosenumber())))
				&& ((this.getRetakeTag() == castOther.getRetakeTag()) || (this
						.getRetakeTag() != null
						&& castOther.getRetakeTag() != null && this
						.getRetakeTag().equals(castOther.getRetakeTag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSchoolStudent() == null ? 0 : this.getSchoolStudent()
						.hashCode());
		result = 37
				* result
				+ (getCourseTask() == null ? 0 : this.getCourseTask()
						.hashCode());
		result = 37
				* result
				+ (getSchoolnumber() == null ? 0 : this.getSchoolnumber()
						.hashCode());
		result = 37
				* result
				+ (getChoosenumber() == null ? 0 : this.getChoosenumber()
						.hashCode());
		result = 37 * result
				+ (getRetakeTag() == null ? 0 : this.getRetakeTag().hashCode());
		return result;
	}

}