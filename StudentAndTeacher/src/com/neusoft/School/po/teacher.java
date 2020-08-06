package com.neusoft.School.po;

public class teacher {
	@Override
	public String toString() {
		return "teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + ", technology=" + technology + "]";
	}
	public teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public teacher(int teacherID, String teacherName, String technology) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.technology = technology;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	private int teacherID;
	private String teacherName;
	private String technology;
}
