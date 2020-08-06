package com.neusoft.School.dao.inter;

import java.util.List;


import com.neusoft.School.po.CourseByID;
import com.neusoft.School.po.StudentToCourseView;
import com.neusoft.School.po.course;

public interface CourseDAO {
	public int AddCouse(course co);

	public List<course> SelectCourse();

	public List<StudentToCourseView> SelectCourseByCourseId(int id);

	public List<CourseByID> SelectCourseByStudentId(int id);
	
	public int ChooseCourse(int id,int cid);
	
	public int deleteCourse(int courseId) ;
	
	public int updateCourse(course course);
	
	public course courseById(int courseId);
}
