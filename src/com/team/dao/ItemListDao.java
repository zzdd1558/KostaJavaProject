<<<<<<< HEAD
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.ItemListDTO;
import com.team.util.DBUtil;

/** DBÀÇ ItemList Å×ÀÌºí µ¥ÀÌÅÍ Ãß°¡,Á¦°Å,¼öÁ¤À» ´ã´çÇÏ´Â Å¬·¡½º */
public class ItemListDao {

	/*º¯¼ö*/
	private static String sql; //Äõ¸®¹®
	
	/*ÇÔ¼ö*/
	/** ItemList Å×ÀÌºí¿¡ ·¹ÄÚµå¸¦ Ãß°¡ÇÏ´Â ÇÔ¼ö */
	public static int add(ItemListDTO itemList) {
		
		int result = 0; //¼º°ø ¿©ºÎ¸¦ ÀúÀåÇÒ º¯¼ö
		sql = "insert into itemlist values(?,?)";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB ConnectionÀ» »ý¼ºÇÏ°í Äõ¸®¹® »ý¼º
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
	
	/** Å×ÀÌºí ³»¿ëÀ» ÃÊ±âÈ­ ÇÏ´Â ÇÔ¼ö */
	public static void deleteAll() {
		
		sql = "delete from itemlist";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection°ú Äõ¸®¹® »ý¼º ¹× ½ÇÇà
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

/** DBì˜ ItemList í…Œì´ë¸” ë°ì´í„° ì¶”ê°€,ì œê±°,ìˆ˜ì •ì„ ë‹´ë‹¹í•˜ëŠ” í´ëž˜ìŠ¤ */
public class ItemListDao {

	/*ë³€ìˆ˜*/
	private static String sql; //ì¿¼ë¦¬ë¬¸
	
	/*í•¨ìˆ˜*/
	/** ItemList í…Œì´ë¸”ì— ë ˆì½”ë“œë¥¼ ì¶”ê°€í•˜ëŠ” í•¨ìˆ˜ */
	public static int add(ItemListDTO itemList) {
		
		int result = 0; //ì„±ê³µ ì—¬ë¶€ë¥¼ ì €ìž¥í•  ë³€ìˆ˜
		sql = "insert into itemlist values(?,?)";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connectionì„ ìƒì„±í•˜ê³  ì¿¼ë¦¬ë¬¸ ìƒì„±
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
	
	/** í…Œì´ë¸” ë‚´ìš©ì„ ì´ˆê¸°í™” í•˜ëŠ” í•¨ìˆ˜ */
	public static void deleteAll() {
		
		sql = "delete from itemlist";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connectionê³¼ ì¿¼ë¦¬ë¬¸ ìƒì„± ë° ì‹¤í–‰
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
