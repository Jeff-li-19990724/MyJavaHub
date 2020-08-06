package com.neusoft.School.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.School.dao.inter.CourseDAO;
import com.neusoft.School.po.CourseByID;
import com.neusoft.School.po.StudentToCourseView;
import com.neusoft.School.po.course;
import com.neusoft.School.util.BaseDAO;

public class CourseDAOimpl extends BaseDAO implements CourseDAO {
	public int AddCouse(course co) {
		String sql = "INSERT INTO `school`.`course` (  `CourseName`,  `CourseHour`,  `TeacherID`)VALUES(?,?,?);";
		PreparedStatement statement = null;
		int m=0;
		try {
			statement = getConn().prepareStatement(sql);
			statement.setString(1, co.getCourseName());
			statement.setInt(2, co.getCourseHour());
			statement.setInt(3, co.getTeacherID());
			m = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql错误");
		} finally {
			try {
				close(null, statement, getRs());
			} catch (SQLException e) {
				System.out.println("参数关闭异常");
			}
		}
		return m;
	}
	@Override
	public List<course> SelectCourse() {
		StringBuffer sql = new StringBuffer(
				"SELECT  `CourseId`,  `CourseName`,  `CourseHour`,  `TeacherID`FROM  `school`.`course`");
		try {
			ResultSet rs = getConn().prepareStatement(sql.toString()).executeQuery();

			List<course> bs = new ArrayList<course>();
			while (rs.next()) {
				course bu = new course(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4));
				bs.add(bu);
			}
			close(null, getStament(), rs);
			return bs;
		} catch (SQLException e) {
			System.out.println("SQL错误");
		}
		return null;
	}
	@Override
	public List<CourseByID> SelectCourseByStudentId(int id) {
		StringBuffer sql = new StringBuffer(
				"SELECT sc.`CourseID`,c.`CourseName`,c.`CourseHour` FROM StuCou sc, course c  WHERE Sc.`StudentID`=? && sc.`CourseID`=c.`CourseId` ");
		try {
			
			setStament(getConn().prepareStatement(sql.toString()));
			getStament().setLong(1, id);
			ResultSet rs=getStament().executeQuery() ;
			List<CourseByID> bs = new ArrayList<CourseByID>();
			while (rs.next()) {
				CourseByID bu = new CourseByID(rs.getInt(1), rs.getString(2), rs.getInt(3));
				bs.add(bu);
			}
			close(null, getStament(), rs);
			return bs;
		} catch (SQLException e) {
			System.out.println("SQL错误");
		}
		return null;
	}

	@Override
	public List<StudentToCourseView> SelectCourseByCourseId(int id) {
		StringBuffer sql = new StringBuffer("SELECT s.StudentID,s.studentName,s.StudentClass, c.CourseName FROM Student s , StuCou sc,course c WHERE s.StudentID=sc.`StudentID` && c.`CourseId`=sc.`CourseID` &&c.`CourseId`=?");
		
		try {
			PreparedStatement pr = getConn().prepareStatement(sql.toString());
			pr.setInt(1,id);
			ResultSet rs=pr.executeQuery();
			List<StudentToCourseView> bs = new ArrayList<StudentToCourseView>();
			while (rs.next()) {
				StudentToCourseView bu = new StudentToCourseView();
				bu.setStudentID(rs.getInt(1));
				bu.setStudentName(rs.getString(2));
				bu.setStudentClass(rs.getString(3));
				bu.setCourseName(rs.getString(4));
				bs.add(bu);
			}
			close(null, getStament(), rs);
			return bs;
		} catch (SQLException e) {
			System.out.println("SQL错误");
		}
		return null;
	}

	@Override
	public int ChooseCourse(int id, int cid) {
		String sql = "INSERT INTO `school`.`stucou` (`StudentID`,  `CourseID`,  `ISHave`)VALUES  (?, ?,1 );";
		PreparedStatement statement = null;
		int m=0;
		try {
			statement = getConn().prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, cid);
			m = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql错误");
		} finally {
			try {
				close(null, statement, getRs());
			} catch (SQLException e) {
				System.out.println("参数关闭异常");
			}
		}
		return m;
	}
	@Override
	public int updateCourse(course course) {
		
		String sql = "update course set coursename= ?,CourseHour = ? where courseid = ?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, course.getCourseName());
			pstmt.setInt(2, course.getCourseHour());
			pstmt.setInt(3, course.getCourseId());
			count = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				close(null, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@SuppressWarnings("resource")
	@Override
	public int deleteCourse(int courseId) {
		String sql1 = "delete from stucou where courseid = ? ";
		String sql2 = "delete from course where courseid = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			getConn().setAutoCommit(false);
			pstmt = getConn().prepareStatement(sql1);
			pstmt.setInt(1, courseId);
			count = pstmt.executeUpdate();
		
			pstmt = getConn().prepareStatement(sql2);
			pstmt.setInt(1, courseId);
			count = pstmt.executeUpdate();
			getConn().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				close(null, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	public course courseById(int courseId){
		String sql = "select Courseid ,Coursename,Coursehour,teacherid from Course where courseid = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		course c = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				c = new course();
				c.setCourseHour(rs.getInt("Coursehour"));
				c.setCourseId(rs.getInt("Courseid"));
				c.setCourseName(rs.getString("Coursename"));
				c.setTeacherID(rs.getInt("teacherid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				close(null, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;
	}

}
