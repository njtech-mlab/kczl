package cn.edu.njut.entity;

/**
 * CourseSchedule entity. @author MyEclipse Persistence Tools
 */

public class CourseSchedule implements java.io.Serializable {

	// Fields

	private Integer csid;
	private CourseTask courseTask;
	private String courseschedulecode;
	private String beginweek;
	private String endweek;
	private String oddoreven;
	private Integer beginsection;
	private Integer day;
	private Integer endsection;
	private String place;

	// Constructors

	/** default constructor */
	public CourseSchedule() {
	}

	/** full constructor */
	public CourseSchedule(CourseTask courseTask, String courseschedulecode,
			String beginweek, String endweek, String oddoreven,
			Integer beginsection, Integer day, Integer endsection, String place) {
		this.courseTask = courseTask;
		this.courseschedulecode = courseschedulecode;
		this.beginweek = beginweek;
		this.endweek = endweek;
		this.oddoreven = oddoreven;
		this.beginsection = beginsection;
		this.day = day;
		this.endsection = endsection;
		this.place = place;
	}

	// Property accessors

	public Integer getCsid() {
		return this.csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public CourseTask getCourseTask() {
		return this.courseTask;
	}

	public void setCourseTask(CourseTask courseTask) {
		this.courseTask = courseTask;
	}

	public String getCourseschedulecode() {
		return this.courseschedulecode;
	}

	public void setCourseschedulecode(String courseschedulecode) {
		this.courseschedulecode = courseschedulecode;
	}

	public String getBeginweek() {
		return this.beginweek;
	}

	public void setBeginweek(String beginweek) {
		this.beginweek = beginweek;
	}

	public String getEndweek() {
		return this.endweek;
	}

	public void setEndweek(String endweek) {
		this.endweek = endweek;
	}

	public String getOddoreven() {
		return this.oddoreven;
	}

	public void setOddoreven(String oddoreven) {
		this.oddoreven = oddoreven;
	}

	public Integer getBeginsection() {
		return this.beginsection;
	}

	public void setBeginsection(Integer beginsection) {
		this.beginsection = beginsection;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getEndsection() {
		return this.endsection;
	}

	public void setEndsection(Integer endsection) {
		this.endsection = endsection;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}