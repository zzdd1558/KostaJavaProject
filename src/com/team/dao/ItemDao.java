package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team.dto.ItemDTO;
import com.team.util.DBUtil;

/** DB�� Item ���̺� ������ �߰�,����,������ ����ϴ� Ŭ���� */
public class ItemDao {

	/*����*/
	private static String sql;
	
	/*�Լ�*/
	/** ��ǰ�� �߰��ϴ� �Լ� */
	public static int add(ItemDTO item) {
		
		int result = 0; //���� ���θ� ������ ����
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into items values(item_num.nextval,?,?,?,?,?)"; 
		
		try {
			//DB Connection�� �����ϰ� ������ ����
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setString(1, item.getCompany());
			ps.setString(2, item.getItemName());
			ps.setString(3, item.getEtc());
			ps.setString(4, item.getPrice());
			ps.setString(5, item.getCode());
			
			//�������� �����ϰ� �� ����� ����
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

		return result;
		
	}//end of add
	
	/** ���̺� ������ �ʱ�ȭ �ϴ� �Լ� */
	public static void deleteAll() {
		
		sql = "delete from items";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection�� ������ ���� �� ����
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
	
	/** ��ǰ ��ȣ�� ���� ��ǰ ���� �������� */
	public static ItemDTO getItemByNum(int num) {
		
		ItemDTO item = null;
		sql = "select * from items i, itemlist il where i.code = il.code and item_num = ?";
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			//DB Connection�� ������ ���� �� ����
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			//ResultSet�� ����ִ� ���� ����
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
