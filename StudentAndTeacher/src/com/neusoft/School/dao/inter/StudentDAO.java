package com.neusoft.School.dao.inter;

import com.neusoft.School.po.student;

public interface StudentDAO {
	student StudentLogin(int id, String name);
	int AddStudent(student s);
	 
}
