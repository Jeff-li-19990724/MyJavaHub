package com.neusoft.School.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/school?characterEncoding=utf-8";//
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	private static Connection conn;

	static {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BaseDAO() {
		super();
	}

	public int insert(String sqls, String parameter) throws SQLException {
		String sql = sqls;
		String[] a = parameter.split("\\,");// 2
		String[] b = sql.split("\\?"); // 3
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false); // 手动提交
			pstmt = conn.prepareStatement(sql);//
			if (a.length == b.length - 1) {
				for (int i = 0; i <= a.length - 1; i++) {
					pstmt.setString(i + 1, a[i]);
				}
			} else {
				if (a.length == b.length) {
					for (int i = 0; i <= a.length - 1; i++) {
						pstmt.setString(i + 1, a[i]);
					}
				} else {
					SQLException e = new SQLException();
					throw e;
				}
			}
			num = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			//close(null, pstmt, null);
		}

		return num;
	}
	static ResultSet rs = null;
    private static PreparedStatement stament;
	public static ResultSet getRs() {
		return rs;
	}

	public static void setRs(ResultSet rs) {
		BaseDAO.rs = rs;
	}

	public static PreparedStatement getStament() {
		return stament;
	}

	public static void setStament(PreparedStatement stament) {
		BaseDAO.stament = stament;
	}

	public static ResultSet select(String sqls, String parameter) throws SQLException {
		String[] a=null;
		String[] b=null;
		String sql = sqls;
		if (parameter != null) {
			 a= parameter.split("\\,");// 2
			 b = sql.split("\\?"); // 3
		} 
		stament = conn.prepareStatement(sql);
		if (parameter == null) {

		} else {
			if (a.length == b.length - 1) {
				for (int i = 0; i <= a.length - 1; i++) {
					stament.setString(i + 1, a[i]);
				}
			} else {
				if (a.length == b.length) {
					for (int i = 0; i <= a.length - 1; i++) {
						stament.setString(i + 1, a[i]);
					}
				} else {
					SQLException e = new SQLException();
					throw e;
				}
			}
		}

		
		try {
			rs = stament.executeQuery();
			return rs;
		} catch (SQLException e) {
			throw e;
		} finally {

		}
	}

	{
		// rs.next();
		// int is=rs.getInt("num");
		// System.out.println(sql);
		// if(is>0)
		// {
		// System.out.println("登录成功");
		// }

		// Date time=new Date();
		// Timestamp ts=new Timestamp(time.getTime());
		// String i= ts.toString();
		// String install_time1 = i.replace("T"," ")+":00";
		//
		//// 处理完后的格式："2016-11-11 11:11:00";
		//
		// //格式转换
		// //return Timestamp.valueOf(install_time1);
		// Timestamp.valueOf(install_time1);
	}

	public void update() {
		// 同insert

	}

	public void del() {
		// 同insert
	}

	public static Connection getConn() {
		return conn;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw e;
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw e;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw e;
			}
		}

	}
}
