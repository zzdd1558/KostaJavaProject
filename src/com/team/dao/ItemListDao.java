package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.ItemListDTO;
import com.team.util.DBUtil;

/** DB의 ItemList 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class ItemListDao {

	/* 변수 */
	private static String sql; // 쿼리문

	/* 함수 */
	/** ItemList 테이블에 레코드를 추가하는 함수 */
	public static int add(ItemListDTO itemList) {

		int result = 0; // 성공 여부를 저장할 변수
		sql = "INSERT INTO itemlist VALUES(?,?)";
		Connection c = null;
		PreparedStatement ps = null;

		try {

			// DB Connection을 생성하고 쿼리문 생성
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

	}// end of add

	/** 테이블 내용을 초기화 하는 함수 */
	public static void deleteAll() {

		sql = "DELETE FROM itemlist";
		Connection c = null;
		PreparedStatement ps = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
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

}// end of ItemListDao
