package com.team.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
public class DBUtil {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// ??? orcl ?΄μ§?λ§? xeλ‘? λ°κΏμ£Όμλ©? ?©??€.
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
	 * 1. κ°μ : ?? ?«?μ£ΌκΈ°.
	 * 2. μ²λ¦¬?΄?© :  Connection , PreparedStatment ?? close
	 * @Method Name : close
	 * @param con : Connection ???? λ§€κ°λ³?? λ°κΈ°
	 * @param pstmt : PreparedStatement ???? λ§€κ°λ³?? λ°κΈ°
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
	 * 1. κ°μ : ?? ?«?μ£ΌκΈ°.
	 * 2. μ²λ¦¬?΄?© :  Connection , PreparedStatment , ResultSet?? close
	 * @Method Name : close
	 * @param con : Connection ???? λ§€κ°λ³?? λ°κΈ°
	 * @param pstmt : PreparedStatement ???? λ§€κ°λ³?? λ°κΈ°
	 * @param rs : ResultSet ???? λ§€κ°λ³?? λ°κΈ°
=======
import com.team.dao.AddData;

public class DBUtil {
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// μ λ orcl μ΄μ§λ§ xeλ‘ λ°κΏμ£Όμλ©΄ λ©λλ€.
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
	 * 1. κ°μ : μμ λ«μμ£ΌκΈ°.
	 * 2. μ²λ¦¬λ΄μ© :  Connection , PreparedStatment μμ close
	 * @Method Name : close
	 * @param con : Connection νμμ λ§€κ°λ³μ λ°κΈ°
	 * @param pstmt : PreparedStatement νμμ λ§€κ°λ³μ λ°κΈ°
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
	 * 1. κ°μ : μμ λ«μμ£ΌκΈ°.
	 * 2. μ²λ¦¬λ΄μ© :  Connection , PreparedStatment , ResultSetμμ close
	 * @Method Name : close
	 * @param con : Connection νμμ λ§€κ°λ³μ λ°κΈ°
	 * @param pstmt : PreparedStatement νμμ λ§€κ°λ³μ λ°κΈ°
	 * @param rs : ResultSet νμμ λ§€κ°λ³μ λ°κΈ°
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
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
