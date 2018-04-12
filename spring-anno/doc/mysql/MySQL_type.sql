/* MySQL */

/* 创建表 */
DROP TABLE IF EXISTS person_simple_user_type;
CREATE TABLE person_simple_user_type (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	phone varchar(32) COMMENT '手机号码',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表-person_simple_user_type';

/* 添加数据 */
INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('徐明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', '15018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('王洁', null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号', '14013756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('邝边', null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号', '18018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('刘雨', null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号', '13018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('赵备', null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号', '17018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('卡扎尔-龙华', null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号', '13018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('牛芳', null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号', '15018756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('伊尔民', null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号', '15018756239');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('沙尔塔', null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号', '15010756236');

INSERT INTO person_simple_user_type (name, photoUrl, gender, nation, birthday, address, phone) 
VALUES ('郑飞', null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号', '15618756236');

/* 创建表 */
DROP TABLE IF EXISTS person_user_type;
CREATE TABLE person_user_type (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	home_province varchar(32) COMMENT '家庭地址 - 省',
	home_city varchar(32) COMMENT '家庭地址 - 市',
	home_street varchar(64) COMMENT '家庭地址 - 街道',
	home_zipcode varchar(12) COMMENT '家庭地址 - 邮政编码',
	company_province varchar(32) COMMENT '公司地址 - 省',
	company_city varchar(32) COMMENT '公司地址 - 市',
	company_street varchar(64) COMMENT '公司地址 - 街道',
	company_zipcode varchar(12) COMMENT '公司地址 - 邮政编码',	 	 
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员信息表-user_type';

INSERT INTO person_user_type (name, home_province, home_city, home_street, home_zipcode, 
company_province, company_city, company_street, company_zipcode) 
VALUES ('刘雨', '陕西省', '西安市', '西北路104号', '521303', '广东省', '湛江市', '下海路205号', '521365');

INSERT INTO person_user_type (name, home_province, home_city, home_street, home_zipcode, 
company_province, company_city, company_street, company_zipcode) 
VALUES ('牛芳', '江苏省', '苏州市', '南江路89号', '661303', '四川省', '成都市', '天府路463号', '521389');

INSERT INTO person_user_type (name, home_province, home_city, home_street, home_zipcode, 
company_province, company_city, company_street, company_zipcode) 
VALUES ('郑飞', '西藏自治区', '拉萨市', '江北路24号', '771303', '江西省', '上饶市', '青山路19号', '521365');


/* 创建表 */
DROP TABLE IF EXISTS person_composite_user_type;
CREATE TABLE person_composite_user_type (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	firstname varchar(32) COMMENT '姓名-firstname',
	lastname varchar(32) COMMENT '姓名-lastname',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表-composite';

/* 添加数据 */
INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('徐', '明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('王', '洁',  null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('邝', '边',  null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('刘', '雨',  null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('赵', '备',  null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('卡扎尔', '龙华',  null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('牛', '芳',  null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('伊', '尔民',  null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('沙', '尔塔',  null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号');

INSERT INTO person_composite_user_type (firstname, lastname, photoUrl, gender, nation, birthday, address) 
VALUES ('郑', '飞',  null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号');


/* 创建表 */
DROP TABLE IF EXISTS blob_type;
CREATE TABLE blob_type (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	array blob COMMENT 'Byte[] 类型',
	_blob blob COMMENT 'java.sql.Blob 类型',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二进制大对象类型';


/* 创建表 MySQL 以 text 作为 clob类型 */
DROP TABLE IF EXISTS clob_type;
CREATE TABLE clob_type (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	string text COMMENT 'string 类型',
	_clob text COMMENT 'java.sql.Clob 类型',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二进制大对象类型';


