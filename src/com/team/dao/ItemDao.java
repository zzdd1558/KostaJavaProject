<<<<<<< HEAD
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.dto.ItemDTO;
import com.team.util.DBUtil;

/** DBÀÇ Item Å×ÀÌºí µ¥ÀÌÅÍ Ãß°¡,Á¦°Å,¼öÁ¤À» ´ã´çÇÏ´Â Å¬·¡½º */
public class ItemDao {

	/*º¯¼ö*/
	private static String sql;
	
	/*ÇÔ¼ö*/
	/** ºÎÇ°À» Ãß°¡ÇÏ´Â ÇÔ¼ö */
	public static int add(ItemDTO item) {
		
		int result = 0; //¼º°ø ¿©ºÎ¸¦ ÀúÀåÇÒ º¯¼ö
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into items values(item_num.nextval,?,?,?,?,?)"; 
		
		try {
			//DB ConnectionÀ» »ý¼ºÇÏ°í Äõ¸®¹® »ý¼º
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, item.getCompany());
			ps.setString(2, item.getItemName());
			ps.setString(3, item.getEtc());
			ps.setString(4, item.getPrice());
			ps.setString(5, item.getCode());
			
			//Äõ¸®¹®À» ½ÇÇàÇÏ°í ±× °á°ú¸¦ ÀúÀå
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
		
		sql = "delete from items";
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
	
	/** ºÎÇ° ¹øÈ£¸¦ ÅëÇØ ºÎÇ° Á¤º¸ °¡Á®¿À±â */
	public static ItemDTO getItemByNum(int num) {
		
		ItemDTO item = null;
		sql = "select * from items i, itemlist il where i.code = il.code and item_num = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			//DB Connection°ú Äõ¸®¹® »ý¼º ¹× ½ÇÇà
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			//ResultSet¿¡ ´ã°ÜÀÖ´Â Á¤º¸ ÀúÀå
			if(rs.next()) {
				
				String name = rs.getString("item_name");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				String price = rs.getString("price");
				String company = rs.getString("company");
				
				item = new ItemDTO(num,company,name,etc,price,code);
				
				item.setListName(rs.getString("kind"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return item;
		
	}//end of getItemByNum
	
}//end of ItemDao
=======
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.dto.ItemDTO;
import com.team.util.DBUtil;

/** DBì˜ Item í…Œì´ë¸” ë°ì´í„° ì¶”ê°€,ì œê±°,ìˆ˜ì •ì„ ë‹´ë‹¹í•˜ëŠ” í´ëž˜ìŠ¤ */
public class ItemDao {

	/*ë³€ìˆ˜*/
	private static String sql;
	
	/*í•¨ìˆ˜*/
	/** ë¶€í’ˆì„ ì¶”ê°€í•˜ëŠ” í•¨ìˆ˜ */
	public static int add(ItemDTO item) {
		
		int result = 0; //ì„±ê³µ ì—¬ë¶€ë¥¼ ì €ìž¥í•  ë³€ìˆ˜
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into items values(item_num.nextval,?,?,?,?,?)"; 
		
		try {
			//DB Connectionì„ ìƒì„±í•˜ê³  ì¿¼ë¦¬ë¬¸ ìƒì„±
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, item.getCompany());
			ps.setString(2, item.getItemName());
			ps.setString(3, item.getEtc());
			ps.setString(4, item.getPrice());
			ps.setString(5, item.getCode());
			
			//ì¿¼ë¦¬ë¬¸ì„ ì‹¤í–‰í•˜ê³  ê·¸ ê²°ê³¼ë¥¼ ì €ìž¥
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
		
		sql = "delete from items";
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
	
	/** ë¶€í’ˆ ë²ˆí˜¸ë¥¼ í†µí•´ ë¶€í’ˆ ì •ë³´ ê°€ì ¸ì˜¤ê¸° */
	public static ItemDTO getItemByNum(int num) {
		
		ItemDTO item = null;
		sql = "select * from items i, itemlist il where i.code = il.code and item_num = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			//DB Connectionê³¼ ì¿¼ë¦¬ë¬¸ ìƒì„± ë° ì‹¤í–‰
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			//ResultSetì— ë‹´ê²¨ìžˆëŠ” ì •ë³´ ì €ìž¥
			if(rs.next()) {
				
				String name = rs.getString("item_name");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				String price = rs.getString("price");
				String company = rs.getString("company");
				
				item = new ItemDTO(num,company,name,etc,price,code);
				
				item.setListName(rs.getString("kind"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		
		return item;
		
	}//end of getItemByNum
	
}//end of ItemDao
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
