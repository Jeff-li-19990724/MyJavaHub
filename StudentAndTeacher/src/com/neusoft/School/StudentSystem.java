package com.neusoft.School;

import com.neusoft.School.po.student;
import com.neusoft.School.view.impl.CouseViewimpl;
import com.neusoft.School.view.impl.StudentViewimpl;
import com.neusoft.School.view.inter.CouseView;
import com.neusoft.School.view.inter.StudentView;
@SuppressWarnings("unused")
public class StudentSystem {

	public void Work()
	{
		StudentView sv=new StudentViewimpl();
		
		student st= sv.StudentLogin();//学生登录
		//sv.AddStudent();//学生注册
		CouseView cv=new CouseViewimpl();
		//cv.SelectCourse(st.getStudentId());//查询自己已经选择的课程
		//cv.chooseCourse(st.getStudentId());//选课
		
	}
	
	public static void main(String[] args) {
		new StudentSystem().Work();
	}
	 
}
