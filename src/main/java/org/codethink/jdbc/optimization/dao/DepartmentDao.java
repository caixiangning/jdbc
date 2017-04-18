package org.codethink.jdbc.optimization.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.codethink.jdbc.optimization.entity.Department;

/**
 *
 * 部门信息Dao层接口
 * 面向接口编程模式，接口定义实现类行为，实现类实现接口功能以及其他附加功能
 *
 * @author CaiXiangning 
 * @date Apr 13, 2017 
 * @email caixiangning@gmail.com
 */
public interface DepartmentDao {
	
	public void save(Connection conn, Department department) throws SQLException;
	
	public void update(Connection conn, long id, Department department) throws SQLException;
	
	public void delete(Connection conn, Department department) throws SQLException;
}
