package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;

/** DB의 Member 테이블 데이터 추가,제거,수정을 담당하는 클래스 */

import com.team.util.DBUtil;
public class MemberDAO {

	// 회원정보 출력
	public List<MemberDTO> memberList() {
		Connection con = DBUtil.getConnection();
		String sql = "select * from userInfo where id = ?";
		List<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			

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
	
	// 이름 변경
	public int updateName() {
		Connection con = DBUtil.getConnection();
		String sql = "update table name set colume = ? where colume = ?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	// 이메일 변경
	
	// 주소 변경
	
	// 번호 변경
	
	
	
	
	
	
	
	
	
} // end of class





















