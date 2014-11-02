package cn.edu.njut.subsidiary;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import cn.edu.njut.entity.CourseAdvice;
import cn.edu.njut.entity.EvlDaily;
import cn.edu.njut.entity.Spit;

public class InfoStream {
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public InfoStream(List list) {
		this.list = list;
	}

	public String getInfoStreamJson(String kind) {
		List infolist = new ArrayList();
		if (kind.equals("Spit")) {
			for (int i = 0; i < list.size() && i < 20; i++) {
				SpitInfo info = new SpitInfo((Spit) list.get(i));
				infolist.add(info);
			}
			JSONArray jsonarray = JSONArray.fromObject(infolist);
			return jsonarray.toString();
		}
		
		if (kind.equals("CourseAdvice")) {
			for (int i = 0; i < list.size() && i < 20; i++) {
				CourseAdviceInfo info = new CourseAdviceInfo((CourseAdvice) list.get(i));
				infolist.add(info);
			}
			JSONArray jsonarray = JSONArray.fromObject(infolist);
			return jsonarray.toString();
		}
		
		if (kind.equals("EvlDaily")) {
			for (int i = 0; i < list.size() && i < 20; i++) {
				EvlDailyInfo info = new EvlDailyInfo((EvlDaily) list.get(i));
				infolist.add(info);
			}
			JSONArray jsonarray = JSONArray.fromObject(infolist);
			return jsonarray.toString();
		}
		
		return null;
	}
}
