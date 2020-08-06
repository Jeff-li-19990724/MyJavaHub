package com.neusoft.School.view.impl;

import java.util.List;
import java.util.Scanner;

import com.neusoft.School.dao.impl.CourseDAOimpl;
import com.neusoft.School.dao.inter.CourseDAO;
import com.neusoft.School.po.CourseByID;
import com.neusoft.School.po.StudentToCourseView;
import com.neusoft.School.po.course;
import com.neusoft.School.view.inter.CouseView;

public class CouseViewimpl implements CouseView {
	private Scanner input = new Scanner(System.in);
	CourseDAO Cdao=new CourseDAOimpl();
	@Override
	public void AddCouse() {
		course c=new course();
		System.out.println("请输入课程名称");
		c.setCourseName(input.next());
		System.out.println("请输入课时");
		c.setCourseHour(input.nextInt());
		System.out.println("请输入所属教师编号");
		c.setTeacherID(input.nextInt());
		int id=Cdao.AddCouse(c);
		if (id > 0) 
		{
			System.out.println("课程添加成功");
		}
		else
		{
			System.out.println("添加失败");
		}
	}
	@Override
	public void SelectCourse() {
		List<course> A = Cdao.SelectCourse();
		for(course i:A)
		{
			System.out.println(i.toString());
		}
		
	}
	@Override
	public void SelectCourseByCourseId() {
		System.out.println("请输入课程编号");
		int id=input.nextInt();
		List<StudentToCourseView> s= Cdao.SelectCourseByCourseId(id);
		//s.get(index);
		for(StudentToCourseView i:s)
		{
			System.out.println(i.toString());
		}
	}
	@Override
	public void SelectCourse(int id) {
		for(CourseByID cid:Cdao.SelectCourseByStudentId(id))
		{
			System.out.println(cid.toString());
		}
		
	}
	@Override
	public void chooseCourse(int id) {
		SelectCourse();
		System.out.println("请输入课程编号");
		int Courseid=input.nextInt();
		if(Cdao.ChooseCourse(id, Courseid)>0)
		{
			System.out.println("选课成功");
		}
	}
	
	
	@Override
	public void updateCourse() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要修改的课程编号:");
		int courseId = input.nextInt();
		course course = Cdao.courseById(courseId);
		
		if(course == null){
			System.out.println("没有您要修改的课程信息");
		}else{
			String str = null;
			System.out.println(course.toString());
			System.out.println("是否修改课程名称?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的课程名称:");
				String courseName = input.next();
				course.setCourseName(courseName);
			}
			System.out.println("是否此课程对应课时?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的课程课时:");
				int courseHour = input.nextInt();
				course.setCourseHour(courseHour);
			}
			
			int count = Cdao.updateCourse(course);
			if(count > 0){
				System.out.println("课程信息修改成功！");
			}else{
				System.out.println("课程信息修改失败！");
			}
		}
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		System.out.println("请输入您要删除的课程编号:");
		int courseId = input.nextInt();
		course course = Cdao.courseById(courseId);
		System.out.println("是否确认要删除此课程?(y/n)");
		String str = input.next();
		if(str.equalsIgnoreCase("y")){
			if(course == null){
				System.out.println("没有您要删除的课程信息");
			}else{
				int count = Cdao.deleteCourse(courseId);
				if(count > 0){
					System.out.println("课程信息删除成功！");
				}else{
					System.out.println("课程信息删除失败！");
				}
			}
		}
		
	}

}
