package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;
import com.team.util.DBUtil;
public class MemberDao {

	// �쉶�썝�젙蹂� 異쒕젰
	public List<MemberDTO> memberList() {
		Connection con = DBUtil.getConnection();
		String sql = "select * from userInfo where id = ?";
		List<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			
//			pstmt.setString(1, Member.userID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new MemberDTO(rs.getString("id"), 
						rs.getString("name"),
						rs.getString("mail"),
						rs.getString("addr"),
						rs.getString("phone")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	} // end of memberList
	
	// �씠由� 蹂�寃�
	public int updateName(String id) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table name set colume = ? "
				+ " where colume = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 諛붽� �씠由�
			pstmt.setString(1, id); 
			
			// 湲곗〈 �씠由�
//			pstmt.setString(2, MyPage.userId); 
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// �씠硫붿씪 蹂�寃�
	public int updateMail(){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table mail set colume = ? "
				+ " where colume = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
//			// 諛붽� �씠硫붿씪
//			pstmt.setString(1, id); 
//			
//			// 湲곗〈 �씠硫붿씪
//			pstmt.setString(2, MyPage.userId); 
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
		
	}
	
	// 二쇱냼 蹂�寃�
	public int updateAddr(){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table addr set colume = ? "
				+ " where colume = ?";
		try {
//			
//			pstmt = con.prepareStatement(sql);
//			
//			// 諛붽� 二쇱냼
//			pstmt.setString(1, id); 
//			
//			// 湲곗〈 二쇱냼
//			pstmt.setString(2, MyPage.userId); 
//			
			result = pstmt.executeUpdate();
//			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	// 踰덊샇 蹂�寃�
	public int updatepghone(){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table phone set colume = ? "
				+ " where colume = ?";
		try {
//			
//			pstmt = con.prepareStatement(sql);
//			
//			// 諛붽� 踰덊샇
//			pstmt.setString(1, id); 
//			
//			// 湲곗〈 踰덊샇
//			pstmt.setString(2, MyPage.userId); 
//			
			result = pstmt.executeUpdate();
//			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
} // end of class





















