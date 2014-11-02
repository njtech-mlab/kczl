package cn.edu.njut.subsidiary;

public class Schedule {
	private String beginweek;
	private String endweek;
	private String beginsection;
	private String endsection;
	private String day;
	private String place;
	private String oddoreven;
	
	public Schedule(String beginweek, String endweek, String beginsection, String endsection, String day, String place, String oddoreven) {
		this.beginweek = beginweek;
		this.endweek = endweek;
		this.beginsection = beginsection;
		this.endsection = endsection;
		this.day = day;
		this.place = place;
		this.oddoreven = oddoreven;
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

	public String getBeginsection() {
		return beginsection;
	}

	public void setBeginsection(String beginsection) {
		this.beginsection = beginsection;
	}

	public String getEndsection() {
		return endsection;
	}

	public void setEndsection(String endsection) {
		this.endsection = endsection;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOddoreven() {
		return oddoreven;
	}

	public void setOddoreven(String oddoreven) {
		this.oddoreven = oddoreven;
	}
	
}
