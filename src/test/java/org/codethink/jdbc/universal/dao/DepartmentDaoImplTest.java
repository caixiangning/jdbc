package org.codethink.jdbc.universal.dao;

import java.util.ArrayList;

import org.codethink.jdbc.universal.dao.impl.DepartmentDaoImpl;
import org.codethink.jdbc.universal.entity.Department;
import org.junit.Test;

/**
 *
 * 
 *
 * @author CaiXiangning 
 * @date Apr 17, 2017 
 * @email caixiangning@gmail.com
 */
public class DepartmentDaoImplTest {
	
	@Test
	public void testQuery(){
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		ArrayList<Department> list = departmentDao.getList(Department.class);
		System.out.println(list);
	}
	
	@Test
	public void testGetObjById(){
		DepartmentDao<Department> departmentDao = new DepartmentDaoImpl();
		Department department = departmentDao.getObjById(Department.class, "1");
		System.out.println(department);
	}
	
}
