package com.neusoft.School.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.School.dao.impl.teacherDAOimpl;
import com.neusoft.School.dao.inter.teacherDAO;
import com.neusoft.School.po.student;
import com.neusoft.School.po.teacher;
import com.neusoft.School.view.inter.TeacherView;

public class TeacherViewimpl implements TeacherView {
	private Scanner input = new Scanner(System.in);
	private static teacherDAO tdao = new teacherDAOimpl();

	@Override
	public teacher TeacherLogin() {
		System.out.println("请输入教工号");
		int tacherID = input.nextInt();
		System.out.println("请输入姓名");
		String tacherName = input.next();
		return tdao.teacherLogin(tacherID, tacherName);
	}
	@Override
	public void AddTeacher() {
		teacher t = new teacher();
		System.out.println("请输入所属课程");
		t.setTechnology(input.next());
		System.out.println("请输入姓名");
		t.setTeacherName(input.next());
		int id=tdao.AddTeacher(t);
		if (id > 0) 
		{
			System.out.println("添加成功;教工号是："+id);
		}
		else
		{
			System.out.println("添加失败");
		}
	}
	@Override
	public void SelectTeacher() {
		for(teacher t: tdao.SelectTeacher())
		{
			t.toString();
		}
	}
	public void updateTeacher(){
		System.out.println("请输入您要修改的教师编号:");
		int teacherId = input.nextInt();
		teacher teacher = tdao.teacherById(teacherId);
		
		if(teacher == null){
			System.out.println("没有您要修改的教师");
		}else{
			String str = null;
			System.out.println(teacher.toString());
			System.out.println("是否修改教师姓名?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的教师姓名:");
				String teacherName = input.next();
				teacher.setTeacherName(teacherName);
			}
			System.out.println("是否修改教师技术方向?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的教师技术方向:");
				String technology = input.next();
				teacher.setTechnology(technology);
			}
			
			int count = tdao.updateteacher(teacher);
			if(count > 0){
				System.out.println("教师信息修改成功！");
			}else{
				System.out.println("教师信息修改失败！");
			}
		}
		
	}
	
	public void deleteTeacher(){
		System.out.println("请输入您要删除的教师编号:");
		int teacherId = input.nextInt();
		teacher teacher = tdao.teacherById(teacherId);
		System.out.println("是否确认要删除此课程?(y/n)");
		String str = input.next();
		if(str.equalsIgnoreCase("y")){
			if(teacher == null){
				System.out.println("没有您要删除的教师");
			}else{
				int count = tdao.deleteTeacher(teacherId);
				if(count > 0){
					System.out.println("教师信息删除成功！");
				}else{
					System.out.println("教师信息删除失败！");
				}
			}
		}
	}
	
	public void listTeacher_student(){
		System.out.println("请输入您要查看的教师编号:");
		int teacherId = input.nextInt();
		teacher teacher = tdao.teacherById(teacherId);
		if(teacher == null){
			System.out.println("没有您要查看的教师");
		}else{
			List<student> slist = tdao.listTeacher_student(teacherId);
			System.out.println("学生编号\t学生姓名\t专业班级");
			for(student s:slist){
				System.out.println(s.getStudentId()+"\t"+s.getStudentName()+"\t"+s.getStudentClass());
			}
		}
	}

}
