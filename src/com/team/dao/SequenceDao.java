<<<<<<< HEAD
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.team.util.DBUtil;

/** SequenceÀÇ »ı¼º°ú »èÁ¦ ´ã´ç */
public class SequenceDao {
	
	/*º¯¼ö*/
	private static String sql;
	private static List<String> list;
	
	static {
		list = Arrays.asList( "order_num","item_num","event_num");
	}
	
	/*ÇÔ¼ö*/
	/** DB¿¡¼­ »ç¿ëÇÏ´Â ½ÃÄö½ºµé »ı¼º */
	public static void add() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ½ÃÄö½º »ı¼º
			for(String s:list) {
				
				//PreparedStatement°¡ Á¸ÀçÇÑ´Ù¸é ´İ±â
				if(ps != null)
					ps.close();
				
				//Äõ¸®¹® »ı¼º ¹× ½ÇÇà
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
	
	/** DB¿¡¼­ »ç¿ëÇÏ´Â ½ÃÄö½ºµé »èÁ¦ */
	public static void deleteAll() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ½ÃÄö½º »èÁ¦
			for(String s:list) {
				
				//PreparedStatement°¡ Á¸ÀçÇÑ´Ù¸é ´İ±â
				if(ps != null)
					ps.close();
				
				//Äõ¸®¹® »ı¼º ¹× ½ÇÇà
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

/** Sequenceì˜ ìƒì„±ê³¼ ì‚­ì œ ë‹´ë‹¹ */
public class SequenceDao {
	
	/*ë³€ìˆ˜*/
	private static String sql;
	private static List<String> list;
	
	static {
		list = Arrays.asList( "order_num","item_num","event_num");
	}
	
	/*í•¨ìˆ˜*/
	/** DBì—ì„œ ì‚¬ìš©í•˜ëŠ” ì‹œí€€ìŠ¤ë“¤ ìƒì„± */
	public static void add() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ì‹œí€€ìŠ¤ ìƒì„±
			for(String s:list) {
				
				//PreparedStatementê°€ ì¡´ì¬í•œë‹¤ë©´ ë‹«ê¸°
				if(ps != null)
					ps.close();
				
				//ì¿¼ë¦¬ë¬¸ ìƒì„± ë° ì‹¤í–‰
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
	
	/** DBì—ì„œ ì‚¬ìš©í•˜ëŠ” ì‹œí€€ìŠ¤ë“¤ ì‚­ì œ */
	public static void deleteAll() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ì‹œí€€ìŠ¤ ì‚­ì œ
			for(String s:list) {
				
				//PreparedStatementê°€ ì¡´ì¬í•œë‹¤ë©´ ë‹«ê¸°
				if(ps != null)
					ps.close();
				
				//ì¿¼ë¦¬ë¬¸ ìƒì„± ë° ì‹¤í–‰
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
