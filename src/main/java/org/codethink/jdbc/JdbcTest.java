package org.codethink.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * 
 * 
 * @author CaiXiangNing
 * @date 2017年4月11日
 * @email caixiangning@gmail.com
 */
public class JdbcTest {
	
	@Test
	public void testJdbc(){
		
		String sql = "SELECT * FROM tb_author";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
