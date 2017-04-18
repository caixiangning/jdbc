package org.codethink.jdbc.optimization.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.codethink.jdbc.optimization.ConnectionFactory;
import org.codethink.jdbc.optimization.dao.DepartmentDao;
import org.codethink.jdbc.optimization.dao.impl.DepartmentDaoImpl;
import org.codethink.jdbc.optimization.entity.Department;
import org.junit.Test;

/**
 *
 * 部门信息Dao层测试类
 *
 * @author CaiXiangning
 * @date Apr 13, 2017
 * @email caixiangning@gmail.com
 */
public class DepartmentDaoTest {

	@Test
	public void testSave() {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		try {
			conn.setAutoCommit(false);
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			Department department = new Department();
			department.setDepartName("Science Department");
			department.setDepartNumber("1002");
			departmentDao.save(conn, department);
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	@Test
	public void testUpdate() {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		try {
			conn.setAutoCommit(false);
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			Department department = new Department();
			department.setDepartName("Relations Department");
			department.setDepartNumber("1003");
			departmentDao.update(conn, 1, department);;
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	@Test
	public void testDelete() {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		try {
			conn.setAutoCommit(false);
			DepartmentDao departmentDao = new DepartmentDaoImpl();
			Department department = new Department();
			department.setId(1);
			departmentDao.delete(conn, department);
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
