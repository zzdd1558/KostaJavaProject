package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.EventDTO;
import com.team.util.DBUtil;

/** DB의 Event 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class EventDao {

	/*변수*/
	private static String sql;
	
	/*함수*/
	/** Event 레코드를 추가하는 함수 */
	public static void add(EventDTO ev) {
		
		Connection c = null;
		PreparedStatement ps = null;
		sql = "INSERT INTO event VALUES(event_num.nextval,?,?)";
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, ev.getEventName());
			ps.setString(2, ev.getContent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** Event 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {
		
		sql = "DELETE FROM event";
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
	
}//end of EventDao
