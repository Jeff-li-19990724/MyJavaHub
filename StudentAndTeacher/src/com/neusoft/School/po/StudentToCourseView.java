package com.neusoft.School.po;

public class StudentToCourseView {
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return StudentClass;
	}
	public void setStudentClass(String studentClass) {
		StudentClass = studentClass;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	@Override
	public String toString() {
		return " [学生学号=" + StudentID + ", 学生姓名=" + studentName + ", 所属班级="
				+ StudentClass + ", 课程名称=" + CourseName + "]";
	}
	private int StudentID;
	private String studentName;
	private String StudentClass;
	private String CourseName;
}
