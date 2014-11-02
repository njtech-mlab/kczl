package cn.edu.njut.common.service;

import java.util.Calendar;

public class DateTimeService {
	public static String getWeekday()
	{
		Calendar calendar = Calendar.getInstance();
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		switch(weekday) {
		case Calendar.MONDAY:
			return "MONDAY";
		case Calendar.TUESDAY:
			return "TUESDAY";
		case Calendar.WEDNESDAY:
			return "WEDNESDAY";
		case Calendar.THURSDAY:
			return "THURSDAY";
		case Calendar.FRIDAY:
			return "FRIDAY";
		case Calendar.SATURDAY:
			return "SATURDAY";
		case Calendar.SUNDAY:
			return "SUNDAY";
		default:
			return null;
		}
	}
}
