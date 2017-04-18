package org.codethink.jdbc.optimization;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**
 *
 * ConnectionFactory测试类
 *
 * @author CaiXiangning 
 * @date Apr 13, 2017 
 * @email caixiangning@gmail.com
 */
public class ConnectionFactoryTest {
	
	@Test
	public void testConnectionFactory() throws SQLException{
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.getConnection();
		System.out.println(conn.getAutoCommit());
	}
}
