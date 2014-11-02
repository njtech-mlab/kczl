package cn.edu.njut.common.service;

import java.text.DateFormat;
import java.util.Date;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.EvlDaily;

public class EvaluationControl {
	public static int getEvaluationControlInfo(String schoolnumber,Integer ctid,String endtime, String starttime)
	{
		Date date=new Date();
		DateFormat d1=DateFormat.getDateTimeInstance();
		String datetimestr=d1.format(date);
		DateFormat d2=DateFormat.getTimeInstance();
		String timestr=d2.format(date);
		String[] temp=timestr.split(":");
		if(temp[0].length()==1)
			temp[0]="0"+temp[0];
		timestr=temp[0]+":"+temp[1];
		if(timestr.compareTo(starttime)<0)
			return 0; 	
		Dao dao=new Dao();
		String hql="FROM CourseAdvice ca WHERE ca.schoolnumber='"+schoolnumber+"' AND ca.ctid="+ctid+" AND ca.timestamp='"+datetimestr+"'";
		CourseAdvice ca = (CourseAdvice)dao.getOne(hql);
		if(ca != null)
			return 1;	
		return 2;	
	}
}
