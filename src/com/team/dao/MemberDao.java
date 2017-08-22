package com.team.dao;

<<<<<<< HEAD
/** DB의 Member 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class MemberDao {

	
	
}//end of MemberDao
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.MemberDTO;
import com.team.test.Test;
import com.team.util.DBUtil;

/** DB�쓽 Member �뀒�씠釉� �뜲�씠�꽣 異붽��,�젣嫄�,�닔�젙�쓣 �떞�떦�븯�뒗 �겢�옒�뒪 */
public class MemberDao {

	/*蹂��닔*/
	private static String sql;
	
	/*�븿�닔*/
	/** Member �젅肄붾뱶瑜� 異붽���븯�뒗 �븿�닔 */
	public static void add(MemberDTO m) {
		
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into member values(?,?,?,?,?,?,?)";
		
		try {
			
			//DB Connection �깮�꽦 諛� 荑쇰━臾� �깮�꽦
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getBirth());
			ps.setString(5, m.getMail());
			ps.setString(6, m.getAddr());
			ps.setString(7, m.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** Member �젅肄붾뱶瑜� 紐⑤몢 �궘�젣�븯�뒗 �븿�닔 */
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
		
	}//end of deleteAll
	
	
	// 硫ㅻ쾭 由ъ뒪�듃 異쒕젰
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
	
	/** �쉶�썝(Member) �젅肄붾뱶�쓽 �궡�슜�쓣 蹂�寃쏀븯�뒗 �븿�닔 */
	// �궡�슜 蹂�寃� 			(湲곗�� id,	 蹂�寃� �궡�슜,		 諛붽�� �빆紐�)
	public int updateMember(String id, String content, String update ) {
		
		//DB Connection 諛� 荑쇰━臾� �깮�꽦
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		sql = "update table member set " + update  + " = ? "
				+ " where id = ?";
		try {
			
			pstmt = con.prepareStatement(sql);

			// id ��� 諛붽�� �궡�슜 荑쇰━臾몄뿉 �궫�엯
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
	
} // end of class





















>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
