package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.dto.ItemDTO;
import com.team.util.DBUtil;

/** DB의 Item 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class ItemDao {

	/*변수*/
	private static String sql;
	
	/*함수*/
	/** 부품을 추가하는 함수 */
	public static int add(ItemDTO item) {
		
		int result = 0; //성공 여부를 저장할 변수
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into items values(item_num.nextval,?,?,?,?,?)"; 
		
		try {
			//DB Connection을 생성하고 쿼리문 생성
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, item.getCompany());
			ps.setString(2, item.getItemName());
			ps.setString(3, item.getEtc());
			ps.setString(4, item.getPrice());
			ps.setString(5, item.getCode());
			
			//쿼리문을 실행하고 그 결과를 저장
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
		
		sql = "delete from items";
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
	
	/** 부품 번호를 통해 부품 정보 가져오기 */
	public static ItemDTO getItemByNum(int num) {
		
		ItemDTO item = null;
		sql = "select * from items i, itemlist il where i.code = il.code and item_num = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			//DB Connection과 쿼리문 생성 및 실행
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			//ResultSet에 담겨있는 정보 저장
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
