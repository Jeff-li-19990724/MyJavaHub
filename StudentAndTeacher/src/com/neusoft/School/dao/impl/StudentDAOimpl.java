package com.neusoft.School.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.School.dao.inter.StudentDAO;
import com.neusoft.School.po.student;
import com.neusoft.School.po.teacher;
import com.neusoft.School.util.BaseDAO;

@SuppressWarnings("unused")
public class StudentDAOimpl extends BaseDAO implements StudentDAO {

	@Override
	public student StudentLogin(int id, String name) {
		String sql="SELECT  `studentId`,  `studentName`,  `StudentClass`FROM  `school`.`student`  WHERE studentId=?  &&  studentName=? ";
		String can=id+","+name;
		try {
			ResultSet rs = select(sql, can);
			rs.last(); 
			int rowCount = rs.getRow(); 
			rs.beforeFirst();
			if (rowCount == 1) {
				rs.next();
				System.out.println("登录成功");
				student admin=new student(rs.getInt(1), rs.getString(2),  rs.getString(3));
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int AddStudent(student s) {
		String sql = "INSERT INTO `school`.`student` (  `studentId`,  `studentName`,  `StudentClass`)VALUES  ( ?, ?, ?);";
		PreparedStatement statement = null;
		try {
			statement = getConn().prepareStatement(sql);
			statement.setInt(1, s.getStudentId());
			statement.setString(2,s.getStudentName());
			statement.setString(3,s.getStudentClass());
			int num=statement.executeUpdate();
			return num;
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

}
