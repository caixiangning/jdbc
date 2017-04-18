package org.codethink.jdbc.optimization.entity;

/**
 *
 * 人员信息实体类
 *
 * @author CaiXiangning
 * @date Apr 13, 2017
 * @email caixiangning@gmail.com
 */
public class Employee extends IdEntity {
	private String name;
	private int age;
	private int departId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", departId=" + departId + ", id=" + id + "]";
	}
}
