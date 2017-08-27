
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.OrdersDTO;
import com.team.util.DBUtil;

/** DB의 Orders 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class OrdersDao {

	/* 변수 */
	private static String sql;

	/* 함수 */
	/** Orders 레코드를 추가하는 함수 */
	public static int add(OrdersDTO o) {

		int result = 0;
		Connection c = null;
		PreparedStatement ps = null;
		sql = "INSERT INTO orders VALUES(order_num.nextval,?,?,?,?,to_date(sysdate,'YY/MM/DD HH:MI:SS'))";

		try {

			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, o.getId());
			ps.setString(3, o.getName());
			ps.setString(2, o.getAddr());
			ps.setString(4, o.getPhone());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

		return result;
	}// end of add

	/** Orders 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {

		sql = "DELETE FROM orders";
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

} // end of orderDao
