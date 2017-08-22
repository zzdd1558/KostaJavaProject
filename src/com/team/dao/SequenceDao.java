package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.team.util.DBUtil;

/** Sequence�� ������ ���� ��� */
public class SequenceDao {
	
	/*����*/
	private static String sql;
	private static List<String> list;
	
	static {
		list = Arrays.asList( "order_num","item_num","event_num");
	}
	
	/*�Լ�*/
	/** DB���� ����ϴ� �������� ���� */
	public static void add() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ������ ����
			for(String s:list) {
				
				//PreparedStatement�� �����Ѵٸ� �ݱ�
				if(ps != null)
					ps.close();
				
				//������ ���� �� ����
				sql = "create sequence "+s+" start with 1 increment by 1";
				ps = c.prepareStatement(sql);
				ps.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** DB���� ����ϴ� �������� ���� */
	public static void deleteAll() {
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			
			c = DBUtil.getConnection();
			
			// ������ ����
			for(String s:list) {
				
				//PreparedStatement�� �����Ѵٸ� �ݱ�
				if(ps != null)
					ps.close();
				
				//������ ���� �� ����
				sql = "drop sequence "+s;
				ps = c.prepareStatement(sql);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}

	}//end of deleteAll
	
}//end of SequenceDao
