/* MySQL */

/* 若存在先删除 */
DROP TABLE IF EXISTS oid_increment;
/* increment表 */
CREATE TABLE oid_increment (
  `id` int(11) NOT NULL COMMENT '主键-increment',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='increment表';


/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_identify`;
/* identify表 */
CREATE TABLE oid_identify (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identify主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='identify表';

/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_sequence`;
/* sequence表 */
CREATE TABLE oid_identify (
  `id` int(11) NOT NULL COMMENT 'sequence主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='sequence表';

/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_hilo`;
/* 表 */
CREATE TABLE oid_hilo (
  `id` int(11) NOT NULL COMMENT 'hilo主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='hilo表';
/* 若存在先删除 */
DROP TABLE IF EXISTS `hi_value`;
/* 表 */
CREATE TABLE hi_value (
  `next_value` int(11) COMMENT '',
   PRIMARY KEY (`next_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='hi_value表';
INSERT INTO hi_value (next_value) VALUES (1);

/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_native`;
/* 表 */
CREATE TABLE oid_native (
  `id` int(11) not null  AUTO_INCREMENT COMMENT 'native-主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='native-表';

/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_uuid_sex`;
/* 表 */
CREATE TABLE oid_uuid_sex (
  `id` varchar(64) NOT NULL COMMENT 'uuid_sex主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='uuid_sex表';

/* 若存在先删除 */
DROP TABLE IF EXISTS `oid_assigned`;
/* 表 */
CREATE TABLE oid_assigned (
  `id` varchar(64) NOT NULL COMMENT 'assign主键',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='assign表';

/* 若存在先删除 */
DROP TABLE IF EXISTS `MappingCompositeKey`;
/* 映射复合主键表 */
CREATE TABLE MappingCompositeKey (
  `name` varchar(64) NOT NULL COMMENT '姓名',
  companyId varchar(64) NOT NULL COMMENT '企业id',
  address varchar(128) NOT NULL COMMENT '地址',
  UNIQUE(name, companyId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='映射复合主键表';


