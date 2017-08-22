package com.team.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** DB Connection을 가져오고 Connection 해제를 하는 함수 */
public class DBUtil {
	
	/*변수*/
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String CONNECTION_INFO = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String CONNECTION_USER = "asdf";
	private static final String CONNECTION_PASSWORD = "1234";
	
	/*함수*/
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** DB Connection을 가져오는 함수 */
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
	}//end of getConnection

	/** DB Connection을 닫는 함수 */
	public static void close(Connection con, PreparedStatement pstmt) {
		// TODO Auto-generated method stub
		try {
			if(pstmt != null)
			pstmt.close();
			if(con != null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of close

	/** DB Connection을 닫는 함수 */
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs != null)
			rs.close();
			if(pstmt != null)
			pstmt.close();
			if(con != null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of close
	
	
}//end of DBUtil

