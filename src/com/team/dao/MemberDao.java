package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;
import com.team.util.DBUtil;

/** DB의 Member 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class MemberDao {

	/* 함수 */
	/** 회원 정보 출력 */
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
	
	/** 이름 변경 */
	//
	public int updateName(String id) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table name set colume = ? "
				+ " where colume = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 바꿀 이름
			pstmt.setString(1, id); 
			
			// 기존 이름
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
	
	// 이메일 변경
	public int updateMail(){
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table mail set colume = ? "
				+ " where colume = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
//			// 바꿀 이메일
//			pstmt.setString(1, id); 
//			
//			// 기존 이메일
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
	
	// 주소 변경
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
//			// 바꿀 주소
//			pstmt.setString(1, id); 
//			
//			// 기존 주소
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
	
	// 번호 변경
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
//			// 바꿀 번호
//			pstmt.setString(1, id); 
//			
//			// 기존 번호
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





















