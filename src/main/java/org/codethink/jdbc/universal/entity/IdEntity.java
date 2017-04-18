package org.codethink.jdbc.universal.entity;
/**
 *
 * 抽象基类(非业务主键实体类)
 *
 * @author CaiXiangning 
 * @date Apr 16, 2017 
 * @email caixiangning@gmail.com
 */
public abstract class IdEntity {
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
