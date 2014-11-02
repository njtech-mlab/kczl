package cn.edu.njut.subsidiary;

import cn.edu.njut.common.dao.Dao;
import cn.edu.njut.entity.Parameter;

public class TeacherBasicInfo {
	private String teachername;
	private String teachernumber;
	private String personnelnumber;
	private String begindate;

	public TeacherBasicInfo(String teachername,String teachernumber,String personnelnumber)
	{
		this.teachername=teachername;
		this.teachernumber=teachernumber;
		this.personnelnumber=personnelnumber;
		Dao dao = new Dao();
		Parameter p = (Parameter) dao.getOne("FROM Parameter p WHERE p.paramid=1");
		begindate = p.getBeginDate();
	}
	
	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public TeacherBasicInfo()
	{}
	
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeachernumber() {
		return teachernumber;
	}
	public void setTeachernumber(String teachernumber) {
		this.teachernumber = teachernumber;
	}
	public String getPersonnelnumber() {
		return personnelnumber;
	}
	public void setPersonnelnumber(String personnelnumber) {
		this.personnelnumber = personnelnumber;
	}
}
