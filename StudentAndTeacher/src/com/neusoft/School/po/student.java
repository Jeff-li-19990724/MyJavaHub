package com.neusoft.School.po;

public class student {
	@Override
	public String toString() {
		return "学生信息 [学号=" + studentId + ", 姓名=" + studentName + ", 专业班级=" + studentClass+ "]";
	}
	public student() {
		super();
	}
	public student(int studentId, String studentName, String studentClass) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	private int studentId;
	private String studentName;
	private String studentClass;
}
