package org.codethink.jdbc.universal.dao.impl;

import org.codethink.jdbc.universal.dao.DepartmentDao;
import org.codethink.jdbc.universal.entity.Department;

/**
 *
 * 部门信息Dao层实现类
 * 部门信息Dao层实现类继承BaseDaoImpl实现类，则可以使用其方法而无需再次定义，
 * 同时在实现类中可以自定义其他方法
 *
 * @author CaiXiangning 
 * @param <T>
 * @date Apr 17, 2017 
 * @email caixiangning@gmail.com
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao<Department> {
	
}
