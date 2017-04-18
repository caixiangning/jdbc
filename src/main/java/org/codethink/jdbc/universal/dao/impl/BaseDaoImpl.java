package org.codethink.jdbc.universal.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.codethink.jdbc.universal.dao.BaseDao;
import org.codethink.jdbc.universal.util.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Dao层通用接口实现类
 * (前提是：表名和实体类名，字段名和属性名称是相同的)
 *
 * @author CaiXiangning 
 * @param <T>
 * @date Apr 17, 2017 
 * @email caixiangning@gmail.com
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	/**
	 * 获取所有记录
	 * @param clazz 类型
	 * @return
	 */
	public ArrayList<T> getList(Class<T> clazz){
		ArrayList<T> arrayList = new ArrayList<>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT * FROM " + clazz.getSimpleName();
		logger.info("拼接的查询SQL语句：{}", selectSql);
		
		try{
			ps = conn.prepareStatement(selectSql);
			rs = ps.executeQuery();
			// 结果集存入list
			while(rs.next()){
				// 调用实体类无参构造函数构造对象
				T t = clazz.newInstance();
				// 获取类中的所有属性(类)对象
				Field[] fields = clazz.getDeclaredFields();
				for(Field field: fields){
					field.setAccessible(true);
					// 为指定指定对象的该属性赋值
					field.set(t, rs.getObject(field.getName()));
				}
				arrayList.add(t);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			ConnectionFactory.closeRes(rs, ps, conn);
		}
		return arrayList;
	}
	
	@Override
	public T getObjById(Class<T> clazz, String id) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 结果对象
		T t = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM ");
		sb.append(clazz.getSimpleName());
		sb.append(" WHERE id=");
		sb.append(id);
		String selectSql = sb.toString();
		logger.info("拼接的查询SQL语句：{}", selectSql);
		
		try{
			ps = conn.prepareStatement(selectSql);
			rs = ps.executeQuery();
			
			// 调用实体类无参构造函数构造对象
			t = clazz.newInstance();
			while(rs.next()){
				// 获取类中的所有属性(类)对象
				Field[] fields = clazz.getDeclaredFields();
				for(Field field: fields){
					field.setAccessible(true);
					// 为指定指定对象的该属性赋值
					field.set(t, rs.getObject(field.getName()));
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			ConnectionFactory.closeRes(rs, ps, conn);
		}
		return t;
	}
	
	/**
	 * 插入记录
	 * @param t 实体对象
	 * @return
	 */
	public boolean insert(T t){
		Connection conn = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		
		// 获取对象的Class对象
		Class<?> clazz = t.getClass();
		// 获取类中的所有属性(类)对象
		Field[] fields = clazz.getDeclaredFields();
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO  ");
		// getSimpleName()：获取类名称(简短) getName()：获取类的全限类名
		sb.append(clazz.getSimpleName());
		sb.append(" (");
		
		for(int i=0; i<fields.length; i++){
			sb.append(fields[i].getName());
			if(i != fields.length-1){
				sb.append(",");
			}
		}
		sb.append(") VALUES (");
		for(int i=0; i<fields.length; i++){
			sb.append("?");
			if(i != fields.length-1){
				sb.append(",");
			}
		}
		sb.append(")");
		String insertSql = sb.toString();
		logger.info("拼接的插入SQL语句：{}", insertSql);
		try {
			ps = conn.prepareStatement(insertSql);
			for(int i=0; i<fields.length; i++){
				fields[i].setAccessible(true);
				// get(Object obj)获取指定对象参数的该属性的值
				ps.setObject(i+1, fields[i].get(t));
			}
			int result = ps.executeUpdate();
			if(result >0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeRes(ps, conn);
		}
		return false;
	}
	
	/**
	 * 更新记录
	 * @param t 实体对象
	 * @param id 记录id
	 * @return
	 */
	public boolean Update(T t, String id){
		Connection conn = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		
		Class<?> clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE  ");
		sb.append(clazz.getSimpleName());
		sb.append(" SET ");
		for(int i=0; i<fields.length; i++){
			fields[i].setAccessible(true);
			sb.append(fields[i].getName() + "=?");
			if(i != fields.length-1){
				sb.append(",");
			}
		}
		sb.append(" WHERE id=" + id);
		String updateSql = sb.toString();
		logger.info("拼接的更新SQL语句：{}", updateSql);
		try {
			ps = conn.prepareStatement(updateSql);
			for(int i=0; i<fields.length; i++){
				fields[i].setAccessible(true);
				ps.setObject(i+1, fields[i].get(t));
			}
			int result = ps.executeUpdate();
			if(result >0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeRes(ps, conn);
		}
		return false;
	}
	
	/**
	 * 删除记录
	 * @param clazz 类型
	 * @param id 记录id
	 * @return
	 */
	public boolean Delete(Class<?> clazz, String id){
		Connection conn = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM ");
		sb.append(clazz.getSimpleName());
		sb.append(" WHERE id=" + id);
		
		String deleteSql = sb.toString();
		logger.info("拼接的删除SQL语句：{}", deleteSql);
		
		try {
			ps = conn.prepareStatement(deleteSql);
			int result = ps.executeUpdate();
			if(result >0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeRes(ps, conn);
		}
		return false;
	}
}
