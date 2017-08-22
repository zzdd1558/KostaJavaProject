package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.ItemListDTO;
import com.team.util.DBUtil;

/** DB�� ItemList ���̺� ������ �߰�,����,������ ����ϴ� Ŭ���� */
public class ItemListDao {

	/*����*/
	private static String sql; //������
	
	/*�Լ�*/
	/** ItemList ���̺� ���ڵ带 �߰��ϴ� �Լ� */
	public static int add(ItemListDTO itemList) {
		
		int result = 0; //���� ���θ� ������ ����
		sql = "insert into itemlist values(?,?)";
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			//DB Connection�� �����ϰ� ������ ����
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
	
	/** ���̺� ������ �ʱ�ȭ �ϴ� �Լ� */
	public static void deleteAll() {
		
		sql = "delete from itemlist";
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
	
}//end of ItemListDao
