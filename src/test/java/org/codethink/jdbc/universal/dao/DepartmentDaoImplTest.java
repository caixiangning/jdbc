package org.codethink.jdbc.universal.dao;

import java.util.ArrayList;

import org.codethink.jdbc.universal.dao.impl.DepartmentDaoImpl;
import org.codethink.jdbc.universal.entity.Department;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 部门信息dao层测试类
 *
 * @author CaiXiangning
 * @date Apr 17, 2017
 * @email caixiangning@gmail.com
 */
public class DepartmentDaoImplTest {

	@Test
	public void testQuery() {
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		ArrayList<Department> list = departmentDao.getList(Department.class);
		System.out.println(list);
	}

	@Test
	public void testGetObjById() {
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		Department department = departmentDao.getObjById(Department.class, "1");
		
		System.out.println(department);
	}

	@Test
	public void testInsert() {
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		Department department = new Department();
		department.setDepartName("Science Department");
		department.setDepartNumber("1002");

		boolean result = departmentDao.insert(department);
		Assert.assertEquals(true, result);
	}

	@Test
	public void testUpdate() {
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		Department department = new Department();
		department.setDepartName("Technical Department1");
		department.setDepartNumber("10011");

		boolean result = departmentDao.Update(department, "1");
		Assert.assertEquals(true, result);
	}

	@Test
	public void testDelete() {
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();

		boolean result = departmentDao.Delete(Department.class, "2");
		Assert.assertEquals(true, result);
	}
}
