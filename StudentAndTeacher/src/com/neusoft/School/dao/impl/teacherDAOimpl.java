package com.neusoft.School.dao.impl;

import java.awt.Desktop.Action;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.School.dao.inter.teacherDAO;
import com.neusoft.School.po.student;
import com.neusoft.School.po.teacher;
import com.neusoft.School.util.BaseDAO;

@SuppressWarnings("unused")
public class teacherDAOimpl extends BaseDAO implements teacherDAO {

	@Override
	public teacher teacherLogin(int id, String Name) {
		String sql="SELECT  `teacherID`,  `teacherName`,  `technology`,  `IsInjob`  FROM  `school`.`teacher`  WHERE teacherID=?  &&  teacherName=?  && IsInjob=true";
		String can=id+","+Name;
		try {
			ResultSet rs = select(sql, can);
			rs.last(); 
			int rowCount = rs.getRow(); 
			rs.beforeFirst();
			if (rowCount == 1) {
				rs.next();
				System.out.println("登录成功");
				teacher admin=new teacher(rs.getInt(1), rs.getString(2),  rs.getString(3));
				rs.close();
				close(null,getStament() ,getRs());
				return admin;
			}
		} catch (SQLException e) {
			System.out.println("SQL错误");
			e.printStackTrace();
		}
		finally {
			try {
				close(null,getStament() ,getRs());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int AddTeacher(teacher t) {
		String sql = "INSERT INTO `school`.`teacher` (`teacherName`,`technology`,  `IsInjob`)VALUES  ( ?,?,1);";
		PreparedStatement statement = null;
		try {
			statement = getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, t.getTeacherName());
			statement.setString(2, t.getTechnology());
			statement.executeUpdate();
			setRs(statement.getGeneratedKeys());
			if (getRs().next()) {
				int i = getRs().getInt(1);
				return i;
			}
		} catch (SQLException e) {
			System.out.println("sql错误");
		} finally {
			try {
				close(null, statement, getRs());
			} catch (SQLException e) {
				System.out.println("参数关闭异常");
			}
		}
		return 0;
	}

	@Override
	public List<teacher> SelectTeacher() {
			String sql = "select teacherid ,teachername,technology from teacher ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<teacher> tlist = new ArrayList<teacher>();
			try {
				pstmt = getConn().prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					teacher t = new teacher();
					t.setTeacherID(rs.getInt("teacherid"));
					t.setTeacherName(rs.getString("teachername"));
					t.setTechnology(rs.getString("technology"));
					tlist.add(t);
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
			return tlist;
		}
		
	
	public int updateteacher(teacher teacher){
		String sql = "update teacher set teachername = ?,technology = ? where teacherid = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherName());
			pstmt.setString(2, teacher.getTechnology());
			pstmt.setInt(3, teacher.getTeacherID());
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
	
	//数据库事务
	@SuppressWarnings("resource")
	public int deleteTeacher(int teacherId){
		String sql1 = "delete from stucou where courseid in (select courseid from course where  teacherid = ?)";
		String sql2 = "delete from course where teacherid = ?";
		String sql3 = "delete from teacher where teacherid = ? ";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			getConn().setAutoCommit(false);
			pstmt = getConn().prepareStatement(sql1);
			pstmt.setInt(1, teacherId);
			count = pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql2);
			pstmt.setInt(1, teacherId);
			count = pstmt.executeUpdate();
			
			pstmt = getConn().prepareStatement(sql3);
			pstmt.setInt(1, teacherId);
			count = pstmt.executeUpdate();
			
			getConn().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				getConn().rollback();
			} catch (SQLException e1) {
			}
		}finally{
			try {
				close(null, pstmt, null);
			} catch (SQLException e) {
			}
		}
		return count;
	}

	@Override
	public teacher teacherById(int teacherId) {
		String sql = "select teacherid ,teachername,technology from teacher where teacherid = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		teacher t = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);;
			rs = pstmt.executeQuery();
			if(rs.next()){
				t = new teacher();
				t.setTeacherID(rs.getInt("teacherid"));
				t.setTeacherName(rs.getString("teachername"));
				t.setTechnology(rs.getString("technology"));
				
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
		return t;
	}
	@Override
	public List<student> listTeacher_student(int teacherId) {
		String sql = "select s.Studentid ,s.Studentname,s.StudentClass from student s,stucou sc,course c,teacher t "
				+ "where t.teacherId = c.teacherId and c.courseId = sc.courseId and sc.studentid = s.studentid and t.teacherid = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<student> slist = new ArrayList<student>();
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				student student = new student();
				student.setStudentId(rs.getInt("studentid"));
				student.setStudentName(rs.getString("studentname"));
				student.setStudentClass(rs.getString("studentclass"));
				slist.add(student);
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
		return slist;
	}
}
