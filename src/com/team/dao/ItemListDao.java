<<<<<<< HEAD
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.ItemListDTO;
import com.team.util.DBUtil;

/** DB의 ItemList 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class ItemListDao {

	/*변수*/
	private static String sql; //쿼리문
	
	/*함수*/
	/** ItemList 테이블에 레코드를 추가하는 함수 */
	public static int add(ItemListDTO itemList) {
		
		int result = 0; //성공 여부를 저장할 변수
		sql = "insert into itemlist values(?,?)";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection을 생성하고 쿼리문 생성
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, itemList.getCode());
			ps.setString(2, itemList.getKind());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return result;
		
	}//end of add
	
	/** 테이블 내용을 초기화 하는 함수 */
	public static void deleteAll() {
		
		sql = "delete from itemlist";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection과 쿼리문 생성 및 실행
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
	
}//end of ItemListDao
=======
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.ItemListDTO;
import com.team.util.DBUtil;

/** DB�쓽 ItemList �뀒�씠釉� �뜲�씠�꽣 異붽��,�젣嫄�,�닔�젙�쓣 �떞�떦�븯�뒗 �겢�옒�뒪 */
public class ItemListDao {

	/*蹂��닔*/
	private static String sql; //荑쇰━臾�
	
	/*�븿�닔*/
	/** ItemList �뀒�씠釉붿뿉 �젅肄붾뱶瑜� 異붽���븯�뒗 �븿�닔 */
	public static int add(ItemListDTO itemList) {
		
		int result = 0; //�꽦怨� �뿬遺�瑜� ����옣�븷 蹂��닔
		sql = "insert into itemlist values(?,?)";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection�쓣 �깮�꽦�븯怨� 荑쇰━臾� �깮�꽦
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, itemList.getCode());
			ps.setString(2, itemList.getKind());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
		return result;
		
	}//end of add
	
	/** �뀒�씠釉� �궡�슜�쓣 珥덇린�솕 �븯�뒗 �븿�닔 */
	public static void deleteAll() {
		
		sql = "delete from itemlist";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection怨� 荑쇰━臾� �깮�꽦 諛� �떎�뻾
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
	
}//end of ItemListDao
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
