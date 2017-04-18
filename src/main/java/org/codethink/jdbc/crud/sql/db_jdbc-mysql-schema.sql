
/* 创建数据库 */
CREATE DATABASE db_jdbc;

/* 使用该数据库 */
USE db_jdbc;

/* 如果该表存在则删除*/
DROP TABLE if EXISTS tb_author;

/* 创建表结构*/
CREATE TABLE tb_author(
id INT(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL DEFAULT '',
password VARCHAR(50) NOT NULL DEFAULT '',
email VARCHAR(50) NOT NULL DEFAULT '',
age INT(11), 
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;