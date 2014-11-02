package cn.edu.njut.common.service;

import java.text.DateFormat;
import java.util.Date;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Summary;

public class SummaryControl {
	public static int getSummaryControlInfo(String schoolnumber, Integer ctid) {
		Date date=new Date();
		DateFormat d=DateFormat.getDateInstance();
		String datestr=d.format(date);
		Dao dao=new Dao();
		String hql="FROM Summary s WHERE s.schoolnumber='"+schoolnumber+"' AND s.ctid="+ctid+" AND s.date='"+datestr+"'";
		Summary summary = (Summary) dao.getOne(hql);
		if(summary != null)
			return 0;	//当日已点评
		return 1;	//可以点评
	}
}
