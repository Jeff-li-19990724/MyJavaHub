package com.neusoft.test1;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Test {
	/*
	 * �������ݿ�������������jar�� �������ӳ� ָ�����ӽӿڶ���
	 * 
	 */
	public static void main(String[] args) {

		AdminDAO ad = new AdminDAO();
		String sqls = "SELECT `id`,  `username`,  `password` FROM  `test`.`admin` WHERE username=? && PASSWORD=?";
		String parameter = "admin,admin";
		sqls="SELECT adminId,adminName,PASSWORD FROM admin WHERE   adminname=? &&PASSWORD=?";
		try {
			ResultSet rs = ad.select(sqls, parameter);
			rs.last(); // �Ƶ����һ��
			int rowCount = rs.getRow(); // �õ���ǰ�кţ�Ҳ���Ǽ�¼��
			rs.beforeFirst(); // �����Ҫ�ý�������Ͱ�ָ�����Ƶ���ʼ����λ��
			if (rowCount > 0) {
				System.out.println("��¼�ɹ�");
			}
		} catch (SQLException e) {
			System.out.println("�������쳣");
			e.printStackTrace();
		}
		// try {
		// Class.forName("org.gjt.mm.mysql.Driver");
		// String URL =
		// "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8";//
		// String USER = "root";
		// String PASSWORD = "1234";
		// Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// Statement stmt = conn.createStatement();
		// conn.setAutoCommit(false);
		// @SuppressWarnings("resource")
		// String username=new Scanner(System.in).next();
		// @SuppressWarnings("resource")
		// String password=new Scanner(System.in).next();
		// String sql;// = "INSERT INTO admin(username,PASSWORD)
		// VALUES('����','12345');";
		// // stmt.executeUpdate(sql);// statement.executeQuery();
		// //sql = "select `id`, `username`, `password` from `test`.`admin`
		// where username='"+username+"' && password='"+password+"' limit 0,
		// 1000;";
		// sql = "select count(username) as num from `test`.`admin`";// where
		// username=? && password=? limit 0, 1000;
		// PreparedStatement stament=conn.prepareStatement(sql);
		// //stament.setString(1,username);
		// //stament.setString(2,password);
		// ResultSet rs = stament.executeQuery();
		// //ResultSet rs = stmt.executeQuery(sql);// ��ѯ
		// //int i=rs.getMetaData().getColumnCount();
		//// rs.last(); //�Ƶ����һ��
		//// int rowCount = rs.getRow(); //�õ���ǰ�кţ�Ҳ���Ǽ�¼��
		//// rs.beforeFirst(); //�����Ҫ�ý�������Ͱ�ָ�����Ƶ���ʼ����λ��
		//// if(rowCount>0)
		//// {
		//// System.out.println("��¼�ɹ�");
		//// }
		// rs.next();
		// int is=rs.getInt("num");
		// System.out.println(sql);
		// if(is>0)
		// {
		// System.out.println("��¼�ɹ�");
		// }
		//// if(i>0)
		//// {
		//// System.out.println("��¼�ɹ�");
		//// }
		// while (rs.next()) {
		// System.out.println(
		// rs.getInt("id") + " " + rs.getString("username") + " "
		// + " " + rs.getString("password")+" "+rs.getTimestamp("Datetime"));
		// System.out.println(
		// rs.getInt(1) + " " + rs.getString(2) + " "
		// + " " + rs.getString(3));
		// }
		// conn.commit();//�ύ
		// conn.rollback();//�ع�
		//// rs.beforeFirst();
		//// while (rs.next()) {
		//// System.out.println(
		//// rs.getInt("id") + " " + rs.getString("username") + " "
		//// + " " + rs.getString("password"));
		//// System.out.println(
		//// rs.getInt(1) + " " + rs.getString(2) + " "
		//// + " " + rs.getString(3));
		//// }
		// //i=rs.getFetchSize();
		// // �ر���Դ
		// conn.close();
		// stmt.close();
		// {
		// Date date=new Date();
		 //Timestamp ts=new Timestamp(date.getTime());
		// SimpleDateFormat sdf=new SimpleDateFormat("YYYY��MM��dd��");
		// sdf.format(date);
		// // String name = "����";
		// // Ԥ����
		// //
		// //
		// //
		// // PreparedStatement statement = conn.prepareStatement(sql);
		// // //statement.setString(1, name);
		// // ResultSet rs = statement.executeQuery();
		// //// String sql="select * from userinfo where
		// // UserName='"+name+"'";
		// //// Statement statement = conn.createStatement();
		// //// ResultSet rs = statement.executeQuery(sql);
		// // // 4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
		//
		// // PreparedStatement statement = conn.prepareStatement(sql);
		//
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// int a = 100;
		// System.out.println("hello word" + a);
		// System.out.println("hello word" + a);
		// System.out.println("hello word" + a);
		// System.out.println("hello word" + a);
	}
}
