package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.OrdersDTO;
import com.team.util.DBUtil;

public class OrdersDao {
	// 회원 Id 받아오기
	
	// 주문 정보 입력
	public static int orderInsert(OrdersDTO odto){
		Connection con = DBUtil.getConnection();
		String sql = "insert into orders values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		// 쿼리, 업데이트 차이 물어보기
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, odto.getOrderNum());
			pstmt.setString(2, odto.getId());
			pstmt.setString(3, odto.getAddr());
			pstmt.setString(4, odto.getName());
			pstmt.setString(5, odto.getPhone());
			pstmt.setString(6, odto.getOrderTime());
			
			result = pstmt.executeUpdate();
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
		
} // end of orderInsert


