package com.neusoft.School.view.impl;

import java.util.Scanner;

import com.neusoft.School.dao.impl.StudentDAOimpl;
import com.neusoft.School.dao.impl.teacherDAOimpl;
import com.neusoft.School.dao.inter.StudentDAO;
import com.neusoft.School.dao.inter.teacherDAO;
import com.neusoft.School.po.student;
import com.neusoft.School.po.teacher;
import com.neusoft.School.view.inter.StudentView;

@SuppressWarnings("unused")
public class StudentViewimpl implements StudentView {
	private Scanner input = new Scanner(System.in);
	private static StudentDAO tdao = new StudentDAOimpl();

	@Override
	public student StudentLogin() {
		System.out.println("请输入学号");
		int tacherID = input.nextInt();
		System.out.println("请输入姓名");
		String tacherName = input.next();
		return tdao.StudentLogin(tacherID, tacherName);
	}

	@Override
	public int AddStudent() {

		student s = new student();
		System.out.println("请输入学号");
		s.setStudentId(input.nextInt());
		System.out.println("请输入姓名");
		s.setStudentName(input.next());
		System.out.println("请输入班级");
		s.setStudentClass(input.next());

		if (tdao.AddStudent(s) > 0) {
			System.out.println("添加成功");
		}

		return 0;
	}

}
