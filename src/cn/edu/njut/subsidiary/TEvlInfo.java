package cn.edu.njut.subsidiary;

public class TEvlInfo {
	private Integer effect;
	private Integer speed;
	private String advice;
	private String date;
	
	public TEvlInfo(Integer effect, Integer speed, String advice, String date)
	{
		this.effect=effect;
		this.speed=speed;
		this.advice=advice;
		this.date=date;
	}
	
	public TEvlInfo()
	{}
	
	public Integer getEffect() {
		return effect;
	}
	public void setEffect(Integer effect) {
		this.effect = effect;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
