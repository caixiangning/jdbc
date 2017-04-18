package org.codethink.jdbc.optimization;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * 使用单例模式创建ConnectionFactory实例(程序运行期间只有一个实例)
 *
 * @author CaiXiangning
 * @date Apr 13, 2017
 * @email caixiangning@gmail.com
 */
public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	// ConnectionFactory成员变量
	private static final ConnectionFactory  factory = new ConnectionFactory();
	
	// 数据库连接Connection成员变量
	private Connection conn;
	
	static {
		Properties prop = new Properties();
		try {
			// 获取属性文件中的内容,放置在输入流中
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("org/codethink/jdbc/optimization/conf/dbconfig.properties");
			// 从输入流中读取属性列表(键值对) 
			// Reads a property list (key and element pairs) from the input byte stream.
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("配置文件读取异常");
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	/**
	 * 私有构造函数防止外部创建其他ConnectionFactory对象
	 */
	private ConnectionFactory(){
		
	}
	
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	/**
	 * 获取数据库连接的Connection对象
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
