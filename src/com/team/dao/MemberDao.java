package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;
import com.team.mypage.Member;
import com.team.util.DBUtil;
public class MemberDao {

	// 회원정보 출력
	public List<MemberDTO> memberList() {
		Connection con = DBUtil.getConnection();
		String sql = "select * from userInfo where id = ?";
		List<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, Member.userId);

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
	
	// 내용 변경 			(기준 id,	 변경 내용,		 바꿀 항목)
	public int updateMember(String id, String content, String update ) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update table member set " + update  + " = ? "
				+ " where id = ?";
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 바꿀 내용
			pstmt.setString(1, content); 
			
			// 기존 이름
			pstmt.setString(2, id); 
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
} // end of class





















