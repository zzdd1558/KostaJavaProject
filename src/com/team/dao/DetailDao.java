<<<<<<< HEAD
package com.team.dao;

public class DetailDao {

}
=======
package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team.dto.DetailDTO;
import com.team.util.DBUtil;

/** DB의 Detail 테이블 데이터 추가,제거,수정을 담당하는 클래스 */
public class DetailDao {

	/*변수*/
	private static String sql;
	
	/*함수*/
	/** Detail 레코드를 추가하는 함수 */
	public static void add(DetailDTO d) {
		
		Connection c = null;
		PreparedStatement ps = null;
		sql = "insert into detail values(?,?,?)";
		
		try {
			
			c = DBUtil.getConnection();
			ps = c.prepareStatement(sql);
			ps.setInt(1, d.getItemNum());
			ps.setInt(2, d.getOrderNum());
			ps.setInt(3, d.getAmount());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(c, ps);
		}
		
	}//end of add
	
	/** Detail 레코드를 모두 삭제하는 함수 */
	public static void deleteAll() {
		
		sql = "delete from detail";
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
	
}//end of DetailDao
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
