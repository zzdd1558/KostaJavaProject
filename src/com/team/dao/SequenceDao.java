<<<<<<< HEAD
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.team.util.DBUtil;

/** Sequence의 생성과 삭제 담당 */
public class SequenceDao {
	
	/*변수*/
	private static String sql;
	private static List<String> list;
	
	static {
		list = Arrays.asList( "order_num","item_num","event_num");
	}
	
	/*함수*/
	/** DB에서 사용하는 시퀀스들 생성 */
	public static void add() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// 시퀀스 생성
			for(String s:list) {
				
				//PreparedStatement가 존재한다면 닫기
				if(ps != null)
					ps.close();
				
				//쿼리문 생성 및 실행
				sql = "create sequence "+s+" start with 1 increment by 1";
				ps = c.prepareStatement(sql);
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** DB에서 사용하는 시퀀스들 삭제 */
	public static void deleteAll() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// 시퀀스 삭제
			for(String s:list) {
				
				//PreparedStatement가 존재한다면 닫기
				if(ps != null)
					ps.close();
				
				//쿼리문 생성 및 실행
				sql = "drop sequence "+s;
				ps = c.prepareStatement(sql);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

	}//end of deleteAll
	
}//end of SequenceDao
=======
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.team.util.DBUtil;

/** Sequence�쓽 �깮�꽦怨� �궘�젣 �떞�떦 */
public class SequenceDao {
	
	/*蹂��닔*/
	private static String sql;
	private static List<String> list;
	
	static {
		list = Arrays.asList( "order_num","item_num","event_num");
	}
	
	/*�븿�닔*/
	/** DB�뿉�꽌 �궗�슜�븯�뒗 �떆����뒪�뱾 �깮�꽦 */
	public static void add() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// �떆����뒪 �깮�꽦
			for(String s:list) {
				
				//PreparedStatement媛� 議댁옱�븳�떎硫� �떕湲�
				if(ps != null)
					ps.close();
				
				//荑쇰━臾� �깮�꽦 諛� �떎�뻾
				sql = "create sequence "+s+" start with 1 increment by 1";
				ps = c.prepareStatement(sql);
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** DB�뿉�꽌 �궗�슜�븯�뒗 �떆����뒪�뱾 �궘�젣 */
	public static void deleteAll() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// �떆����뒪 �궘�젣
			for(String s:list) {
				
				//PreparedStatement媛� 議댁옱�븳�떎硫� �떕湲�
				if(ps != null)
					ps.close();
				
				//荑쇰━臾� �깮�꽦 諛� �떎�뻾
				sql = "drop sequence "+s;
				ps = c.prepareStatement(sql);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

	}//end of deleteAll
	
}//end of SequenceDao
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
