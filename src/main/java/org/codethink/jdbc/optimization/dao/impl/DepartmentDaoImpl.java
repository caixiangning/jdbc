package org.codethink.jdbc.optimization.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.codethink.jdbc.optimization.dao.DepartmentDao;
import org.codethink.jdbc.optimization.entity.Department;

/**
 *
 * 
 *
 * @author CaiXiangning
 * @date Apr 13, 2017
 * @email caixiangning@gmail.com
 */
public class DepartmentDaoImpl implements DepartmentDao {

	/**
	 * 保存部门信息.
	 */
	@Override
	public void save(Connection conn, Department department) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("INSERT INTO tb_department(departName,departNumber) VALUES(?,?)");
		ps.setString(1, department.getDepartName());
		ps.setString(2, department.getDepartNumber());
		ps.execute();
	}
	
	/**
	 * 更新指定部门信息.
	 */
	@Override
	public void update(Connection conn, long id, Department department) throws SQLException {
		// TODO Auto-generated method stub
		String updateSql = "UPDATE tb_department SET departName = ?, departNumber = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, department.getDepartName());
		ps.setString(2, department.getDepartNumber());
		ps.setLong(3, id);
		ps.execute();
	}

	/**
	 * 删除指定部门信息.
	 */
	@Override
	public void delete(Connection conn, Department department) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement("DELETE FROM tb_department WHERE id = ?");
		ps.setLong(1, department.getId());
		ps.execute();
	}
}
