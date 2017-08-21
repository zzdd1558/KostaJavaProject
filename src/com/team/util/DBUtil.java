package com.team.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.dao.AddData;

public class DBUtil {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 저는 orcl 이지만 xe로 바꿔주시면 됩니다.
	private static final String CONNECTION_INFO = "jdbc:oracle:thin:@192.168.0.159:1521:xe";

	private static final String CONNECTION_USER = "asdf";
	private static final String CONNECTION_PASSWORD = "1234";
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONNECTION_INFO, CONNECTION_USER, CONNECTION_PASSWORD);
		} catch (SQLException e) {
			String msg = e.getMessage();
			System.out.println(msg);
		} AddData.initiate();
		return con;
	}

	

	

	/**
	 * 1. 개요 : 자원 닫아주기.
	 * 2. 처리내용 :  Connection , PreparedStatment 자원 close
	 * @Method Name : close
	 * @param con : Connection 타입의 매개변수 받기
	 * @param pstmt : PreparedStatement 타입의 매개변수 받기
	 */
	public static void close(Connection con, PreparedStatement pstmt) {
		// TODO Auto-generated method stub
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

	/**
	 * 1. 개요 : 자원 닫아주기.
	 * 2. 처리내용 :  Connection , PreparedStatment , ResultSet자원 close
	 * @Method Name : close
	 * @param con : Connection 타입의 매개변수 받기
	 * @param pstmt : PreparedStatement 타입의 매개변수 받기
	 * @param rs : ResultSet 타입의 매개변수 받기
	 */
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
