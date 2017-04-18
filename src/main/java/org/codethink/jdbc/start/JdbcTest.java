package org.codethink.jdbc.start;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * jdbc的入门使用
 * 
 * @author CaiXiangNing
 * @date 2017年4月11日
 * @email caixiangning@gmail.com
 */
public class JdbcTest {

	@Test
	public void testJdbc() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM tb_author";

		// 1、装载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2、建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
		// 3、创建Statement对象
		Statement st = conn.createStatement();
		// 4、执行语句(executeQuery用于查询操作，executeUpdate用于INSERT、UPDATE、DELETE以及DDL(创建表，改变表，删除表)操作。
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.print("id=" + rs.getInt("id") + " ");
			System.out.print("name=" + rs.getString("name") + " ");
			System.out.print("password=" + rs.getString("password") + " ");
			System.out.print("email=" + rs.getString("email") + " ");
			System.out.println("age=" + rs.getString("age"));
		}
	}
}
