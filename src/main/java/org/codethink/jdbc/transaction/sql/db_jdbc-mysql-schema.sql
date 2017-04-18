
/* 创建数据库 */
CREATE DATABASE db_jdbc;

/* 使用该数据库 */
USE db_jdbc;

/* 如果该表存在则删除*/
DROP TABLE if EXISTS tb_department;

/* 创建部门信息表结构*/
CREATE TABLE tb_department(
id INT(11) NOT NULL AUTO_INCREMENT,
departName VARCHAR(50) NOT NULL DEFAULT '',
departNumber VARCHAR(20) NOT NULL,
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 创建雇员信息表结构*/
CREATE TABLE tb_employee(
id INT(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL DEFAULT '',
age INT(11) NOT NULL,
departId INT(11) NOT NULL,
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;