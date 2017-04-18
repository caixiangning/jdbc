package org.codethink.jdbc.universal.entity;

/**
 *
 * 部门信息实体类
 *
 * @author CaiXiangning
 * @date Apr 16, 2017
 * @email caixiangning@gmail.com
 */
public class Department extends IdEntity {
	private String departName;
	private String departNumber;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartNumber() {
		return departNumber;
	}

	public void setDepartNumber(String departNumber) {
		this.departNumber = departNumber;
	}

	@Override
	public String toString() {
		return "Department [departName=" + departName + ", departNumber=" + departNumber + ", id=" + id + "]";
	}
}
