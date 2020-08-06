package com.neusoft.School.dao.inter;

import java.util.List;

import com.neusoft.School.po.student;
import com.neusoft.School.po.teacher;

public interface teacherDAO {
	public teacher teacherLogin(int id,String Name);
	
	public int AddTeacher(teacher t);
	
	List<teacher> SelectTeacher();

	public teacher teacherById(int teacherId);

	public int updateteacher(teacher teacher);

	public int deleteTeacher(int teacherId);

	public List<student> listTeacher_student(int teacherId);
}
