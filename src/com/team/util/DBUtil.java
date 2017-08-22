package com.team.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// ???Š” orcl ?´ì§?ë§? xeë¡? ë°”ê¿”ì£¼ì‹œë©? ?©?‹ˆ?‹¤.
	private static final String CONNECTION_INFO = "jdbc:oracle:thin:@localhost:1521:xe";

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
		}
		return con;
	}

	

	

	/**
	 * 1. ê°œìš” : ??› ?‹«?•„ì£¼ê¸°.
	 * 2. ì²˜ë¦¬?‚´?š© :  Connection , PreparedStatment ??› close
	 * @Method Name : close
	 * @param con : Connection ???…?˜ ë§¤ê°œë³??ˆ˜ ë°›ê¸°
	 * @param pstmt : PreparedStatement ???…?˜ ë§¤ê°œë³??ˆ˜ ë°›ê¸°
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
	 * 1. ê°œìš” : ??› ?‹«?•„ì£¼ê¸°.
	 * 2. ì²˜ë¦¬?‚´?š© :  Connection , PreparedStatment , ResultSet??› close
	 * @Method Name : close
	 * @param con : Connection ???…?˜ ë§¤ê°œë³??ˆ˜ ë°›ê¸°
	 * @param pstmt : PreparedStatement ???…?˜ ë§¤ê°œë³??ˆ˜ ë°›ê¸°
	 * @param rs : ResultSet ???…?˜ ë§¤ê°œë³??ˆ˜ ë°›ê¸°
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
