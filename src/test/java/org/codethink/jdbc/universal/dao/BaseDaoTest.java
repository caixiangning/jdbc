package org.codethink.jdbc.universal.dao;

import java.util.ArrayList;

import org.codethink.jdbc.universal.dao.impl.BaseDaoImpl;
import org.codethink.jdbc.universal.entity.Department;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 通用Dao层测试类
 *
 * @author CaiXiangning 
 * @date Apr 16, 2017 
 * @email caixiangning@gmail.com
 */
public class BaseDaoTest{
	
	@Test
	public void testQuery(){
		BaseDao<Department> baseDao = new BaseDaoImpl<>();
		ArrayList<Department> arrList = baseDao.getList(Department.class);
		for(Department department:  arrList){
			System.out.println(department);
		}
	}
	
	@Test
	public void testInsert(){
		BaseDao<Department> baseDao = new BaseDaoImpl<>();
		Department department = new Department();
		department.setDepartName("Science Department");
		department.setDepartNumber("1002");
		
		boolean result = baseDao.insert(department);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testUpdate(){
		BaseDao<Department> baseDao = new BaseDaoImpl<>();
		Department department = new Department();
		department.setDepartName("Technical Department1");
		department.setDepartNumber("10011");
		
		boolean result = baseDao.Update(department, "1");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void testDelete(){
		BaseDao<Department> baseDao = new BaseDaoImpl<>();
		
		boolean result = baseDao.Delete(Department.class, "2");
		Assert.assertEquals(true, result);
	}
}
