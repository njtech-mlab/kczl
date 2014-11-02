package cn.edu.njut.subsidiary;

public class Infocard {
	private Integer learningEffect;
	private Integer arrangement;
	private Integer attendance;
	private Integer speed;
	private Integer num;
	private Integer total;
	private Integer onestar;
	private Integer twostar;
	private Integer threestar;
	private Integer fourstar;
	private Integer fivestar;
	private String datestamp;
	public String getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}
	public Integer getLearningEffect() {
		return learningEffect;
	}
	public void setLearningEffect(Integer learningEffect) {
		this.learningEffect = learningEffect;
	}
	public Integer getArrangement() {
		return arrangement;
	}
	public void setArrangement(Integer arrangement) {
		this.arrangement = arrangement;
	}
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getOnestar() {
		return onestar;
	}
	public void setOnestar(Integer onestar) {
		this.onestar = onestar;
	}
	public Integer getTwostar() {
		return twostar;
	}
	public void setTwostar(Integer twostar) {
		this.twostar = twostar;
	}
	public Integer getThreestar() {
		return threestar;
	}
	public void setThreestar(Integer threestar) {
		this.threestar = threestar;
	}
	public Integer getFourstar() {
		return fourstar;
	}
	public void setFourstar(Integer fourstar) {
		this.fourstar = fourstar;
	}
	public Integer getFivestar() {
		return fivestar;
	}
	public void setFivestar(Integer fivestar) {
		this.fivestar = fivestar;
	}
	public Infocard(int learningEffect, int arrangement, int attendance, int speed, int num, int total, int one, int two, int three, int four, int five, String datestamp) {
		this.learningEffect = learningEffect;
		this.arrangement = arrangement;
		this.attendance = attendance;
		this.speed = speed;
		this.num = num;
		this.total = total;
		this.onestar = one;
		this.twostar = two;
		this.threestar = three;
		this.fourstar = four;
		this.fivestar = five;
		this.datestamp = datestamp;
	}
}
