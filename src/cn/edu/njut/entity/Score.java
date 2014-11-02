package cn.edu.njut.entity;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Integer scoreid;
	private String year;
	private Integer term;
	private String coursename;
	private String choosenumber;
	private String schoolnumber;
	private String courseNature;
	private String courseCategory;
	private String courseBelonging;
	private Integer weight;
	private String credit;
	private String score;
	private Float conversionScore;
	private Float point;
	private String note;
	private Integer retakeTag;
	private String usualScore;
	private String finalScore;
	private String experimentScore;
	private String makeupScore;
	private String retakeScore;
	private String minorTag;
	private String extraScore;
	private String extraScoreReason;
	private String cancelled;
	private String examMethod;
	private String originMakeupScore;
	private Integer makeupAdd;
	private String originScore;
	private String explaination;
	private String examSuspensionTag;
	private String contrastScore;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(String year, Integer term, String coursename,
			String choosenumber, String schoolnumber, String courseNature,
			String courseCategory, String courseBelonging, Integer weight,
			String credit, String score, Float conversionScore, Float point,
			String note, Integer retakeTag, String usualScore,
			String finalScore, String experimentScore, String makeupScore,
			String retakeScore, String minorTag, String extraScore,
			String extraScoreReason, String cancelled, String examMethod,
			String originMakeupScore, Integer makeupAdd, String originScore,
			String explaination, String examSuspensionTag, String contrastScore) {
		this.year = year;
		this.term = term;
		this.coursename = coursename;
		this.choosenumber = choosenumber;
		this.schoolnumber = schoolnumber;
		this.courseNature = courseNature;
		this.courseCategory = courseCategory;
		this.courseBelonging = courseBelonging;
		this.weight = weight;
		this.credit = credit;
		this.score = score;
		this.conversionScore = conversionScore;
		this.point = point;
		this.note = note;
		this.retakeTag = retakeTag;
		this.usualScore = usualScore;
		this.finalScore = finalScore;
		this.experimentScore = experimentScore;
		this.makeupScore = makeupScore;
		this.retakeScore = retakeScore;
		this.minorTag = minorTag;
		this.extraScore = extraScore;
		this.extraScoreReason = extraScoreReason;
		this.cancelled = cancelled;
		this.examMethod = examMethod;
		this.originMakeupScore = originMakeupScore;
		this.makeupAdd = makeupAdd;
		this.originScore = originScore;
		this.explaination = explaination;
		this.examSuspensionTag = examSuspensionTag;
		this.contrastScore = contrastScore;
	}

	// Property accessors

	public Integer getScoreid() {
		return this.scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getChoosenumber() {
		return this.choosenumber;
	}

	public void setChoosenumber(String choosenumber) {
		this.choosenumber = choosenumber;
	}

	public String getSchoolnumber() {
		return this.schoolnumber;
	}

	public void setSchoolnumber(String schoolnumber) {
		this.schoolnumber = schoolnumber;
	}

	public String getCourseNature() {
		return this.courseNature;
	}

	public void setCourseNature(String courseNature) {
		this.courseNature = courseNature;
	}

	public String getCourseCategory() {
		return this.courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	public String getCourseBelonging() {
		return this.courseBelonging;
	}

	public void setCourseBelonging(String courseBelonging) {
		this.courseBelonging = courseBelonging;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Float getConversionScore() {
		return this.conversionScore;
	}

	public void setConversionScore(Float conversionScore) {
		this.conversionScore = conversionScore;
	}

	public Float getPoint() {
		return this.point;
	}

	public void setPoint(Float point) {
		this.point = point;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getRetakeTag() {
		return this.retakeTag;
	}

	public void setRetakeTag(Integer retakeTag) {
		this.retakeTag = retakeTag;
	}

	public String getUsualScore() {
		return this.usualScore;
	}

	public void setUsualScore(String usualScore) {
		this.usualScore = usualScore;
	}

	public String getFinalScore() {
		return this.finalScore;
	}

	public void setFinalScore(String finalScore) {
		this.finalScore = finalScore;
	}

	public String getExperimentScore() {
		return this.experimentScore;
	}

	public void setExperimentScore(String experimentScore) {
		this.experimentScore = experimentScore;
	}

	public String getMakeupScore() {
		return this.makeupScore;
	}

	public void setMakeupScore(String makeupScore) {
		this.makeupScore = makeupScore;
	}

	public String getRetakeScore() {
		return this.retakeScore;
	}

	public void setRetakeScore(String retakeScore) {
		this.retakeScore = retakeScore;
	}

	public String getMinorTag() {
		return this.minorTag;
	}

	public void setMinorTag(String minorTag) {
		this.minorTag = minorTag;
	}

	public String getExtraScore() {
		return this.extraScore;
	}

	public void setExtraScore(String extraScore) {
		this.extraScore = extraScore;
	}

	public String getExtraScoreReason() {
		return this.extraScoreReason;
	}

	public void setExtraScoreReason(String extraScoreReason) {
		this.extraScoreReason = extraScoreReason;
	}

	public String getCancelled() {
		return this.cancelled;
	}

	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}

	public String getExamMethod() {
		return this.examMethod;
	}

	public void setExamMethod(String examMethod) {
		this.examMethod = examMethod;
	}

	public String getOriginMakeupScore() {
		return this.originMakeupScore;
	}

	public void setOriginMakeupScore(String originMakeupScore) {
		this.originMakeupScore = originMakeupScore;
	}

	public Integer getMakeupAdd() {
		return this.makeupAdd;
	}

	public void setMakeupAdd(Integer makeupAdd) {
		this.makeupAdd = makeupAdd;
	}

	public String getOriginScore() {
		return this.originScore;
	}

	public void setOriginScore(String originScore) {
		this.originScore = originScore;
	}

	public String getExplaination() {
		return this.explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getExamSuspensionTag() {
		return this.examSuspensionTag;
	}

	public void setExamSuspensionTag(String examSuspensionTag) {
		this.examSuspensionTag = examSuspensionTag;
	}

	public String getContrastScore() {
		return this.contrastScore;
	}

	public void setContrastScore(String contrastScore) {
		this.contrastScore = contrastScore;
	}

}