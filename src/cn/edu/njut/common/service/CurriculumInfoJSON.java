package cn.edu.njut.common.service;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import cn.edu.njut.subsidiary.CourseInfo;
import cn.edu.njut.subsidiary.CurriculumInfo;

public class CurriculumInfoJSON {
	public static String createJSON(ArrayList<CourseInfo> courseInfo) {
		ArrayList<CurriculumInfo> curriculumInfo = new ArrayList<CurriculumInfo>();
		for (int i = 0; i < courseInfo.size(); i++) {
			curriculumInfo.add(new CurriculumInfo(courseInfo.get(i)
					.getCourseSchedule().getBeginweek(), courseInfo.get(i)
					.getCourseSchedule().getEndweek(), courseInfo.get(i)
					.getCourseSchedule().getDay(), courseInfo.get(i)
					.getCourseSchedule().getBeginsection(), courseInfo.get(i)
					.getCourseSchedule().getEndsection(), courseInfo.get(i)
					.getCourseSchedule().getPlace(), courseInfo.get(i)
					.getSchoolCourse().getCoursename(), courseInfo.get(i)
					.getSchoolTeacher().getTeachername(), courseInfo.get(i)
					.getCourseSchedule().getCourseTask().getCtid(), courseInfo
					.get(i).getStarttime(), courseInfo.get(i).getEndtime(),
					courseInfo.get(i).getCourseNature(), courseInfo.get(i)
							.getCourseCategory(), courseInfo.get(i)
							.getExamMethod(), courseInfo.get(i)
							.getCourseBelonging(),courseInfo.get(i).getCredit(),courseInfo.get(i).getChoosenumber(),courseInfo.get(i).getCourseSchedule().getOddoreven(),courseInfo.get(i).getTeacherrealname()));
		}
		JSONArray jsonArray = JSONArray.fromObject(curriculumInfo);
		return jsonArray.toString();
	}
}
