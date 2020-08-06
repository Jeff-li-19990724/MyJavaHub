package com.neusoft.School.view.inter;

import com.neusoft.School.po.teacher;

public interface TeacherView {
	public teacher TeacherLogin();
	
	public void AddTeacher();
	
	public void SelectTeacher();
	
	public void updateTeacher();
	
	public void deleteTeacher();
	
	public void listTeacher_student();
}
