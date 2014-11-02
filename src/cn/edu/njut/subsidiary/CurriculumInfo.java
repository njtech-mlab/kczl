package cn.edu.njut.subsidiary;


public class CurriculumInfo {
	private String beginweek;
	private String endweek;
	private Integer day;
	private Integer beginsection;
	private Integer endsection;
	private String place;
	private String coursename;
	private String teachername;
	private Integer ctid;
	private String starttime;
	private String endtime;
	private String courseNature;
	private String courseCategory;
	private String examMethod;
	private String courseBelonging;
	private String credit;
	private String choosenumber;
	private String oddoreven;
	private String teacherrealname;

	public String getTeacherrealname() {
		return teacherrealname;
	}

	public void setTeacherrealname(String teacherrealname) {
		this.teacherrealname = teacherrealname;
	}

	public String getOddoreven() {
		return oddoreven;
	}

	public void setOddoreven(String oddoreven) {
		this.oddoreven = oddoreven;
	}

	public String getChoosenumber() {
		return choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
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

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public CurriculumInfo() {
	}

	public CurriculumInfo(String beginweek, String endweek, Integer day,
			Integer beginsection, Integer endsection, String place,
			String coursename, String teachername, Integer ctid,
			String starttime, String endtime, String courseNature,
			String courseCategory, String examMethod, String courseBelonging,
			String credit,String choosenumber,String oddoreven, String teacherrealname) {
		this.beginweek = beginweek;
		this.endweek = endweek;
		this.day = day;
		this.beginsection = beginsection;
		this.endsection = endsection;
		this.place = place;
		this.coursename = coursename;
		this.teachername = teachername;
		this.ctid = ctid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.courseNature = courseNature;
		this.courseCategory = courseCategory;
		this.examMethod = examMethod;
		this.courseBelonging = courseBelonging;
		this.credit = credit;
		this.choosenumber=choosenumber;
		this.oddoreven=oddoreven;
		this.teacherrealname = teacherrealname;
	}

	public String getBeginweek() {
		return beginweek;
	}

	public void setBeginweek(String beginweek) {
		this.beginweek = beginweek;
	}

	public String getEndweek() {
		return endweek;
	}

	public void setEndweek(String endweek) {
		this.endweek = endweek;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getBeginsection() {
		return beginsection;
	}

	public void setBeginsection(Integer beginsection) {
		this.beginsection = beginsection;
	}

	public Integer getEndsection() {
		return endsection;
	}

	public void setEndsection(Integer endsection) {
		this.endsection = endsection;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
}
