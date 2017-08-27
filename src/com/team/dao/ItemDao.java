package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team.dto.ItemDTO;
import com.team.util.DBUtil;

/** DB의 Item 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class ItemDao {

	/* 변수 */
	private static String sql;

	/* 함수 */
	/** 부품을 추가하는 함수 */
	public static int add(List<ItemDTO> items) {

		int result = 0; // 성공 여부를 저장할 변수
		Connection c = null;
		PreparedStatement ps = null;
		sql = "INSERT INTO items VALUES(item_num.nextval,?,?,?,?,?)";

		try {
			// DB Connection을 생성하고 쿼리문 생성
			c = DBUtil.getConnection();
			for (ItemDTO item : items) {
				ps = c.prepareStatement(sql);
				ps.setString(1, item.getCompany());
				ps.setString(2, item.getItemName());
				ps.setString(3, item.getEtc());
				ps.setInt(4, item.getPrice());
				ps.setString(5, item.getCode());

				// 쿼리문을 실행하고 그 결과를 저장
				result = ps.executeUpdate();
			}
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

		sql = "DELETE FROM items";
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

	/** 부품 번호를 통해 부품 정보 가져오기 */
	public static ItemDTO getItemByNum(int num) {

		ItemDTO item = null;
		sql = "SELECT * FROM items i, itemlist il WHERE i.code = il.code AND item_num = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();

			// ResultSet에 담겨있는 정보 저장
			if (rs.next()) {

				String name = rs.getString("item_name");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String company = rs.getString("company");

				item = new ItemDTO(num, company, name, etc, price, code);

				item.setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return item;

	}// end of getItemByNum

	/** 부품 종류를 통해 검색 */
	public static List<ItemDTO> getPartName(String listName) {

		List<ItemDTO> list = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "SELECT * FROM items i, itemlist l WHERE i.code = l.code and LOWER(l.kind) = LOWER(?)"
				+ " ORDER BY item_num";

		try {
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, listName);
			rs = ps.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("item_num");
				String name = rs.getString("item_name");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String company = rs.getString("company");

				list.add(new ItemDTO(num, company, name, etc, price, code));
				list.get(list.size() - 1).setListName(listName);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;
	}

	/** 가격으로 부품 검색 */
	public static List<ItemDTO> searchForPartsByPrice(String min, String max) {

		List<ItemDTO> list = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		sql = "SELECT * FROM items i, itemlist l WHERE i.code = l.code AND price>= ? AND price <= ?"
				+ " ORDER BY item_num";

		try {
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, min);
			ps.setString(2, max);
			rs = ps.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("item_num");
				String name = rs.getString("item_name");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String company = rs.getString("company");

				list.add(new ItemDTO(num, company, name, etc, price, code));
				list.get(list.size() - 1).setListName(rs.getString("kind"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;
	} // end of searchForpartsByPrice

	/** 이름으로 부품 검색 */
	public static List<ItemDTO> searchForPartsByName(String name) {

		List<ItemDTO> list = null;
		sql = "SELECT * FROM items i, itemlist il WHERE i.code = il.code AND LOWER(item_name) = LOWER(?)" + " ORDER BY item_num";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			// ResultSet에 담겨있는 정보 배열에 저장
			while (rs.next()) {

				int num = rs.getInt("item_num");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String company = rs.getString("company");

				list.add(new ItemDTO(num, company, name, etc, price, code));
				list.get(list.size() - 1).setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;

	} // end of searchForpartsByPrice

	/** 제조사로 부품 검색 */
	public static List<ItemDTO> searchForPartsByCompany(String company) {

		List<ItemDTO> list = null;
		sql = "SELECT * FROM items i, itemlist il WHERE i.code = il.code and LOWER(company) = LOWER(?)" + " ORDER BY item_num";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, company);
			rs = ps.executeQuery();

			// ResultSet에 담겨있는 정보 배열에 저장
			while (rs.next()) {

				int num = rs.getInt("item_num");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String name = rs.getString("item_name");

				list.add(new ItemDTO(num, company, name, etc, price, code));
				list.get(list.size() - 1).setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;

	} // end of searchForpartsByPrice

	public List<ItemDTO> partsConfirm(String partsName) {
		// TODO Auto-generated method stub
		List<ItemDTO> list = null;
		sql = "SELECT * FROM items i INNER JOIN itemlist il ON i.code = il.code WHERE LOWER(il.kind) = LOWER(?) ";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, partsName);
			rs = ps.executeQuery();

			// ResultSet에 담겨있는 정보 배열에 저장
			while (rs.next()) {

				int num = rs.getInt("item_num");
				String cpmpany = rs.getString("company");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String name = rs.getString("item_name");
				
				list.add(new ItemDTO(num, cpmpany, name, etc, price, code));
				list.get(list.size() - 1).setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;

	} // end of partsConfirm
	
	
	/** 입력한 최저가와 최고가 사이의 부품 출력 */
	public List<ItemDTO> partsMinAndMaxPrice(int minPrice , int maxPrice) {
		List<ItemDTO> list = null;
		sql = "SELECT * FROM items i INNER JOIN itemlist il ON i.code = il.code WHERE price BETWEEN ? AND ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, minPrice);
			ps.setInt(2, maxPrice);
			rs = ps.executeQuery();
			// ResultSet에 담겨있는 정보 배열에 저장
			while (rs.next()) {
				int num = rs.getInt("item_num");
				String company = rs.getString("company");
				String code = rs.getString("code");
				String etc = rs.getString("etc");
				int price = Integer.parseInt(rs.getString("price"));
				String name = rs.getString("item_name");
				list.add(new ItemDTO(num,company,name,etc,price,code));
				list.get(list.size() - 1).setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}
		return list;
	}
	
	public List<ItemDTO> partsCompanyConfirm() {
		// TODO Auto-generated method stub
		List<ItemDTO> list = null;
		sql = "SELECT DISTINCT(company) , kind FROM items i INNER JOIN itemlist il ON i.code = il.code ORDER BY kind ASC";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// DB Connection과 쿼리문 생성 및 실행
			list = new ArrayList<>();
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();

			// ResultSet에 담겨있는 정보 배열에 저장
			while (rs.next()) {
				String cpmpany = rs.getString("company");
				list.add(new ItemDTO(cpmpany));
				list.get(list.size() - 1).setListName(rs.getString("kind"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps, rs);
		}

		return list;

	} // end of partsConfirm
	
	
}// end of ItemDao
