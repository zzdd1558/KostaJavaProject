package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;
import com.team.test.Test;
import com.team.util.DBUtil;

/** DB의 Member 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class MemberDao {

	/* 변수 */
	private static String sql;

	/* 함수 */
	/** Member 레코드를 추가하는 함수 */
	public static int add(MemberDTO m) {

		int result = 0;
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into member values(?,?,?,?,?,?,?)";

		try {

			// DB Connection 생성 및 쿼리문 생성
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getBirth());
			ps.setString(5, m.getMail());
			ps.setString(6, m.getAddr());
			ps.setString(7, m.getPhone());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

		return result;
	}// end of add

	/** Member 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {

		sql = "delete from member";
		Connection c = null;
		PreparedStatement ps = null;

		try {

			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

	}// end of deleteAll

	// 멤버 리스트 출력
	public List<MemberDTO> memberList() {
		Connection con = DBUtil.getConnection();
		String sql = "select * from userInfo where id = ?";
		List<MemberDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, Test.userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new MemberDTO(rs.getString("id"), rs.getString("name"), rs.getString("mail"),
						rs.getString("addr"), rs.getString("phone")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list;
	} // end of memberList

	/** 회원(Member) 레코드의 내용을 변경하는 함수 */
	// 내용 변경 (기준 id, 변경 내용, 바꿀 항목)
	public int updateMember(String id, String content, String update) {

		// DB Connection 및 쿼리문 생성
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		sql = "update table member set " + update + " = ? " + " where id = ?";
		try {

			pstmt = con.prepareStatement(sql);

			// id 와 바꿀 내용 쿼리문에 삽입
			pstmt.setString(1, content);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}// end of updateMember

	/** 아이디와 비밀번호를 통해 Member를 반환하는 함수 */
	public static MemberDTO checkMember(String id, String pwd) {

		MemberDTO m = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "select * from member where id = ?";

		try {

			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				m = new MemberDTO();
				m.setId(id);
				m.setAddr(rs.getString("addr"));
				m.setBirth(rs.getString("birth"));
				m.setPwd(rs.getString("pwd"));
				m.setMail(rs.getString("mail"));
				m.setPhone(rs.getString("phone"));

				// 비밀번호가 일치하지 않으면 null 대입
				if (!pwd.equals(rs.getString("pwd")))
					m = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return m;

	}// end of checkMember
	
	/** 아이디 중복 조회 */
	public static boolean checkId(String id) {
		
		boolean exist = false;
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "select * from member where id = ?";
		
		try {
			
			//Connection과 쿼리문 생성 및 실행
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			//만약 ResultSet에 무언가가 존재한다면 중복
			if(rs.next())
				exist = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return exist;
		
	}//end of checkId

} // end of class
