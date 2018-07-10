DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_name` varchar(255) NOT NULL	COMMENT '用户名称',
	`password` varchar(255) DEFAULT NULL,
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '登录用户表';

DROP TABLE IF EXISTS `lov`;
CREATE TABLE `lov` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`category` varchar(255) NOT NULL	COMMENT '配置类型',
	`lov_code` varchar(255) DEFAULT NULL,
	`lov_value` varchar(255) DEFAULT NULL,
	`parent_code` varchar(255) DEFAULT NULL,
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'lov配置表';


DROP TABLE IF EXISTS `carton_category`;
CREATE TABLE `carton_category` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`carton_big_type` varchar(255) NOT NULL	COMMENT '纸箱大类(eg:卡通箱,床箱,纸片), 存lov_code',
	`carton_small_type` varchar(255) NOT NULL COMMENT '纸箱小类(eg:三层,五层,办公台,中封), 存lov_code',
	`carton_length` DOUBLE(10,3) DEFAULT 0 COMMENT '纸箱长',
	`carton_width` DOUBLE(10,3) DEFAULT 0 COMMENT '纸箱宽',
	`carton_height` DOUBLE(10,3) DEFAULT 0 COMMENT '纸箱高',
	`carton_standard` varchar(255) DEFAULT NULL COMMENT '材料规格',
	`critical_standard` varchar(255) DEFAULT NULL COMMENT '压线规格',
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '纸箱种类尺寸维护表';

DROP TABLE IF EXISTS `carton_stock`;
CREATE TABLE `carton_stock` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL	COMMENT '库存名称',
	`carton_category_id` int(11) NOT NULL	COMMENT '纸箱种类主键',
	`stock` int(11) DEFAULT 0 COMMENT '总库存数',
	`stock_left` int(11) DEFAULT 0 COMMENT '剩余库存数',
	`cost_price` DOUBLE(10,3) DEFAULT 0 COMMENT '成本单价',
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '纸箱库存表';

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL	COMMENT '客户名称',
	`gender` int(1) DEFAULT NULL COMMENT '性别',
	`birthday` varchar(50) DEFAULT NULL COMMENT '生日',
	`address` varchar(100) DEFAULT NULL COMMENT '住址',
	`phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
	`hobby` varchar(500) DEFAULT NULL COMMENT '爱好',
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '客户维护表';

DROP TABLE IF EXISTS `carton_order`;
CREATE TABLE `carton_order` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`carton_stock_id` varchar(255) NOT NULL	COMMENT '下单纸箱',
	`amount` int(11) NOT NULL COMMENT '下单数量',
	`sales_price` DOUBLE(10,3) DEFAULT 0 COMMENT '销售单价',
	`publish_date` datetime DEFAULT NULL COMMENT '交货日期',
	`comment` varchar(2000) DEFAULT NULL COMMENT '备注',
	`create_date` datetime DEFAULT NULL,
	`create_user` varchar(255) DEFAULT NULL,
	`update_date` datetime DEFAULT NULL,
	`update_user` varchar(255) DEFAULT NULL,
	`valid` int(1) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '纸箱下单表';