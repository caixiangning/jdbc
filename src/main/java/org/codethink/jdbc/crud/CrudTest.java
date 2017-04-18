package org.codethink.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * JDBC增删改查操作示例
 * 
 * @author CaiXiangNing
 * @date 2017年4月12日
 * @email caixiangning@gmail.com
 */
public class CrudTest {
	
	/**
	 * 查询操作
	 */
	@Test
	public void testSelect(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = conn.createStatement();
			String sql = "SELECT id,name,password,email,age FROM tb_author";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.print("id=" + rs.getInt("id") + " ");
				System.out.print("name=" + rs.getString("name") + " ");
				System.out.print("password=" + rs.getString("password") + " ");
				System.out.print("email=" + rs.getString("email") + " ");
				System.out.println("age=" + rs.getInt("age"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 插入操作
	 */
	@Test
	public void testInsert(){
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = conn.createStatement();
			String sql = "INSERT INTO tb_author(name,password,email,age) VALUES('cai6','000006','cai6@gmail.com',26)";
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了  " + count + " 条记录");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 更新操作
	 */
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = conn.createStatement();
			String sql = "UPDATE tb_author SET name='ji5' WHERE name='cai5'";
			int count = st.executeUpdate(sql);
			System.out.println("在用户表中更新了  " + count + " 条记录");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 删除操作
	 */
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "root");
			st = conn.createStatement();
			String sql = "DELETE FROM tb_author WHERE name='cai4'";
			int count = st.executeUpdate(sql);
			System.out.println("在用户表中删除了  " + count + " 条记录");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(st != null){
					st.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
