package com.neusoft.School.po;

public class course {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CourseHour;
		result = prime * result + CourseId;
		result = prime * result + ((CourseName == null) ? 0 : CourseName.hashCode());
		result = prime * result + TeacherID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		course other = (course) obj;
		if (CourseHour != other.CourseHour)
			return false;
		if (CourseId != other.CourseId)
			return false;
		if (CourseName == null) {
			if (other.CourseName != null)
				return false;
		} else if (!CourseName.equals(other.CourseName))
			return false;
		if (TeacherID != other.TeacherID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "course [课程编号=" + CourseId + ", 课程名称=" + CourseName + ", 课时=" + CourseHour
				+ ", 教师编号=" + TeacherID + "]";
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getCourseHour() {
		return CourseHour;
	}
	public void setCourseHour(int courseHour) {
		CourseHour = courseHour;
	}
	public int getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(int teacherID) {
		TeacherID = teacherID;
	}
	public course(int courseId, String courseName, int courseHour, int teacherID) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		CourseHour = courseHour;
		TeacherID = teacherID;
	}
	public course() {
		super();
	}
	private int CourseId;
	private String CourseName;
	private int CourseHour;
	private int TeacherID;
}
