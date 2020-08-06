package com.neusoft.School.po;

public class CourseByID {
	public CourseByID(int courseID, String courseName, Integer courseHour) {
		super();
		this.courseID = courseID;
		CourseName = courseName;
		CourseHour = courseHour;
	}
	@Override
	public String toString() {
		return "CourseByID [courseID=" + courseID + ", CourseName=" + CourseName + ", CourseHour=" + CourseHour + "]";
	}
	public int courseID;
	public String CourseName;
	public Integer CourseHour;
}
