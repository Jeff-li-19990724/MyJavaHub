package com.neusoft.School;

import com.neusoft.School.po.teacher;
import com.neusoft.School.view.impl.CouseViewimpl;
import com.neusoft.School.view.impl.TeacherViewimpl;
import com.neusoft.School.view.inter.CouseView;
import com.neusoft.School.view.inter.TeacherView;

@SuppressWarnings("unused")
public class TeacherSystem {
	
	
	private void work() {
		TeacherView tv=new  TeacherViewimpl();
		CouseView cv=new CouseViewimpl();
		//课程管理模块
		//teacher t=tv.TeacherLogin();//教师登录
		//tv.AddTeacher();//添加老师
		//cv.AddCouse();//添加课程
		//cv.SelectCourse();//课程查询
		//cv.SelectCourseByCourseId();//查看某一课程下已经选的学生信息功能
		//cv.updateCourse();
		//cv.deleteCourse();
		//tv.deleteTeacher();
		tv.listTeacher_student();
	}

	public static void main(String[] args) {
		new TeacherSystem().work();
	}
}
