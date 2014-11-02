package cn.edu.njut.entity;

/**
 * EvlDaily entity. @author MyEclipse Persistence Tools
 */

public class EvlDaily implements java.io.Serializable {

	// Fields

	private Integer edid;
	private String schoolnumber;
	private Integer effect;
	private Integer discipline;
	private Integer attendance;
	private Integer speed;
	private String advice;
	private Integer ctid;
	private String date;
	private String choosenumber;
	private String beginweek;
	private String endweek;
	private String oddoreven;
	private Integer beginsection;
	private Integer day;
	private Integer endsection;

	// Constructors

	/** default constructor */
	public EvlDaily() {
	}

	/** minimal constructor */
	public EvlDaily(Integer ctid) {
		this.ctid = ctid;
	}

	/** full constructor */
	public EvlDaily(String schoolnumber, Integer effect, Integer discipline,
			Integer attendance, Integer speed, String advice, Integer ctid,
			String date, String choosenumber, String beginweek, String endweek,
			String oddoreven, Integer beginsection, Integer day,
			Integer endsection) {
		this.schoolnumber = schoolnumber;
		this.effect = effect;
		this.discipline = discipline;
		this.attendance = attendance;
		this.speed = speed;
		this.advice = advice;
		this.ctid = ctid;
		this.date = date;
		this.choosenumber = choosenumber;
		this.beginweek = beginweek;
		this.endweek = endweek;
		this.oddoreven = oddoreven;
		this.beginsection = beginsection;
		this.day = day;
		this.endsection = endsection;
	}

	// Property accessors

	public Integer getEdid() {
		return this.edid;
	}

	public void setEdid(Integer edid) {
		this.edid = edid;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public Integer getEffect() {
		return this.effect;
	}

	public void setEffect(Integer effect) {
		this.effect = effect;
	}

	public Integer getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
	}

	public Integer getAttendance() {
		return this.attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	public Integer getSpeed() {
		return this.speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Integer getCtid() {
		return this.ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChoosenumber() {
		return this.choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
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

}