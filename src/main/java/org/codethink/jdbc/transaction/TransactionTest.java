package org.codethink.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * 事务处理
 * 
 * @author CaiXiangNing
 * @date 2017年4月12日
 * @email caixiangning@gmail.com
 */
public class TransactionTest {

	/**
	 * 获取Connection连接对象方法(公共代码提取出来，而且同一个Connection对象才能回滚)
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * 插入部门信息
	 * @param conn
	 * @throws SQLException
	 */
	public void insertDepartment(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		String sql = "INSERT INTO tb_department(id,departName,departNumber) VALUES(2,'Administration Department',1002)";
		int count = st.executeUpdate(sql);
		System.out.println("在部门表中插入了  " + count + " 条记录");
	}
	
	/**
	 * 插入雇员信息
	 * @param conn
	 * @throws SQLException
	 */
	public void insertEmployee(Connection conn) throws SQLException {
		Statement st = conn.createStatement();
		String sql = "INSERT INTO tb_employee(id,name,age,departId) VALUES(1,'cai2',22,2)";
		int count = st.executeUpdate(sql);
		System.out.println("在人员表中插入了  " + count + " 条记录");
	}

	/**
	 * 不进行事务处理(事务不回滚，每步操作成功都写入数据库,事务自动提交)
	 */
	@Test
	public void testNoTransaction() {
		Connection conn = TransactionTest.getConnection();
		try {
			insertDepartment(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("程序异常，未成功在部门表中插入记录");
		}
		try {
			insertEmployee(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("程序异常，未成功在雇员表中插入记录");
		}
	}
	
	/**
	 * 进行事务处理(事务不回滚，只要有一步操作不成功则事务回滚)
	 * @throws SQLException
	 */
	@Test
	public void testHasTransaction() throws SQLException {
		Connection conn = TransactionTest.getConnection();
		// 关闭事务的自动提交，改为手动提交
		conn.setAutoCommit(false);
		try {
			insertDepartment(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// 事务回滚，回滚的是同一个conn的预操作
			conn.rollback();
			System.out.println("事务回滚成功，之前的操作回滚");
		}
		try {
			insertEmployee(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// 事务回滚，回滚的是同一个conn的预操作
			conn.rollback();
			System.out.println("事务回滚成功，之前的操作回滚");
		}
		conn.commit();
		if(conn != null){
			conn.close();
		}
	}
	
	/**
	 * 不进行事务处理(不进行事务处理，则每步操作完成则事务都会自动提交，即使下面操作异常也不影响)
	 */
	@Test
	public void testNoTransaction1() {
		Connection conn = TransactionTest.getConnection();
		try {
			insertDepartment(conn);
			insertEmployee(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("程序异常，未成功在部门表中插入记录");
		}
	}
}
