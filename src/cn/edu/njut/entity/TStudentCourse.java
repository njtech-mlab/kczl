package cn.edu.njut.entity;

/**
 * TStudentCourse entity. @author MyEclipse Persistence Tools
 */

public class TStudentCourse implements java.io.Serializable {

	// Fields

	private TStudentCourseId id;
	private CourseTask courseTask;
	private SchoolStudent schoolStudent;

	// Constructors

	/** default constructor */
	public TStudentCourse() {
	}

	/** minimal constructor */
	public TStudentCourse(TStudentCourseId id) {
		this.id = id;
	}

	/** full constructor */
	public TStudentCourse(TStudentCourseId id, CourseTask courseTask,
			SchoolStudent schoolStudent) {
		this.id = id;
		this.courseTask = courseTask;
		this.schoolStudent = schoolStudent;
	}

	// Property accessors

	public TStudentCourseId getId() {
		return this.id;
	}

	public void setId(TStudentCourseId id) {
		this.id = id;
	}

	public CourseTask getCourseTask() {
		return this.courseTask;
	}

	public void setCourseTask(CourseTask courseTask) {
		this.courseTask = courseTask;
	}

	public SchoolStudent getSchoolStudent() {
		return this.schoolStudent;
	}

	public void setSchoolStudent(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

}