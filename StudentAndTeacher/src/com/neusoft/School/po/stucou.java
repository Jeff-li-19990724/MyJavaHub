package com.neusoft.School.po;

public class stucou {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public int getCourseID() {
		return courseID;
	}
	public stucou() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stucou(int id, int studentID, int courseID) {
		super();
		this.id = id;
		this.StudentID = studentID;
		this.courseID = courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	private int id;
	private int StudentID;
	private int courseID;
}
