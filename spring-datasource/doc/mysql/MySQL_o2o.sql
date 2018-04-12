/* MySQL */

/* 移除数据库 */
/* DROP DATABASE IF EXISTS hibernate; */
/* 创建数据库 */
/* CREATE DATABASE hibernate CHARACTER SET 'UTF8';    */
/* 使用数据库 */
/* USE hibernate;  */

/* one to one */

/* 创建表 */
DROP TABLE IF EXISTS person;
CREATE TABLE person (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表';

/* 添加数据 */
INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('徐明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('王洁', null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('邝边', null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('刘雨', null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('赵备', null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('卡扎尔-龙华', null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('牛芳', null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('伊尔民', null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('沙尔塔', null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号');

INSERT INTO person (name, photoUrl, gender, nation, birthday, address) 
VALUES ('郑飞', null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号');


/* 创建表 */
DROP TABLE IF EXISTS idCard;
CREATE TABLE idCard (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	title varchar(32) COMMENT '身份证标题, 例如 : 中华人民共和国 - 居民身份证',
	cardNo varchar(64) COMMENT '身份证号',
	issuingAuthority varchar(32) COMMENT '签发机关 (Xx市公安局)',
	effectiveDate datetime COMMENT '生效日期 yyyy-MM-dd',
	expiryDate datetime COMMENT '失效日期 yyyy-MM-dd',
	personId int(11) COMMENT '身份证持有者的id',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';


INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '55122519730503881X', '上海市公安局', '2000-01-02', '2010-01-02', null);
INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '65122519860503886X', '杭州市公安局', '2011-03-02', '2021-03-02', null);
INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '25122519890503883X', '湛江市公安局', '1993-11-05', '2003-11-05', null);
INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '14122519870503882X', '无锡市公安局', '2002-06-02', '2012-06-02', null);
INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '88122519860503881X', '天津市公安局', '2014-01-07', '2024-01-07', null);
INSERT INTO idCard (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '40122519960503887X', '深圳市公安局', '2013-01-02', '2023-01-02', null);

/* 添加外键约束 */
/* ALTER TABLE idCard ADD CONSTRAINT fk_idCard_personId FOREIGN KEY(personId) REFERENCES person(id); */


/* 第三种方式通过 中间表来建立关系， */
CREATE TABLE person_card (
	personId int not null,
	cardId int not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';

/* 添加联合唯一性约束 */
 ALTER TABLE person_card ADD CONSTRAINT un_person_card UNIQUE (personId, cardId);
 
 
 
 
 