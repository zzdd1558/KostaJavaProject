<<<<<<< HEAD
package com.team.dao;

public class OrdersDao {

}
=======
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.OrdersDTO;
import com.team.util.DBUtil;

/** DB의 Orders 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class OrdersDao {

	/*변수*/
	private static String sql;
	
	/*함수*/
	/** Orders 레코드를 추가하는 함수 */
	public static void add(OrdersDTO o) {
		
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into orders values(order_num.nextval,?,?,?,?,?)";
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, o.getId());
			ps.setString(3, o.getName());
			ps.setString(2, o.getAddr());
			ps.setString(4, o.getPhone());
			ps.setString(5, o.getOrderTime());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** Orders 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {
		
		sql = "delete from orders";
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
	
} // end of orderDao


>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
