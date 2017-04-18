package org.codethink.jdbc.universal.dao;

import java.util.ArrayList;

/**
 *
 * Dao层通用接口
 *
 * @author CaiXiangning 
 * @param <T>
 * @date Apr 16, 2017 
 * @email caixiangning@gmail.com
 */
public interface BaseDao<T> {
	
	/**
	 * 获取所有记录
	 * @param clazz 类型
	 * @return
	 */
	public ArrayList<T> getList(Class<T> clazz);
	
	/**
	 * 根据id获取一条记录
	 * @param clazz 类型
	 * @param id
	 * @return
	 */
	public T getObjById(Class<T> clazz, String id);
	
	/**
	 * 插入记录
	 * @param t 实体对象
	 * @return
	 */
	public boolean insert(T t);
	
	/**
	 * 更新记录
	 * @param t 实体对象
	 * @param id 记录id
	 * @return
	 */
	public boolean Update(T t, String id);
	
	/**
	 * 删除记录
	 * @param clazz 类型
	 * @param id 记录id
	 * @return
	 */
	public boolean Delete(Class<?> clazz, String id);
}
