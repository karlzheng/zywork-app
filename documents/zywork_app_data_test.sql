/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : zywork_app

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 26/01/2019 12:24:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_account_detail`;
CREATE TABLE `t_account_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账目编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `integral` bigint(20) DEFAULT NULL COMMENT '积分',
  `type` tinyint(4) DEFAULT NULL COMMENT '收入或支出',
  `sub_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '收支类型',
  `pay_type` tinyint(4) DEFAULT NULL COMMENT '支付方式',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户账目明细表';

-- ----------------------------
-- Records of t_account_detail
-- ----------------------------
BEGIN;
INSERT INTO `t_account_detail` VALUES (1, 31, -50, NULL, 1, '提现', NULL, 1, '2018-12-25 23:24:19', NULL, 0);
INSERT INTO `t_account_detail` VALUES (2, 31, -50, NULL, 1, '提现', NULL, 1, '2018-12-26 17:39:45', NULL, 0);
INSERT INTO `t_account_detail` VALUES (3, 31, 500, NULL, 0, '人工充值', NULL, 1, '2018-12-26 17:42:32', NULL, 0);
INSERT INTO `t_account_detail` VALUES (4, 31, -100, NULL, 1, '转出', NULL, 1, '2019-01-06 20:56:44', NULL, 0);
INSERT INTO `t_account_detail` VALUES (5, 36, 100, NULL, 0, '转入', NULL, 1, '2019-01-06 20:56:44', NULL, 0);
INSERT INTO `t_account_detail` VALUES (6, 31, -100, NULL, 1, '转出', NULL, 1, '2019-01-15 20:51:44', NULL, 0);
INSERT INTO `t_account_detail` VALUES (7, 36, 100, NULL, 0, '转入', NULL, 1, '2019-01-15 20:51:44', NULL, 0);
INSERT INTO `t_account_detail` VALUES (8, 31, -10, NULL, 1, '消费', 3, 1, '2019-01-15 22:23:31', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_frezee
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_frezee`;
CREATE TABLE `t_funds_frezee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `frezee_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `frezee_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户资金冻结与解冻记录表';

-- ----------------------------
-- Table structure for t_funds_recharge
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_recharge`;
CREATE TABLE `t_funds_recharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '充值金额',
  `recharge_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '充值类型',
  `is_success` tinyint(4) DEFAULT '0' COMMENT '是否成功',
  `out_trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商户订单号',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付系统订单号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户资金充值记录表';

-- ----------------------------
-- Records of t_funds_recharge
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_recharge` VALUES (1, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 13:06:57', NULL, 0);
INSERT INTO `t_funds_recharge` VALUES (2, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 13:08:11', NULL, 0);
INSERT INTO `t_funds_recharge` VALUES (3, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 14:06:48', NULL, 0);
INSERT INTO `t_funds_recharge` VALUES (4, 31, 500, '人工充值', 0, NULL, NULL, 1, '2018-12-26 17:42:32', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_transfer`;
CREATE TABLE `t_funds_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转账编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `from_user_id` bigint(20) DEFAULT NULL COMMENT 'FROM',
  `to_user_id` bigint(20) DEFAULT NULL COMMENT 'TO',
  `transfer_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `transfer_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户资金转入与转出记录表';

-- ----------------------------
-- Records of t_funds_transfer
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_transfer` VALUES (1, 31, 100, NULL, 36, '转出', NULL, 1, '2019-01-06 20:56:44', NULL, 0);
INSERT INTO `t_funds_transfer` VALUES (2, 36, 100, 31, NULL, '转入', NULL, 1, '2019-01-06 20:56:44', NULL, 0);
INSERT INTO `t_funds_transfer` VALUES (3, 31, 100, NULL, 36, '转出', NULL, 1, '2019-01-15 20:51:44', NULL, 0);
INSERT INTO `t_funds_transfer` VALUES (4, 36, 100, 31, NULL, '转入', NULL, 1, '2019-01-15 20:51:44', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw`;
CREATE TABLE `t_funds_withdraw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `withdraw_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '提现单号',
  `amount` bigint(20) NOT NULL COMMENT '提现金额',
  `bankcard_id` bigint(20) NOT NULL COMMENT '提现银行卡',
  `withdraw_status` tinyint(4) DEFAULT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime DEFAULT NULL COMMENT '审核时间',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户资金提现记录表';

-- ----------------------------
-- Records of t_funds_withdraw
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_withdraw` VALUES (5, 31, '3ea854cde3b842338cc7a0fb3fd49bcb', 100, 1, 2, '不能提现', 31, '2018-12-23 18:47:53', '2018-12-23 18:47:53', 1, '2018-12-23 18:43:49', '2018-12-23 18:47:53', 0);
INSERT INTO `t_funds_withdraw` VALUES (6, 31, '77d07a5d6d2b4a7280e9ecff229d4888', 100, 1, 4, NULL, 31, '2018-12-23 20:56:16', '2018-12-23 21:05:20', 1, '2018-12-23 18:49:38', '2018-12-23 21:05:20', 0);
INSERT INTO `t_funds_withdraw` VALUES (7, 31, '399a929dc59a48f0af9498a534252792', 100, 1, 4, NULL, 31, '2018-12-25 15:04:57', '2018-12-25 15:22:34', 4, '2018-12-23 22:25:54', '2018-12-25 15:22:34', 0);
INSERT INTO `t_funds_withdraw` VALUES (8, 31, 'b84bdc6156554a27a57229faa361d6a4', 50, 1, 4, NULL, NULL, NULL, '2018-12-25 23:24:19', 2, '2018-12-25 18:22:14', '2018-12-25 23:24:19', 0);
INSERT INTO `t_funds_withdraw` VALUES (12, 31, '2a5e0e09c3084e6ebee0dd36a6f3acc7', 100, 1, 1, '审核通过', 31, '2019-01-15 18:06:19', NULL, 6, '2018-12-26 17:36:15', '2019-01-15 18:06:19', 0);
INSERT INTO `t_funds_withdraw` VALUES (13, 31, 'ef011bfb3ee94b6bb978f8fee2023177', 50, 1, 4, NULL, 31, '2018-12-26 17:39:26', '2018-12-26 17:39:45', 3, '2018-12-26 17:38:45', '2018-12-26 17:39:45', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_withdraw_check
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw_check`;
CREATE TABLE `t_funds_withdraw_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现审核编号',
  `withdraw_id` bigint(20) NOT NULL COMMENT '提现编号',
  `withdraw_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '提现单号',
  `withdraw_status` tinyint(4) NOT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) NOT NULL COMMENT '审核人编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户资金提现审核历史表';

-- ----------------------------
-- Records of t_funds_withdraw_check
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_withdraw_check` VALUES (14, 12, '2a5e0e09c3084e6ebee0dd36a6f3acc7', 1, '审核通过', 31, 1, '2019-01-14 20:50:02', NULL, 0);
INSERT INTO `t_funds_withdraw_check` VALUES (15, 12, '2a5e0e09c3084e6ebee0dd36a6f3acc7', 1, NULL, 31, 1, '2019-01-15 18:06:19', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute`;
CREATE TABLE `t_goods_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性编号',
  `attr_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `attr_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性代码',
  `attr_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据类型',
  `attr_length` int(11) NOT NULL COMMENT '数据长度',
  `attr_display` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否前端显示',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品属性信息表';

-- ----------------------------
-- Table structure for t_goods_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_value`;
CREATE TABLE `t_goods_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性值编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性代码',
  `attr_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品SKU属性及属性值表';

-- ----------------------------
-- Table structure for t_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='购物车信息记录表';

-- ----------------------------
-- Table structure for t_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类目描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品类目信息表';

-- ----------------------------
-- Table structure for t_goods_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category_attribute`;
CREATE TABLE `t_goods_category_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目属性编号',
  `category_id` bigint(20) NOT NULL COMMENT '商品类目编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_order` int(11) NOT NULL COMMENT '属性排序',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品类目属性信息表';

-- ----------------------------
-- Table structure for t_goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment`;
CREATE TABLE `t_goods_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品评论编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `comments` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论详情',
  `append_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '追加评论',
  `reply` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '回复详情',
  `stick_status` tinyint(4) DEFAULT '0' COMMENT '置顶状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评论表';

-- ----------------------------
-- Table structure for t_goods_comment_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment_pic`;
CREATE TABLE `t_goods_comment_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论图片编号',
  `comment_id` bigint(20) NOT NULL COMMENT '评论编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评论图片表';

-- ----------------------------
-- Table structure for t_goods_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_coupon`;
CREATE TABLE `t_goods_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠券编号',
  `category_id` bigint(20) DEFAULT NULL COMMENT '商品类目编号',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) DEFAULT NULL COMMENT '商品SKU编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '优惠券标题',
  `use_min_amount` bigint(20) DEFAULT NULL COMMENT '最小消费金额',
  `discount_amount` bigint(20) DEFAULT NULL COMMENT '满减优惠金额',
  `discount_percent` double(3,0) DEFAULT NULL COMMENT '满减折扣',
  `integral_amount` int(11) DEFAULT NULL COMMENT '赠送积分',
  `total_count` int(11) NOT NULL COMMENT '优惠券总量',
  `coupon_usable_range` tinyint(4) NOT NULL COMMENT '优惠券使用范围',
  `coupon_type` tinyint(4) NOT NULL COMMENT '优惠券类型',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `due_time` datetime DEFAULT NULL COMMENT '到期时间',
  `valid_days` int(11) DEFAULT NULL COMMENT '有效时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品优惠券信息表';

-- ----------------------------
-- Table structure for t_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_info`;
CREATE TABLE `t_goods_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品记录表，包含多个商品SKU';

-- ----------------------------
-- Table structure for t_goods_intro
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_intro`;
CREATE TABLE `t_goods_intro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图文介绍编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图文介绍',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品图文介绍表';

-- ----------------------------
-- Table structure for t_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order`;
CREATE TABLE `t_goods_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `total_amount` bigint(20) NOT NULL COMMENT '订单金额',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '赠送积分',
  `express_fee` bigint(20) DEFAULT '0' COMMENT '运费',
  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_type` tinyint(4) DEFAULT NULL COMMENT '支付方式',
  `transaction_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付订单号',
  `pay_success` tinyint(4) DEFAULT NULL COMMENT '是否支付成功',
  `deliver_time` datetime DEFAULT NULL COMMENT '发货时间',
  `deal_time` datetime DEFAULT NULL COMMENT '成交时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单信息表，一个订单包含多个订单条目';

-- ----------------------------
-- Table structure for t_goods_order_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_coupon`;
CREATE TABLE `t_goods_order_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用券编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单优惠券使用记录表';

-- ----------------------------
-- Table structure for t_goods_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_item`;
CREATE TABLE `t_goods_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `sku_pic_id` bigint(20) NOT NULL COMMENT 'SKU图片编号',
  `sku_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '售卖标题',
  `sku_info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SKU属性JSON',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL COMMENT '赠送积分',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单详情信息表';

-- ----------------------------
-- Table structure for t_goods_order_logistics
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_logistics`;
CREATE TABLE `t_goods_order_logistics` (
  `id` bigint(20) NOT NULL COMMENT '订单编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_deliver` tinyint(4) DEFAULT '0' COMMENT '是否已发货',
  `logistics_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流公司名称',
  `logistics_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流公司编码',
  `logistics_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '物流单号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单物流信息表';

-- ----------------------------
-- Table structure for t_goods_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_pic`;
CREATE TABLE `t_goods_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品图片编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `pic_order` int(11) NOT NULL COMMENT '图片顺序',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品图片信息表';

-- ----------------------------
-- Table structure for t_goods_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop`;
CREATE TABLE `t_goods_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `subject_type` tinyint(4) NOT NULL COMMENT '主体类型',
  `logo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺Logo',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺标题',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺简介',
  `level` tinyint(4) DEFAULT '1' COMMENT '店铺等级',
  `check_status` tinyint(4) DEFAULT NULL COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime DEFAULT NULL COMMENT '审核时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='店铺信息表';

-- ----------------------------
-- Table structure for t_goods_shop_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_certification`;
CREATE TABLE `t_goods_shop_certification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺认证编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `detail` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '认证详情JSON',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='店铺认证信息表';

-- ----------------------------
-- Table structure for t_goods_shop_check
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_check`;
CREATE TABLE `t_goods_shop_check` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺审核编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `check_status` tinyint(4) DEFAULT '0' COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) DEFAULT NULL COMMENT '审核人编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='店铺审核历史表';

-- ----------------------------
-- Table structure for t_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'SKU编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `shelf_status` tinyint(4) NOT NULL COMMENT '上架状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品SKU信息表';

-- ----------------------------
-- Table structure for t_goods_sku_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku_pic`;
CREATE TABLE `t_goods_sku_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'SKU图片编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `pic_id` bigint(20) NOT NULL COMMENT '商品图片编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品SKU图片信息表';

-- ----------------------------
-- Table structure for t_goods_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_user_coupon`;
CREATE TABLE `t_goods_user_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `coupon_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '优惠券状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品优惠券用户领券信息表';

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消息摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
  `message_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '消息类型',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='消息记录表';

-- ----------------------------
-- Records of t_message
-- ----------------------------
BEGIN;
INSERT INTO `t_message` VALUES (1, 'zywork-app体验版发布', NULL, 'zywork-app体验版于2019-01-22晚上10点45分正式发布，邀请您使用！', '', 2, '2019-01-24 16:19:13', '2019-01-24 16:19:40', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统模块表';

-- ----------------------------
-- Records of t_module
-- ----------------------------
BEGIN;
INSERT INTO `t_module` VALUES (1, '测试模块', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (2, '模块管理', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (3, '权限管理', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (4, '角色管理', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (5, '模块权限查询模块', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (6, '角色权限管理', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (7, '系统配置管理', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_module` VALUES (8, '系统日志管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (9, '组织部门管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (10, '用户组织部门查询模块', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (11, '用户管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (12, '用户角色管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (13, '用户详情管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (14, '用户第三方登录管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (15, '用户钱包管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (16, '用户银行卡管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (17, '充值管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (18, '提现管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (19, '转账管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (20, '用户收货地址管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (21, '用户账目详情管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (22, '分销查询模块', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (23, '消息管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (24, '消息查询模块', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (25, '公告管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (26, '角色权限导入导出管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (27, 'Redis缓存管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (28, '定时任务管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (29, 'DAU管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_module` VALUES (30, '用户统计管理', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公告摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `end_time` datetime DEFAULT NULL COMMENT '截止时间',
  `stick_status` tinyint(4) DEFAULT '0' COMMENT '置顶状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统公告表';

-- ----------------------------
-- Records of t_notice
-- ----------------------------
BEGIN;
INSERT INTO `t_notice` VALUES (1, '公告标题', '公告摘要', '公告内容', '2019-01-08 20:00:00', 1, 1, '2019-01-07 00:12:44', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '组织名称',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组织描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='组织或部门表';

-- ----------------------------
-- Records of t_organization
-- ----------------------------
BEGIN;
INSERT INTO `t_organization` VALUES (1, 0, '赣州智悦科技有限公司', NULL, 1, '2019-01-24 16:15:02', NULL, 0);
INSERT INTO `t_organization` VALUES (2, 1, '研发部', NULL, 1, '2019-01-24 16:15:13', NULL, 0);
INSERT INTO `t_organization` VALUES (3, 1, '市场部', NULL, 1, '2019-01-24 16:15:27', NULL, 0);
INSERT INTO `t_organization` VALUES (4, 2, '后端组', NULL, 1, '2019-01-26 09:59:02', NULL, 0);
INSERT INTO `t_organization` VALUES (5, 2, '前端组', NULL, 1, '2019-01-26 10:04:42', NULL, 0);
INSERT INTO `t_organization` VALUES (8, 2, '运维组', NULL, 1, '2019-01-26 10:37:52', NULL, 0);
INSERT INTO `t_organization` VALUES (12, 2, '测试组', NULL, 1, '2019-01-26 10:47:41', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `module_id` bigint(20) NOT NULL COMMENT '所属模块',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标题',
  `permission` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, 1, '测试添加', '/test/add', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (2, 1, '测试修改', '/test/edit', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (3, 1, '测试删除', '/test/remove/*', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (4, 1, '测试文件上传', '/test/upload', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (5, 2, '后台-模块管理', '/module/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (6, 2, '演示-模块管理-查询单个', '/module/admin/one/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (7, 2, '演示-模块管理-查询所有', '/module/admin/all', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (8, 2, '演示-模块管理-分页查询', '/module/admin/pager-cond', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (9, 3, '后台-权限管理', '/permission/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (10, 3, '演示-权限管理-查询单个', '/permission/admin/one/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (11, 3, '演示-权限管理-查询所有', '/permission/admin/all', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (12, 3, '演示-权限管理-分页查询', '/permission/admin/pager-cond', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (13, 4, '后台-角色管理', '/role/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (14, 4, '演示-角色管理-查询单个', '/role/admin/one/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (15, 4, '演示-角色管理-查询所有', '/role/admin/all', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (16, 4, '演示-角色管理-分页查询', '/role/admin/pager-cond', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (17, 5, '后台-模块权限查询', '/module-permission/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (18, 5, '用户-模块权限查询', '/module-permission/user/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (19, 5, '演示-模块权限查询-查询单个', '/module-permission/admin/multi/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (20, 5, '演示-模块权限查询-查询所有', '/module-permission/admin/all', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (21, 5, '演示-模块权限查询-分页查询', '/module-permission/admin/pager-cond', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (22, 6, '后台-角色权限管理', '/role-permission/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (23, 6, '演示-角色权限管理-查询单个', '/role-permission/admin/multi/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (24, 6, '演示-角色权限管理-查询所有', '/role-permission/admin/all', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (25, 6, '演示-角色权限管理-分页查询', '/role-permission/admin/pager-cond', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (26, 7, '后台-系统配置管理', '/sys-config/admin/**', NULL, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_permission` VALUES (27, 7, '演示-系统配置管理-查询单个', '/sys-config/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (28, 7, '演示-系统配置管理-查询所有', '/sys-config/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (29, 7, '演示-系统配置管理-分页查询', '/sys-config/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (30, 8, '后台-系统日志管理', '/sys-log/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (31, 8, '演示-系统日志管理-查询单个', '/sys-log/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (32, 8, '演示-系统日志管理-查询所有', '/sys-log/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (33, 8, '演示-系统日志管理-分页查询', '/sys-log/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (34, 9, '后台-组织机构管理', '/organization/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (35, 9, '演示-组织部门管理-查询单个', '/organization/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (36, 9, '演示-组织部门管理-查询所有', '/organization/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (37, 9, '演示-组织部门管理-条件查询所有', '/organization/admin/all-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (38, 9, '演示-组织部门管理-分页查询', '/organization/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (39, 10, '后台-用户组织部门查询', '/user-organization/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (40, 10, '用户-用户组织部门查询', '/user-organization/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (41, 10, '演示-用户组织部门查询-查询单个', '/user-organization/admin/multi/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (42, 10, '演示-用户组织部门查询-查询所有', '/user-organization/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (43, 10, '演示-用户组织部门查询-分页查询', '/user-organization/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (44, 11, '后台-用户管理', '/user/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (45, 11, '演示-用户管理-查询单个', '/user/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (46, 11, '演示-用户管理-查询所有', '/user/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (47, 11, '演示-用户管理-分页查询', '/user/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (48, 12, '后台-用户角色查询', '/user-role/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (49, 12, '用户-用户角色查询', '/user-role/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (50, 12, '演示-用户角色查询-查询单个', '/user-role/admin/multi/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (51, 12, '演示-用户角色查询-查询所有', '/user-role/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (52, 12, '演示-用户角色查询-分页查询', '/user-role/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (53, 13, '后台-用户详情查询', '/user-userdetail/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (54, 13, '用户-用户详情查询', '/user-userdetail/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (55, 13, '演示-用户详情查询', '/user-userdetail/user/get', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (56, 13, '演示-用户详情查询-查询单个', '/user-userdetail/admin/multi/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (57, 13, '演示-用户详情查询-查询所有', '/user-userdetail/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (58, 13, '演示-用户详情查询-分页查询', '/user-userdetail/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (59, 14, '后台-用户第三方登录管理', '/user-usersocial/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (60, 14, '演示-用户第三方登录管理-查询单个', '/user-usersocial/admin/multi/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (61, 14, '演示-用户第三方登录管理-查询所有', '/user-usersocial/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (62, 14, '演示-用户第三方登录管理-分页查询', '/user-usersocial/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (63, 15, '后台-用户钱包管理', '/user-wallet/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (64, 15, '演示-用户钱包管理-查询单个', '/user-wallet/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (65, 15, '演示-用户钱包管理-查询所有', '/user-wallet/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (66, 15, '演示-用户钱包管理-分页查询', '/user-wallet/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (67, 16, '后台-用户银行卡管理', '/user-bankcard/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (68, 16, '用户-用户银行卡管理', '/user-bankcard/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (69, 16, '演示-用户银行卡管理-查询单个', '/user-bankcard/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (70, 16, '演示-用户银行卡管理-查询所有', '/user-bankcard/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (71, 16, '演示-用户银行卡管理-分页查询', '/user-bankcard/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (72, 17, '后台-系统人工充值', '/user-recharge/admin/human', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (73, 18, '后台-提现管理', '/withdraw/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (74, 18, '用户-提现管理', '/withdraw/user/*', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (75, 19, '用户-转账操作', '/transfer/user/*', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (76, 20, '后台-用户收货地址管理', '/shipping-address/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (77, 20, '用户-用户收货地址管理', '/shipping-address/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (78, 20, '演示-用户收货地址管理-查询单个', '/shipping-address/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (79, 20, '演示-用户收货地址管理-查询所有', '/shipping-address/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (80, 20, '演示-用户收货地址管理-分页查询', '/shipping-address/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (81, 21, '后台-用户账目详情管理', '/accoundetail/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (82, 21, '演示-用户账目详情管理-查询单个', '/accoundetail/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (83, 21, '演示-用户账目详情管理-查询所有', '/accoundetail/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (84, 21, '演示-用户账目详情管理-分页查询', '/accoundetail/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (85, 22, '后台-分销查询', '/distribution/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (86, 22, '用户-分销查询', '/distribution/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (87, 23, '后台-消息管理', '/message/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (88, 23, '演示-消息管理-查询单个', '/message/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (89, 23, '演示-消息管理-查询所有', '/message/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (90, 23, '演示-消息管理-分页查询', '/message/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (91, 24, '后台-消息查询', '/user-message/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (92, 24, '用户-消息查询', '/user-message/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (93, 25, '后台-公告管理', '/notice/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (94, 25, '用户-公告查询', '/notice/user/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (95, 25, '演示-公告查询-查询单个', '/notice/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (96, 25, '演示-公告查询-查询所有', '/notice/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (97, 25, '演示-公告查询-分页查询', '/notice/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (98, 26, '后台-导入导出角色权限', '/permission-import-export/*', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (99, 27, '后台-Redis缓存管理', '/redis-manage/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (100, 27, '演示-Redis缓存管理-查询keys', '/redis-manage/keys', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (101, 27, '演示-Redis缓存管理-获取keys个数', '/redis-manage/keys-count', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (102, 27, '演示-Redis缓存管理-获取Redis信息', '/redis-manage/info', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (103, 28, '后台-定时任务管理', '/scheduler/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (104, 28, '演示-定时任务管理-查询单个', '/scheduler/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (105, 28, '演示-定时任务管理-查询所有', '/scheduler/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (106, 28, '演示-定时任务管理-分页查询', '/scheduler/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (107, 28, '演示-定时任务管理-获取任务类', '/scheduler/admin/job-classes', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (108, 29, '后台-DAU管理', '/statistics-dau/admin/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (109, 29, '演示-DAU管理-查询单个', '/statistics-dau/admin/one/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (110, 29, '演示-DAU管理-查询所有', '/statistics-dau/admin/all', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (111, 29, '演示-DAU管理-分页查询', '/statistics-dau/admin/pager-cond', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (112, 30, '后台-用户统计管理', '/user-liveness-stat/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_permission` VALUES (113, 30, '演示-用户统计管理', '/user-liveness-stat/**', NULL, 1, '2019-01-25 23:12:26', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_process
-- ----------------------------
DROP TABLE IF EXISTS `t_process`;
CREATE TABLE `t_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程编号',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程标题',
  `file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程文件路径',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '流程描述',
  `is_deploy` tinyint(4) DEFAULT '0' COMMENT '是否部署',
  `deploy_time` datetime DEFAULT NULL COMMENT '部署时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='流程信息表';

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `is_default` tinyint(4) DEFAULT '0' COMMENT '是否默认角色',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'super_sys_admin', '超级系统管理员', 0, 3, '2019-01-20 13:07:37', '2019-01-23 18:14:57', 0);
INSERT INTO `t_role` VALUES (2, 'sys_admin', '系统管理员', 0, 1, '2019-01-20 13:07:37', NULL, 0);
INSERT INTO `t_role` VALUES (3, 'sys_dev', '系统研发人员', 0, 1, '2019-01-20 13:07:37', NULL, 0);
INSERT INTO `t_role` VALUES (4, 'sys_user_demo', '系统演示用户', 0, 1, '2019-01-20 13:07:37', NULL, 0);
INSERT INTO `t_role` VALUES (5, 'sys_user', '系统用户', 1, 1, '2019-01-20 13:07:37', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_role_permission` VALUES (1, 1, 1, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (2, 5, 1, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (3, 2, 1, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (4, 1, 2, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (5, 5, 2, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (6, 2, 2, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (7, 5, 3, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (8, 1, 4, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (9, 2, 4, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (10, 5, 4, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (11, 1, 5, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (12, 2, 5, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (13, 4, 6, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (14, 4, 7, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (15, 4, 8, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (16, 1, 9, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (17, 2, 9, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (18, 4, 10, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (19, 4, 11, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (20, 4, 12, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (21, 1, 13, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (22, 2, 13, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (23, 4, 14, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (24, 4, 15, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (25, 4, 16, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (26, 1, 17, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (27, 2, 17, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (28, 1, 18, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (29, 2, 18, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (30, 5, 18, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (31, 4, 19, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (32, 4, 20, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (33, 4, 21, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (34, 1, 22, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (35, 2, 22, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (36, 4, 23, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (37, 4, 24, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (38, 4, 25, 1, '2019-01-25 23:12:25', NULL, 0);
INSERT INTO `t_role_permission` VALUES (39, 1, 26, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (40, 2, 26, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (41, 4, 27, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (42, 4, 28, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (43, 4, 29, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (44, 1, 30, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (45, 2, 30, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (46, 4, 31, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (47, 4, 32, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (48, 4, 33, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (49, 1, 34, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (50, 2, 34, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (51, 4, 35, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (52, 4, 36, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (53, 4, 37, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (54, 4, 38, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (55, 1, 39, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (56, 2, 39, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (57, 1, 40, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (58, 2, 40, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (59, 5, 40, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (60, 4, 41, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (61, 4, 42, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (62, 4, 43, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (63, 1, 44, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (64, 2, 44, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (65, 4, 45, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (66, 4, 46, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (67, 4, 47, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (68, 1, 48, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (69, 2, 48, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (70, 1, 49, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (71, 2, 49, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (72, 5, 49, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (73, 4, 50, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (74, 4, 51, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (75, 4, 52, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (76, 1, 53, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (77, 2, 53, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (78, 1, 54, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (79, 2, 54, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (80, 5, 54, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (81, 4, 55, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (82, 4, 56, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (83, 4, 57, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (84, 4, 58, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (85, 1, 59, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (86, 2, 59, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (87, 4, 60, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (88, 4, 61, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (89, 4, 62, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (90, 1, 63, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (91, 2, 63, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (92, 4, 64, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (93, 4, 65, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (94, 4, 66, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (95, 1, 67, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (96, 2, 67, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (97, 1, 68, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (98, 2, 68, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (99, 5, 68, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (100, 4, 69, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (101, 4, 70, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (102, 4, 71, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (103, 1, 72, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (104, 2, 72, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (105, 1, 73, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (106, 2, 73, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (107, 1, 74, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (108, 2, 74, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (109, 5, 74, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (110, 1, 75, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (111, 2, 75, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (112, 5, 75, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (113, 1, 76, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (114, 2, 76, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (115, 1, 77, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (116, 2, 77, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (117, 5, 77, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (118, 4, 78, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (119, 4, 79, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (120, 4, 80, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (121, 1, 81, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (122, 2, 81, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (123, 4, 82, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (124, 4, 83, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (125, 4, 84, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (126, 1, 85, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (127, 2, 85, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (128, 4, 85, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (129, 1, 86, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (130, 2, 86, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (131, 5, 86, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (132, 1, 87, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (133, 2, 87, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (134, 4, 88, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (135, 4, 89, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (136, 4, 90, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (137, 1, 91, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (138, 2, 91, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (139, 4, 91, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (140, 1, 92, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (141, 2, 92, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (142, 5, 92, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (143, 4, 92, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (144, 1, 93, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (145, 2, 93, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (146, 1, 94, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (147, 2, 94, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (148, 5, 94, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (149, 4, 95, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (150, 4, 96, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (151, 4, 97, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (152, 1, 98, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (153, 2, 98, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (154, 3, 98, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (155, 1, 99, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (156, 2, 99, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (157, 3, 99, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (158, 4, 100, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (159, 4, 101, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (160, 4, 102, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (161, 1, 103, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (162, 2, 103, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (163, 3, 103, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (164, 4, 104, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (165, 4, 105, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (166, 4, 106, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (167, 4, 107, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (168, 1, 108, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (169, 2, 108, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (170, 4, 109, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (171, 4, 110, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (172, 4, 111, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (173, 1, 112, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (174, 2, 112, 1, '2019-01-25 23:12:26', NULL, 0);
INSERT INTO `t_role_permission` VALUES (175, 4, 113, 1, '2019-01-25 23:12:26', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `t_scheduler`;
CREATE TABLE `t_scheduler` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业名称',
  `class_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '完整类名',
  `cron_expression` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `group_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业组名称',
  `trigger_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '触发器名称',
  `trigger_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '触发器组',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业描述',
  `job_status` tinyint(4) DEFAULT '0' COMMENT '作业状态',
  `job_status_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '状态更新时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='作业调度表';

-- ----------------------------
-- Records of t_scheduler
-- ----------------------------
BEGIN;
INSERT INTO `t_scheduler` VALUES (1, 'DauSaveJob', 'top.zywork.job.DauSaveJob', '0/10 * * * * ?', 'job_group', 'trigger_name', 'trigger_group', NULL, 2, '2019-01-25 10:51:05', 17, '2019-01-18 17:34:42', '2019-01-25 10:51:04', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `t_shipping_address`;
CREATE TABLE `t_shipping_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_default` tinyint(4) DEFAULT '0' COMMENT '是否默认',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户收货地址表';

-- ----------------------------
-- Records of t_shipping_address
-- ----------------------------
BEGIN;
INSERT INTO `t_shipping_address` VALUES (1, 31, '王振宇', '18888888888', '江西省', '赣州市', '章贡区', '**路', 1, 3, '2019-01-03 19:49:26', '2019-01-03 21:29:50', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_statistics_dau
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_dau`;
CREATE TABLE `t_statistics_dau` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'DAU编号',
  `dau` bigint(20) NOT NULL COMMENT 'DAU',
  `statistics_time` datetime NOT NULL COMMENT '统计时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='日活用户统计表';

-- ----------------------------
-- Records of t_statistics_dau
-- ----------------------------
BEGIN;
INSERT INTO `t_statistics_dau` VALUES (68, 2, '2019-01-18 17:42:00', 1, '2019-01-18 17:43:00', NULL, 0);
INSERT INTO `t_statistics_dau` VALUES (69, 16, '2019-01-25 10:47:40', 1, '2019-01-25 10:48:40', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_statistics_day
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_day`;
CREATE TABLE `t_statistics_day` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日期编号',
  `the_date` datetime NOT NULL COMMENT '日期字符串',
  `am_pm` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上午或下午',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用于数据统计的日期信息';

-- ----------------------------
-- Records of t_statistics_day
-- ----------------------------
BEGIN;
INSERT INTO `t_statistics_day` VALUES (1, '2019-01-01 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (2, '2019-01-01 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (3, '2019-01-02 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (4, '2019-01-02 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (5, '2019-01-03 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (6, '2019-01-03 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (7, '2019-01-04 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (8, '2019-01-04 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (9, '2019-01-05 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (10, '2019-01-05 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (11, '2019-01-06 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (12, '2019-01-06 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (13, '2019-01-07 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (14, '2019-01-07 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (15, '2019-01-08 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (16, '2019-01-08 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (17, '2019-01-09 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (18, '2019-01-09 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (19, '2019-01-10 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (20, '2019-01-10 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (21, '2019-01-11 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (22, '2019-01-11 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (23, '2019-01-12 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (24, '2019-01-12 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (25, '2019-01-13 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (26, '2019-01-13 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (27, '2019-01-14 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (28, '2019-01-14 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (29, '2019-01-15 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (30, '2019-01-15 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (31, '2019-01-16 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (32, '2019-01-16 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (33, '2019-01-17 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (34, '2019-01-17 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (35, '2019-01-18 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (36, '2019-01-18 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (37, '2019-01-19 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (38, '2019-01-19 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (39, '2019-01-20 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (40, '2019-01-20 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (41, '2019-01-21 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (42, '2019-01-21 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (43, '2019-01-22 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (44, '2019-01-22 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (45, '2019-01-23 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (46, '2019-01-23 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (47, '2019-01-24 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (48, '2019-01-24 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (49, '2019-01-25 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (50, '2019-01-25 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (51, '2019-01-26 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (52, '2019-01-26 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (53, '2019-01-27 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (54, '2019-01-27 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (55, '2019-01-28 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (56, '2019-01-28 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (57, '2019-01-29 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (58, '2019-01-29 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (59, '2019-01-30 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (60, '2019-01-30 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (61, '2019-01-31 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (62, '2019-01-31 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (63, '2019-02-01 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (64, '2019-02-01 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (65, '2019-02-02 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (66, '2019-02-02 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (67, '2019-02-03 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (68, '2019-02-03 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (69, '2019-02-04 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (70, '2019-02-04 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (71, '2019-02-05 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (72, '2019-02-05 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (73, '2019-02-06 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (74, '2019-02-06 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (75, '2019-02-07 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (76, '2019-02-07 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (77, '2019-02-08 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (78, '2019-02-08 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (79, '2019-02-09 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (80, '2019-02-09 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (81, '2019-02-10 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (82, '2019-02-10 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (83, '2019-02-11 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (84, '2019-02-11 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (85, '2019-02-12 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (86, '2019-02-12 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (87, '2019-02-13 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (88, '2019-02-13 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (89, '2019-02-14 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (90, '2019-02-14 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (91, '2019-02-15 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (92, '2019-02-15 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (93, '2019-02-16 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (94, '2019-02-16 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (95, '2019-02-17 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (96, '2019-02-17 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (97, '2019-02-18 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (98, '2019-02-18 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (99, '2019-02-19 00:00:00', 'am', 1, '2019-01-19 19:48:17', NULL, 0);
INSERT INTO `t_statistics_day` VALUES (100, '2019-02-19 00:00:00', 'pm', 1, '2019-01-19 19:48:17', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置名称',
  `value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置内容(JSON)',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '中文说明',
  `comment` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配置注释',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统配置表，以JSON格式记录常用配置，如阿里云，微信等';

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_config` VALUES (1, 'aliyun_sms_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\",\n  \"signName\": \"signName\"\n}', '阿里云短信', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\",\n  \"signName\": \"短信签名\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (2, 'aliyun_mail_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\"\n}', '阿里云邮件推送', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (3, 'weixin_gzh_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"loginRedirectUrl\": \"\"\n}', '微信公众号', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"loginRedirectUrl\": \"服务器端登录回调接口地址\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (4, 'weixin_xcx_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\"\n}', '微信小程序', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (5, 'wx_pay_config', '{\n  \"mchId\": \"mchId\",\n  \"apiSecret\": \"apiSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"payNotifyUrl\": \"/byjc/tickeorder/result\"\n}', '微信支付', '{\n  \"mchId\": \"商户ID\",\n  \"apiSecret\": \"商户API密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"payNotifyUrl\": \"服务器端支付通知接口\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (14, 'default_distribution_config', '{\n  \"distributionLevel\": 3,\n  \"profitPercents\": {\n    \"level1\": 3,\n    \"level2\": 5,\n    \"level3\": 8\n  }\n}', '默认分销规则', '{\n  \"distributionLevel\": \"分销级别\",\n  \"profitPercents\": {\n    \"level1\": \"一级分销返佣比例\",\n    \"level2\": \"二级分销返佣比例\",\n    \"level3\": \"三级分销返佣比例\"\n  }\n}', 1, '2018-12-28 15:31:12', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `user_account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户账号',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行说明',
  `user_agent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'User-Agent',
  `request_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求URL',
  `request_method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求参数',
  `response_code` int(11) DEFAULT NULL COMMENT '响应编码',
  `response_msg` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应消息',
  `execute_class` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '完整类名',
  `execute_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
  `execute_time` datetime DEFAULT NULL COMMENT '开始执行时间',
  `execute_cost_time` bigint(20) DEFAULT NULL COMMENT '执行耗时(ms)',
  `has_exception` tinyint(4) DEFAULT '0' COMMENT '是否异常',
  `exception_msg` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '异常消息',
  `execute_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IP地址',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_log` VALUES (1, 1, '13672297775', '用户编辑', NULL, 'http://localhost:8088/test/edit', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'edit', '2018-12-18 15:28:26', 13, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:28:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (2, 1, '13672297775', '用户编辑', NULL, 'http://localhost:8088/test/edit', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'edit', '2018-12-18 15:32:31', 7, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:32:30', NULL, 0);
INSERT INTO `t_sys_log` VALUES (3, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:32:35', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:32:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (4, 1, '847315251@qq.com', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:33:31', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:33:30', NULL, 0);
INSERT INTO `t_sys_log` VALUES (5, 1, '13672297775', '用户删除', NULL, 'http://localhost:8088/test/remove/100', 'GET', '[\"100\"]', 1001, '成功', 'top.zywork.controller.TestController', 'remove', '2018-12-18 15:35:36', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:35:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (6, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:44:56', 17629, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:45:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (7, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:47:33', 4, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 15:47:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (8, 1, '847315251@qq.com', '用户添加', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 17:08:51', 12, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-18 17:08:51', NULL, 0);
INSERT INTO `t_sys_log` VALUES (9, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:46', 17, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:05:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (10, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:55', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:05:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (11, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:57', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:05:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (12, NULL, NULL, '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 13:06:30', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:06:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (13, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:06:45', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:06:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (14, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:09:16', 21380, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:09:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (15, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:12:21', 17, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:12:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (16, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:22', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:13:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (17, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456ABC\",null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:37', 1, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:13:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (18, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",null]', 1003, '密码和确认密码不一致', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:49', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:13:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (19, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:57', 137, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:13:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (20, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:17:16', 25277, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:17:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (21, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"\\\"\\\"\",\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:17:30', 8401, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'password\' not found. Available parameters are [oldPassword, userId, param1, param2]', '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:17:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (22, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\" \",\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:20:02', 132058, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'password\' not found. Available parameters are [oldPassword, userId, param1, param2]', '0:0:0:0:0:0:0:1', 1, '2018-12-22 13:20:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (23, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:40:38', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 14:40:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (24, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:40:54', 13, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 14:40:53', NULL, 0);
INSERT INTO `t_sys_log` VALUES (25, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:41:22', 141, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 14:41:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (26, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:50:29', 363448, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 14:50:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (27, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:57:40', 371360, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 14:57:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (28, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1001, '登录密码更新成功', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:07:13', 294, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:07:13', NULL, 0);
INSERT INTO `t_sys_log` VALUES (29, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abcg\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:07:47', 136, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:07:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (30, 26, 'testcc@126.com', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"testAbc123\",\"testAbc123\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:11:08', 11, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:11:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (31, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:11:23', 2, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:11:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (32, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:12:41', 156, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:12:40', NULL, 0);
INSERT INTO `t_sys_log` VALUES (33, 26, 'testcc@126.com', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"testAbc123\",\"testAbc123\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:12:45', 125, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:12:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (34, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:48:33', 165, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:48:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (35, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:53:52', 25, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:53:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (36, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:54:06', 3, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:54:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (37, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:38', 179, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:55:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (38, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:38', 179, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:55:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (39, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:40', 4, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:55:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (40, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[\"1234Abc\",\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:47', 302, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-22 15:55:47', NULL, 0);
INSERT INTO `t_sys_log` VALUES (41, NULL, NULL, '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[31,134]', 1001, '充值成功', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-23 13:06:58', 106, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 13:06:57', NULL, 0);
INSERT INTO `t_sys_log` VALUES (42, NULL, NULL, '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[31,134]', 1001, '充值成功', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-23 13:08:11', 107, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 13:08:11', NULL, 0);
INSERT INTO `t_sys_log` VALUES (43, NULL, NULL, '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[35,134]', 1003, '不存在的用户编号', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-23 14:06:37', 24, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 14:06:36', NULL, 0);
INSERT INTO `t_sys_log` VALUES (44, NULL, NULL, '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[36,134]', 1003, '不存在的用户编号', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-23 14:06:43', 2, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 14:06:42', NULL, 0);
INSERT INTO `t_sys_log` VALUES (45, NULL, NULL, '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[31,134]', 1001, '充值成功', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-23 14:06:49', 50, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 14:06:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (46, NULL, NULL, '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[120]', 1005, '未认证的用户', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:26:45', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:26:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (47, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[0]', 1003, '提现金额必须大于0', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:27:48', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:27:47', NULL, 0);
INSERT INTO `t_sys_log` VALUES (48, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[-2]', 1003, '提现金额必须大于0', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:27:53', 3, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:27:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (49, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[null]', 1003, '必须填写提现金额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:27:56', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:27:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (50, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[900]', 1003, '提现金额必须小于等于可用余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:28:02', 2, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:28:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (51, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:28:15', 106, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:28:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (52, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 15:34:39', 153, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 15:34:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (53, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[250]', 1003, '提现金额与所有未完成的提交金额之和必须小于可用余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:25:42', 49, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:25:41', NULL, 0);
INSERT INTO `t_sys_log` VALUES (54, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[250]', 1003, '提现金额与所有未完成的提交金额之和必须小于可用余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:27:29', 34, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:27:28', NULL, 0);
INSERT INTO `t_sys_log` VALUES (55, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:27:56', 43, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:27:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (56, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[105]', 1003, '提现金额与所有未完成的提交金额之和必须小于可用余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:28:00', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:28:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (57, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[0]', 1003, '提现金额必须大于0', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:28:52', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:28:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (58, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', 1003, '提现金额与所有未完成的提交金额之和必须小于可用余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:28:56', 5, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:28:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (59, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:42:14', 7, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:42:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (60, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:44:31', 15, 1, 'top.zywork.dos.UserWalletDO cannot be cast to top.zywork.dto.UserWalletDTO', '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:44:31', NULL, 0);
INSERT INTO `t_sys_log` VALUES (61, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:44:34', 4, 1, 'top.zywork.dos.UserWalletDO cannot be cast to top.zywork.dto.UserWalletDTO', '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:44:33', NULL, 0);
INSERT INTO `t_sys_log` VALUES (62, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', 1003, '提现金额必须小于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:46:28', 20, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:46:28', NULL, 0);
INSERT INTO `t_sys_log` VALUES (63, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[200]', 1003, '提现金额必须小于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:46:34', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:46:34', NULL, 0);
INSERT INTO `t_sys_log` VALUES (64, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[103]', 1003, '提现金额必须小于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 16:46:40', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 16:46:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (65, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[1,2,\"时间未到，不能提现\"]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 17:11:36', 149, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 17:11:36', NULL, 0);
INSERT INTO `t_sys_log` VALUES (66, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[2,1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 17:12:31', 77, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 17:12:31', NULL, 0);
INSERT INTO `t_sys_log` VALUES (67, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[1,2,\"暂不能提现\"]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 17:19:17', 124, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 17:19:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (68, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[500]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 17:19:38', 10, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 17:19:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (69, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[2,1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 17:19:54', 14, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 17:19:53', NULL, 0);
INSERT INTO `t_sys_log` VALUES (70, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[500,null]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:34:22', 33, 1, 'Mapper method \'top.zywork.dao.UserWithdrawDAO.getTotalUncompleteWithdraw attempted to return null from a method with a primitive return type (long).', '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:34:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (71, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[500,null]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:39:50', 20, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:39:50', NULL, 0);
INSERT INTO `t_sys_log` VALUES (72, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,null]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:39:57', 44, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:39:57', NULL, 0);
INSERT INTO `t_sys_log` VALUES (73, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[500,1]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:43:33', 16, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:43:33', NULL, 0);
INSERT INTO `t_sys_log` VALUES (74, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:43:49', 81, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:43:49', NULL, 0);
INSERT INTO `t_sys_log` VALUES (75, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"3ea854cde3b842338cc7a0fb3fd49bcb\",2,\"不能提现\"]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 18:47:54', 69, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:47:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (76, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[500,1]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:49:25', 13, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:49:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (77, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 18:49:39', 78, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 18:49:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (78, NULL, NULL, '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[null,null]', 1003, '请选择正确的提现单号和审核状态，3成功，4失败', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 19:23:47', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 19:23:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (79, NULL, NULL, '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1001, '已人工完成提现操作，提现SUCCESS', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 19:24:18', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 19:24:17', NULL, 0);
INSERT INTO `t_sys_log` VALUES (80, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",4]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:23:12', 14, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:23:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (81, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"3ea854cde3b842338cc7a0fb3fd49bcb\",4]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:23:38', 4, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:23:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (82, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 20:24:06', 97, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:24:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (83, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",1,null]', 1003, '提现单号不正确或提现申请不是审核中状态', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 20:56:02', 53, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:56:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (84, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-23 20:56:17', 95, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:56:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (85, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",4]', 1001, '已人工完成提现操作，提现失败', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:56:42', 76, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:56:41', NULL, 0);
INSERT INTO `t_sys_log` VALUES (86, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",5]', 1003, '请选择正确的提现单号和审核状态，3成功，4失败', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:57:07', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:57:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (87, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:57:13', 20, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:57:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (88, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 20:59:25', 26, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 20:59:24', NULL, 0);
INSERT INTO `t_sys_log` VALUES (89, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 21:00:38', 53032, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 21:00:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (90, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 21:04:42', 34, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 21:04:41', NULL, 0);
INSERT INTO `t_sys_log` VALUES (91, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"77d07a5d6d2b4a7280e9ecff229d4888\",3]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-23 21:05:26', 10541, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 21:05:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (92, 31, '13672297775', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', NULL, 1001, '登录密码更新成功', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-23 22:04:15', 314, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:04:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (93, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1,\"afd\"]', 1003, '支付密码错误', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 22:25:33', 176, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:25:33', NULL, 0);
INSERT INTO `t_sys_log` VALUES (94, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1,\"1234Abc\"]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 22:25:55', 225, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:25:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (95, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1,\"1234Abcd\"]', 1003, '支付密码错误', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 22:26:01', 140, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:26:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (96, 31, '13672297775', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', NULL, 1001, '登录密码更新成功', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-23 22:26:36', 291, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:26:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (97, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', NULL, 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-23 22:26:53', 323, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:26:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (98, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[100,1,\"1234Abc\"]', 1003, '支付密码错误', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-23 22:27:00', 121, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-23 22:27:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (99, NULL, NULL, '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 13:42:27', 24, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 13:42:27', NULL, 0);
INSERT INTO `t_sys_log` VALUES (100, NULL, NULL, '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 13:46:10', 115203, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 13:46:10', NULL, 0);
INSERT INTO `t_sys_log` VALUES (101, NULL, NULL, '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 13:46:23', 9133, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 13:46:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (102, NULL, NULL, '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 13:49:44', 168406, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 13:49:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (103, NULL, NULL, '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null,null]', 1005, '未认证的用户', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:12:46', 10, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:12:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (104, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[null,null]', 1003, '填写正确的姓名和银行卡号', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:12:58', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:12:57', NULL, 0);
INSERT INTO `t_sys_log` VALUES (105, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"在地愿为连理枝\"]', 1003, '填写正确的姓名和银行卡号', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:13:10', 1, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:13:10', NULL, 0);
INSERT INTO `t_sys_log` VALUES (106, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402266\"]', 1003, '填写正确的姓名和银行卡号', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:13:26', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:13:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (107, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402265\"]', 1001, '已绑定银行卡', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:13:32', 536, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:13:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (108, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402265\"]', 1001, '已绑定银行卡', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:36:21', 293, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:36:20', NULL, 0);
INSERT INTO `t_sys_log` VALUES (109, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"621\"]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:37:48', 82, 1, '服务异常', '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:37:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (110, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"621\"]', NULL, NULL, 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:42:13', 172789, 1, '服务异常', '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:42:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (111, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"621\"]', 1001, '已解除绑定银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:42:35', 218, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:42:34', NULL, 0);
INSERT INTO `t_sys_log` VALUES (112, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402265\"]', 1001, '已绑定银行卡', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:49:32', 521, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:49:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (113, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402265\"]', 1001, '已绑定银行卡', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 14:49:51', 247, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:49:51', NULL, 0);
INSERT INTO `t_sys_log` VALUES (114, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[5]', 1003, '不存在的银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:50:38', 2, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:50:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (115, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[4]', 1003, '错误的银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:50:46', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:50:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (116, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[3]', 1001, '已解除绑定银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 14:50:52', 50, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 14:50:51', NULL, 0);
INSERT INTO `t_sys_log` VALUES (117, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"62179065\"]', 1003, '填写正确的姓名和银行卡号', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 15:29:32', 12, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 15:29:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (118, 31, '13672297775', '绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/bind', 'POST', '[\"王\",\"6217906500006402265\"]', 1003, '不能再次绑定已绑定的银行卡', 'top.zywork.controller.UserBankcardController', 'bindBankcard', '2018-12-24 15:29:42', 485, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 15:29:41', NULL, 0);
INSERT INTO `t_sys_log` VALUES (119, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"87897984\"]', 1003, '不存在的银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 15:30:07', 2, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 15:30:06', NULL, 0);
INSERT INTO `t_sys_log` VALUES (120, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"6217906500006402265\"]', 1003, '银行卡不属于此用户', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 15:33:07', 24, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 15:33:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (121, 31, '13672297775', '解除绑定银行卡', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-bankcard/unbind', 'POST', '[\"6217906500006402265\"]', 1001, '已解除绑定银行卡', 'top.zywork.controller.UserBankcardController', 'unbindBankcard', '2018-12-24 15:33:18', 70, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 15:33:18', NULL, 0);
INSERT INTO `t_sys_log` VALUES (122, NULL, NULL, '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"111\"]', 1005, '未认证的用户', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:06:01', 11, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:06:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (123, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"111\"]', 1003, '提现单号不正确或提现申请不是审核中状态', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:06:13', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:06:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (124, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"3ea854cde3b842338cc7a0fb3fd49bcb\"]', 1003, '提现单号不正确或提现申请不是审核中状态', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:06:25', 7, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:06:24', NULL, 0);
INSERT INTO `t_sys_log` VALUES (125, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1003, '提现单号不属于此用户', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:06:52', 3, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:06:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (126, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1001, '已取消提现', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:07:03', 7, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:07:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (127, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1001, '已取消提现', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:09:22', 200, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:09:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (128, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1003, '提现单号不正确或提现申请不是审核中状态', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-24 17:09:32', 3, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-24 17:09:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (129, NULL, NULL, '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",1,null]', 1005, '未认证的用户', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 14:57:16', 10, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 14:57:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (130, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",1,null]', 1003, '数据版本号有问题，在审核前数据已被更新', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 14:57:45', 21, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 14:57:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (131, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",1,null]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 15:02:17', 64, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'newVersion\' not found. Available parameters are [param5, withdrawNo, checkedUserId, description, param3, withdrawStatus, param4, version, param1, param2]', '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:02:17', NULL, 0);
INSERT INTO `t_sys_log` VALUES (132, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",1,null]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 15:03:55', 47, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'newVersion\' not found. Available parameters are [param5, withdrawNo, checkedUserId, description, param3, withdrawStatus, param4, version, param1, param2]', '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:03:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (133, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 15:04:58', 55, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:04:57', NULL, 0);
INSERT INTO `t_sys_log` VALUES (134, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4,null]', 1003, '审核状态错误，1通过，2未通过', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-25 15:11:11', 10, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:11:11', NULL, 0);
INSERT INTO `t_sys_log` VALUES (135, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:12:13', 38301, 1, '/ by zero', '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:12:13', NULL, 0);
INSERT INTO `t_sys_log` VALUES (136, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:13:46', 12613, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:13:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (137, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:14:06', 3, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:14:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (138, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', 1003, '数据版本号有问题，在完成提现前数据已被更新', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:14:49', 23593, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:14:49', NULL, 0);
INSERT INTO `t_sys_log` VALUES (139, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', 1003, '提现单号不正确或提现申请不是已通过状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:22:06', 40, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:22:06', NULL, 0);
INSERT INTO `t_sys_log` VALUES (140, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"399a929dc59a48f0af9498a534252792\",4]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 15:23:00', 28941, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 15:23:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (141, NULL, NULL, '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1005, '未认证的用户', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-25 18:15:16', 9, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:15:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (142, NULL, NULL, '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1005, '未认证的用户', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-25 18:17:12', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:17:11', NULL, 0);
INSERT INTO `t_sys_log` VALUES (143, 31, '13672297775', '取消提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/cancel', 'POST', '[\"399a929dc59a48f0af9498a534252792\"]', 1003, '提现单号不正确或提现申请不是审核中状态', 'top.zywork.controller.UserWithdrawController', 'cancelWithdraw', '2018-12-25 18:17:24', 17, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:17:23', NULL, 0);
INSERT INTO `t_sys_log` VALUES (144, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:18:01', 49, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:18:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (145, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:21:13', 26, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:21:13', NULL, 0);
INSERT INTO `t_sys_log` VALUES (146, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:22:00', 6, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:22:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (147, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:22:02', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:22:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (148, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,\"劳动厅\"]', 1003, '支付密码错误', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:22:05', 147, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:22:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (149, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,\"123456Abc\"]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:22:14', 208, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:22:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (150, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:02', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (151, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:02', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (152, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:03', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (153, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:03', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (154, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:03', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (155, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:05', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:04', NULL, 0);
INSERT INTO `t_sys_log` VALUES (156, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:06', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (157, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:06', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:06', NULL, 0);
INSERT INTO `t_sys_log` VALUES (158, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:06', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:06', NULL, 0);
INSERT INTO `t_sys_log` VALUES (159, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:06', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:06', NULL, 0);
INSERT INTO `t_sys_log` VALUES (160, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:07', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (161, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:07', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (162, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:07', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (163, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:08', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (164, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:09', 1, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (165, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:10', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:09', NULL, 0);
INSERT INTO `t_sys_log` VALUES (166, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,null]', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-25 18:25:32', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 18:25:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (167, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"b84bdc6156554a27a57229faa361d6a4\",4]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 23:21:08', 61, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 23:21:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (168, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"b84bdc6156554a27a57229faa361d6a4\",4]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 23:22:01', 32, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 23:22:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (169, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"b84bdc6156554a27a57229faa361d6a4\",4]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 23:23:01', 29635, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 23:23:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (170, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"b84bdc6156554a27a57229faa361d6a4\",4]', NULL, NULL, 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 23:23:46', 36800, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 23:23:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (171, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"b84bdc6156554a27a57229faa361d6a4\",4]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-25 23:24:20', 103, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-25 23:24:19', NULL, 0);
INSERT INTO `t_sys_log` VALUES (172, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[20,1,\"123456Abc\"]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-26 17:36:15', 234, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:36:15', NULL, 0);
INSERT INTO `t_sys_log` VALUES (173, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[55,1,\"123456Abc\"]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-26 17:37:06', 145, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:37:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (174, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[50,1,\"123456Abc\"]', 1001, '提现申请提交成功', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-26 17:38:45', 232, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:38:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (175, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/submit', 'POST', '[3,1,\"123456Abc\"]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2018-12-26 17:38:50', 142, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:38:50', NULL, 0);
INSERT INTO `t_sys_log` VALUES (176, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"ef011bfb3ee94b6bb978f8fee2023177\",4,null]', 1003, '审核状态错误，1通过，2未通过', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-26 17:39:20', 2, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:39:20', NULL, 0);
INSERT INTO `t_sys_log` VALUES (177, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/check', 'POST', '[\"ef011bfb3ee94b6bb978f8fee2023177\",1,null]', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2018-12-26 17:39:27', 85, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:39:26', NULL, 0);
INSERT INTO `t_sys_log` VALUES (178, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"ef011bfb3ee94b6bb978f8fee2023177\",4]', 1001, '已人工完成提现操作，提现成功', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2018-12-26 17:39:46', 44, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:39:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (179, 31, '13672297775', '系统人工充值', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-recharge/human', 'POST', '[31,500]', 1001, '充值成功', 'top.zywork.controller.UserRechargeController', 'rechargeByHuman', '2018-12-26 17:42:32', 110, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-26 17:42:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (180, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, NULL, NULL, 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 11:48:47', 37, 1, 'java.lang.Integer cannot be cast to java.lang.String', '0:0:0:0:0:0:0:1', 1, '2018-12-28 11:48:47', NULL, 0);
INSERT INTO `t_sys_log` VALUES (181, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, NULL, NULL, 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 11:52:54', 121806, 1, 'java.lang.Integer cannot be cast to java.lang.String', '0:0:0:0:0:0:0:1', 1, '2018-12-28 11:52:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (182, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, NULL, NULL, 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 11:53:14', 15206, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-28 11:53:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (183, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, NULL, NULL, 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 11:53:29', 6267, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-28 11:53:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (184, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, NULL, NULL, 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 11:53:39', 6087, 1, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-28 11:53:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (185, NULL, NULL, '用户手机注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg-mobile', 'POST', NULL, 1001, '注册成功', 'top.zywork.controller.AuthController', 'regMobile', '2018-12-28 12:00:37', 337, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2018-12-28 12:00:36', NULL, 0);
INSERT INTO `t_sys_log` VALUES (186, NULL, NULL, '导入角色', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-role', 'POST', NULL, NULL, NULL, 'top.zywork.controller.PermissionImportExportController', 'importRoles', '2019-01-04 11:21:47', 121, 1, 'syntax error, expect {, actual [, pos 0, fastjson-version 1.2.51', '0:0:0:0:0:0:0:1', 1, '2019-01-04 11:21:47', NULL, 0);
INSERT INTO `t_sys_log` VALUES (187, NULL, NULL, '导入角色', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-role', 'POST', NULL, 1001, '成功导入角色信息', 'top.zywork.controller.PermissionImportExportController', 'importRoles', '2019-01-04 11:31:49', 240, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-04 11:31:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (188, NULL, NULL, '导出权限', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-permission', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportPermissions', '2019-01-04 14:50:02', 137, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-04 14:50:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (189, NULL, NULL, '导入权限', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-04 14:52:44', 130, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-04 14:52:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (190, NULL, NULL, '导出权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-permission', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportPermissions', '2019-01-04 15:17:49', 192, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-04 15:17:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (191, NULL, NULL, '导出权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-permission', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportPermissions', '2019-01-04 15:48:28', 68, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-04 15:48:27', NULL, 0);
INSERT INTO `t_sys_log` VALUES (192, NULL, NULL, '导出权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-permission', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportPermissions', '2019-01-05 11:17:35', 251, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-05 11:17:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (193, NULL, NULL, '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-05 11:18:01', 1024, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-05 11:18:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (194, NULL, NULL, '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-05 11:18:10', 274, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-05 11:18:09', NULL, 0);
INSERT INTO `t_sys_log` VALUES (195, NULL, NULL, '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-05 11:23:49', 589, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-05 11:23:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (196, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-05 18:44:09', 749, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-05 18:44:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (197, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-06 13:24:25', 715, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 13:24:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (198, 31, '13672297775', '人工完成提现操作', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/confirm-human', 'POST', '[\"111\",1]', 1003, '请选择正确的提现单号和审核状态', 'top.zywork.controller.UserWithdrawController', 'confirmWithdrawHuman', '2019-01-06 14:01:13', 10, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 14:01:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (199, NULL, NULL, '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1005, '未认证的用户', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:52:50', 8, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:52:50', NULL, 0);
INSERT INTO `t_sys_log` VALUES (200, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '必须填写转账金额，支付密码', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:53:29', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:53:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (201, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '必须填写转账金额，支付密码', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:53:39', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:53:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (202, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '对方账户填写错误', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:53:46', 157, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:53:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (203, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '对方账户填写错误', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:54:52', 155, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:54:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (204, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, NULL, NULL, 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:55:32', 479, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'transerType\' not found. Available parameters are [amount, transferType, param3, userId, toUserId, param4, param1, param2]', '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:55:31', NULL, 0);
INSERT INTO `t_sys_log` VALUES (205, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '转账金额必须小于等于可转账余额', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:56:32', 222, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:56:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (206, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1001, '转账成功', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 20:56:45', 249, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 20:56:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (207, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/user-transfer/trans', 'POST', NULL, 1003, '转账金额必须小于等于可转账余额', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-06 21:01:40', 164, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 21:01:40', NULL, 0);
INSERT INTO `t_sys_log` VALUES (208, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/user/submit', 'POST', '[500,1,\"123456Abc\"]', 1003, '提现金额必须小于等于可提现余额', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2019-01-06 21:04:40', 175, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-06 21:04:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (214, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/user/submit', 'POST', '{}', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2019-01-08 18:32:42', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-08 18:35:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (215, 31, '13672297775', '提交提现申请', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/user/submit', 'POST', '{\"amount\":10}', 1003, '必须填写提现金额、支付密码，并选择提现银行卡', 'top.zywork.controller.UserWithdrawController', 'submitWithdraw', '2019-01-08 18:35:56', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-08 18:36:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (216, NULL, NULL, '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-10 15:41:39', 891, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-10 15:41:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (217, NULL, NULL, '微信公众号登录', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/wx-auth/gzh', 'GET', NULL, 1003, '微信授权登录缺少code', 'top.zywork.controller.WeixinAuthController', 'gzhAuth', '2019-01-11 18:17:13', 28, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-11 18:17:12', NULL, 0);
INSERT INTO `t_sys_log` VALUES (218, NULL, NULL, '微信公众号登录', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/wx-auth/gzh', 'GET', NULL, 1003, '微信授权登录缺少code', 'top.zywork.controller.WeixinAuthController', 'gzhAuth', '2019-01-11 18:17:16', 0, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-11 18:17:15', NULL, 0);
INSERT INTO `t_sys_log` VALUES (239, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/admin/check', 'POST', '{\"withdrawNo\":\"2a5e0e09c3084e6ebee0dd36a6f3acc7\",\"description\":\"审核通过\",\"withdrawStatus\":1}', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2019-01-14 20:50:03', 73, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-14 20:50:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (240, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/admin/check', 'POST', '{\"withdrawNo\":\"2a5e0e09c3084e6ebee0dd36a6f3acc7\",\"withdrawStatus\":1}', 1003, '可用余额不足，请检查用户可用余额是否大于等于提现金额，或数据版本号有问题，在审核前提现记录已被更新', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2019-01-15 18:06:00', 61, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-15 18:06:00', NULL, 0);
INSERT INTO `t_sys_log` VALUES (241, 31, '13672297775', '提现申请审核', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/withdraw/admin/check', 'POST', '{\"withdrawNo\":\"2a5e0e09c3084e6ebee0dd36a6f3acc7\",\"withdrawStatus\":1}', 1001, '审核成功', 'top.zywork.controller.UserWithdrawController', 'checkWithdraw', '2019-01-15 18:06:20', 41, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-15 18:06:19', NULL, 0);
INSERT INTO `t_sys_log` VALUES (242, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/transfer/user/trans', 'POST', NULL, 1003, '对方账户填写错误', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-15 20:51:04', 206, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-15 20:51:03', NULL, 0);
INSERT INTO `t_sys_log` VALUES (243, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/transfer/user/trans', 'POST', NULL, 1003, '转账金额必须小于等于可转账余额', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-15 20:51:33', 174, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-15 20:51:33', NULL, 0);
INSERT INTO `t_sys_log` VALUES (244, 31, '13672297775', '用户转账', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/transfer/user/trans', 'POST', NULL, 1001, '转账成功', 'top.zywork.controller.UserTransferController', 'transfer', '2019-01-15 20:51:45', 259, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-15 20:51:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (245, NULL, NULL, '用户邮箱注册', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/auth/reg', 'POST', NULL, 1001, '注册成功', 'top.zywork.controller.AuthController', 'reg', '2019-01-17 10:30:22', 256, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-17 10:30:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (246, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-17 10:33:28', 1228, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-17 10:33:28', NULL, 0);
INSERT INTO `t_sys_log` VALUES (247, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-17 15:09:04', 1231, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-17 15:09:03', NULL, 0);
INSERT INTO `t_sys_log` VALUES (248, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, NULL, NULL, 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-18 18:25:46', 1508, 1, '\n### Error updating database.  Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n### The error may involve top.zywork.dao.RolePermissionDAO.saveBatch-Inline\n### The error occurred while setting parameters\n### SQL: insert into t_role_permission              ( permission_id )               values ( ? )           ;              insert into t_role_permission              ( role_id,                                                       permission_id )               values ( ?,                                                       ? )\n### Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n; Field \'role_id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'role_id\' doesn\'t have a default value', '0:0:0:0:0:0:0:1', 1, '2019-01-18 18:25:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (249, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-18 18:26:59', 847, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-18 18:26:59', NULL, 0);
INSERT INTO `t_sys_log` VALUES (250, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, NULL, NULL, 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 21:34:29', 1684, 1, '\n### Error updating database.  Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n### The error may involve top.zywork.dao.RolePermissionDAO.saveBatch-Inline\n### The error occurred while setting parameters\n### SQL: insert into t_role_permission              ( permission_id )               values ( ? )           ;              insert into t_role_permission              ( role_id,                                                       permission_id )               values ( ?,                                                       ? )           ;              insert into t_role_permission              ( permission_id )               values ( ? )\n### Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n; Field \'role_id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'role_id\' doesn\'t have a default value', '0:0:0:0:0:0:0:1', 1, '2019-01-19 21:34:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (251, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, NULL, NULL, 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 21:36:32', 604, 1, '\n### Error updating database.  Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n### The error may involve top.zywork.dao.RolePermissionDAO.saveBatch-Inline\n### The error occurred while setting parameters\n### SQL: insert into t_role_permission              ( permission_id )               values ( ? )           ;              insert into t_role_permission              ( role_id,                                                       permission_id )               values ( ?,                                                       ? )\n### Cause: java.sql.SQLException: Field \'role_id\' doesn\'t have a default value\n; Field \'role_id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'role_id\' doesn\'t have a default value', '0:0:0:0:0:0:0:1', 1, '2019-01-19 21:36:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (252, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 21:38:04', 677, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-19 21:38:03', NULL, 0);
INSERT INTO `t_sys_log` VALUES (253, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 23:38:56', 1057, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-19 23:38:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (254, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 23:41:17', 665, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-19 23:41:17', NULL, 0);
INSERT INTO `t_sys_log` VALUES (255, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 23:48:47', 706, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-19 23:48:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (256, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-19 23:53:07', 665, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-19 23:53:07', NULL, 0);
INSERT INTO `t_sys_log` VALUES (257, 31, '13672297775', '导出角色信息', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-roles', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportRoles', '2019-01-20 12:53:09', 23, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-20 12:53:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (258, 31, '13672297775', '导出角色信息', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/export-roles', 'GET', NULL, 0, '', 'top.zywork.controller.PermissionImportExportController', 'exportRoles', '2019-01-20 12:57:15', 25, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-20 12:57:14', NULL, 0);
INSERT INTO `t_sys_log` VALUES (259, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-20 13:06:21', 1798, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-20 13:06:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (260, 31, '13672297775', '导入角色', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-role', 'POST', NULL, 1001, '成功导入角色信息', 'top.zywork.controller.PermissionImportExportController', 'importRoles', '2019-01-20 13:07:38', 91, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-20 13:07:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (261, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-20 13:09:36', 822, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-20 13:09:36', NULL, 0);
INSERT INTO `t_sys_log` VALUES (262, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-24 13:33:55', 1489, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-24 13:33:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (263, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-24 16:10:55', 1554, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-24 16:10:55', NULL, 0);
INSERT INTO `t_sys_log` VALUES (264, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-24 18:30:25', 1359, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-24 18:30:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (265, 31, '13672297775', '导入权限配置', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/permission-import-export/import-permission', 'POST', NULL, 1001, '成功导入权限配置信息', 'top.zywork.controller.PermissionImportExportController', 'importPermissions', '2019-01-25 23:12:27', 1680, 0, NULL, '0:0:0:0:0:0:0:1', 1, '2019-01-25 23:12:26', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密盐值',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13672297776', '123456@qq.com', '$2a$10$wok8Kiq3/wCM2uGqGSiFGeYeP9oZ7lKLgmSPXpy9mrkiEg2kWzIe2', NULL, 1, '2018-12-07 18:50:51', NULL, 0);
INSERT INTO `t_user` VALUES (2, NULL, 'wgs@126.com', '$2a$10$NRBlx5wTAV5j6yt3ocqOJuSEI760KmUrvtaP/QcsIsKXLLWNzsyq2', NULL, 1, '2018-12-12 16:29:31', NULL, 0);
INSERT INTO `t_user` VALUES (4, '13366666666', 'abc@126.com', '$2a$10$xWTNNu3RfrJqnhItrD0cGexQb1vZyfnQxTl/Y5CrHp89HbpKmIYcC', NULL, 8, '2018-12-12 16:31:39', '2019-01-19 23:01:03', 0);
INSERT INTO `t_user` VALUES (19, NULL, NULL, '$2a$10$3d/ps2pQ2RQ3Xe4TzpOu7u97m14kUkZVBwHLsjNnw555TrlYNOXF2', NULL, 1, '2018-12-12 17:34:50', NULL, 0);
INSERT INTO `t_user` VALUES (20, NULL, NULL, '$2a$10$SeDwW9A7ft0kgSLgBN698OsKQeY9Sqmf6w5RhXIqeYCXXsUPXRONm', NULL, 1, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user` VALUES (21, NULL, NULL, '$2a$10$ePlfOylmN6DOa0KlkZmtq.4So7dXNimMqHBEdNzrVJLzGMbRg6G7O', NULL, 1, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user` VALUES (22, NULL, 'wggss@126.com', '$2a$10$FeqZqJIQPIAuR5fWM9VDOeDVoYI9AMXK//C1GIRqbTbYNM6LhUIYO', NULL, 1, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user` VALUES (23, '18888888899', NULL, '$2a$10$fb/Yu2tx71cs1AbrVfXjWuJn4Hyhprj5r6biD0d0cXfjFHQ8sGvKK', NULL, 1, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user` VALUES (24, NULL, NULL, '$2a$10$NHv4sQCfTLRg9teU4GG3oOTSoQMcGJ8N2ZM2tJhTHX0jwCU5fEBxO', NULL, 1, '2018-12-18 12:30:27', NULL, 0);
INSERT INTO `t_user` VALUES (26, NULL, 'testcc@126.com', '$2a$10$mMdC9tAosEr5jHXP9ZU4XemA5zbfoJ/lCNwjenVWZ0Vi2A8YiwX0O', NULL, 1, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user` VALUES (27, '13666666666', NULL, NULL, NULL, 1, '2018-12-22 13:41:53', NULL, 0);
INSERT INTO `t_user` VALUES (28, '15888888888', NULL, NULL, NULL, 1, '2018-12-22 13:42:57', NULL, 0);
INSERT INTO `t_user` VALUES (29, '18888888886', NULL, NULL, NULL, 1, '2018-12-22 13:43:59', NULL, 0);
INSERT INTO `t_user` VALUES (31, '13672297775', NULL, '$2a$10$7YNSwyW.FfL2iPBOqSEnD.8fNnM65QjumF2CD3glyQb9zdQBzXSr2', NULL, 1, '2018-12-22 15:46:43', NULL, 0);
INSERT INTO `t_user` VALUES (36, '13999999999', NULL, '$2a$10$yNU6CqmtHfJYeyO5zziOT.u3vgFNhSnz0/qy8Zadh4BfRgFFoV1na', NULL, 1, '2018-12-28 12:00:36', NULL, 0);
INSERT INTO `t_user` VALUES (37, '', NULL, NULL, NULL, 1, '2019-01-07 19:23:49', NULL, 0);
INSERT INTO `t_user` VALUES (38, '', NULL, NULL, NULL, 1, '2019-01-07 19:28:25', NULL, 0);
INSERT INTO `t_user` VALUES (40, '', 'demo@zywork.top', '$2a$10$BxzUB3PvmEX9VqZIfIvsf.V4ltLJY9fF06GFX.J.d.3SFOApnFBm2', NULL, 1, '2019-01-17 10:30:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_bankcard
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bankcard`;
CREATE TABLE `t_user_bankcard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `account_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '持卡人姓名',
  `bank_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '银行代码',
  `bank_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行名称',
  `bankcard_no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户银行卡记录表';

-- ----------------------------
-- Table structure for t_user_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_user_certification`;
CREATE TABLE `t_user_certification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '认证编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `identity` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `real_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `valid_date` date DEFAULT NULL COMMENT '身份证有效期',
  `idcard_front` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证正面',
  `idcard_reverse` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证反面',
  `idcard_hand` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手持身份证',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户实名认证表';

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail` (
  `id` bigint(20) NOT NULL COMMENT '用户编号',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `headicon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `gender` tinyint(4) DEFAULT '0' COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'QQ号',
  `qq_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'QQ二维码',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信号',
  `wechat_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信二维码',
  `alipay` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付宝账号',
  `alipay_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付宝二维码',
  `share_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分享码',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户扩展信息表';

-- ----------------------------
-- Records of t_user_detail
-- ----------------------------
BEGIN;
INSERT INTO `t_user_detail` VALUES (19, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_detail` VALUES (20, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_detail` VALUES (21, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_detail` VALUES (24, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_detail` VALUES (26, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8V4txJ', 1, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user_detail` VALUES (31, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'nxrLRk', 1, '2018-12-22 15:46:43', NULL, 0);
INSERT INTO `t_user_detail` VALUES (36, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '62TNSs', 1, '2018-12-28 12:00:36', NULL, 0);
INSERT INTO `t_user_detail` VALUES (37, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'frBh72', 1, '2019-01-07 19:23:49', NULL, 0);
INSERT INTO `t_user_detail` VALUES (38, 'nickname', 'headicon', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'mxvMT2', 1, '2019-01-07 19:28:25', NULL, 0);
INSERT INTO `t_user_detail` VALUES (40, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'h345CG', 1, '2019-01-17 10:30:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_hierarchy
-- ----------------------------
DROP TABLE IF EXISTS `t_user_hierarchy`;
CREATE TABLE `t_user_hierarchy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系编号',
  `ancestor_id` bigint(20) NOT NULL COMMENT '祖先编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_level` int(11) NOT NULL COMMENT '用户级别',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户关系表';

-- ----------------------------
-- Records of t_user_hierarchy
-- ----------------------------
BEGIN;
INSERT INTO `t_user_hierarchy` VALUES (1, 31, 31, 1, 1, '2018-12-28 11:26:11', NULL, 0);
INSERT INTO `t_user_hierarchy` VALUES (2, 31, 36, 2, 1, '2018-12-28 12:00:36', NULL, 0);
INSERT INTO `t_user_hierarchy` VALUES (3, 36, 36, 1, 1, '2018-12-28 12:00:36', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_message
-- ----------------------------
DROP TABLE IF EXISTS `t_user_message`;
CREATE TABLE `t_user_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息发送编号',
  `message_id` bigint(20) NOT NULL COMMENT '消息编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `is_read` tinyint(4) DEFAULT '0' COMMENT '是否已读',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户消息表';

-- ----------------------------
-- Records of t_user_message
-- ----------------------------
BEGIN;
INSERT INTO `t_user_message` VALUES (1, 1, 40, 0, 1, '2019-01-24 16:20:13', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_user_organization`;
CREATE TABLE `t_user_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户组织编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `organization_id` bigint(20) NOT NULL COMMENT '组织编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户组织部门信息表';

-- ----------------------------
-- Records of t_user_organization
-- ----------------------------
BEGIN;
INSERT INTO `t_user_organization` VALUES (1, 31, 2, 1, '2019-01-24 16:16:14', NULL, 0);
INSERT INTO `t_user_organization` VALUES (2, 40, 2, 1, '2019-01-24 16:16:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_path
-- ----------------------------
DROP TABLE IF EXISTS `t_user_path`;
CREATE TABLE `t_user_path` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '路径编号',
  `user_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户路径',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`),
  FULLTEXT KEY `idx_user_path` (`user_path`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户关系路径表';

-- ----------------------------
-- Records of t_user_path
-- ----------------------------
BEGIN;
INSERT INTO `t_user_path` VALUES (1, '31', 1, '2018-12-28 11:26:11', NULL, 0);
INSERT INTO `t_user_path` VALUES (2, '31/36', 1, '2018-12-28 12:00:36', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1, 1, 1, '2018-12-07 19:10:32', NULL, 0);
INSERT INTO `t_user_role` VALUES (2, 1, 2, 1, '2018-12-07 19:10:52', NULL, 0);
INSERT INTO `t_user_role` VALUES (3, 22, 5, 1, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user_role` VALUES (4, 23, 5, 1, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user_role` VALUES (5, 24, 5, 1, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_role` VALUES (6, 26, 5, 1, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user_role` VALUES (7, 31, 1, 1, '2018-12-22 15:46:43', NULL, 0);
INSERT INTO `t_user_role` VALUES (8, 36, 5, 1, '2018-12-28 12:00:36', NULL, 0);
INSERT INTO `t_user_role` VALUES (9, 31, 2, 1, '2019-01-06 13:32:46', NULL, 0);
INSERT INTO `t_user_role` VALUES (10, 37, 5, 1, '2019-01-07 19:23:49', NULL, 0);
INSERT INTO `t_user_role` VALUES (11, 38, 5, 1, '2019-01-07 19:28:25', NULL, 0);
INSERT INTO `t_user_role` VALUES (12, 31, 3, 1, '2019-01-10 15:38:21', NULL, 0);
INSERT INTO `t_user_role` VALUES (13, 40, 4, 1, '2019-01-17 10:30:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_social
-- ----------------------------
DROP TABLE IF EXISTS `t_user_social`;
CREATE TABLE `t_user_social` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '第三方登录编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `openid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'openid',
  `union_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'unionid',
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'AccessToken',
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'SessionKey',
  `refresh_token` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '刷新Token',
  `social_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第三方登录类型',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '第三方登录绑定时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户第三方登录信息表';

-- ----------------------------
-- Records of t_user_social
-- ----------------------------
BEGIN;
INSERT INTO `t_user_social` VALUES (1, 1, '12345678', NULL, NULL, NULL, NULL, '微信公众号', 1, '2018-12-07 18:54:34', NULL, 0);
INSERT INTO `t_user_social` VALUES (2, 19, 'openid', NULL, NULL, NULL, NULL, '微信公众号', 1, '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_social` VALUES (3, 20, 'openid', NULL, NULL, NULL, NULL, '微信公众号', 1, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_social` VALUES (4, 21, 'openid', NULL, NULL, NULL, NULL, '微信公众号', 1, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_social` VALUES (5, 24, 'openid_wechat', NULL, NULL, NULL, NULL, '微信公众号', 1, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_social` VALUES (6, 37, 'openid_wechat', '123456', 'access_token', 'session_key', NULL, '微信小程序', 1, '2019-01-07 19:23:49', NULL, 0);
INSERT INTO `t_user_social` VALUES (7, 38, 'openid_wechat', '123456', 'access_token', 'session_key', NULL, '微信小程序', 1, '2019-01-07 19:28:25', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_wallet`;
CREATE TABLE `t_user_wallet` (
  `id` bigint(20) NOT NULL COMMENT '钱包编号',
  `pay_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '支付密码',
  `rmb_balance` bigint(20) DEFAULT '0' COMMENT '人民币余额',
  `usable_rmb_balance` bigint(20) DEFAULT '0' COMMENT '可用余额',
  `frozen_rmb_balance` bigint(20) DEFAULT '0' COMMENT '冻结余额',
  `integral` bigint(20) DEFAULT '0' COMMENT '总积分',
  `usable_integral` bigint(20) DEFAULT '0' COMMENT '可用积分',
  `frozen_integral` bigint(20) DEFAULT '0' COMMENT '冻结积分',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户钱包表';

-- ----------------------------
-- Records of t_user_wallet
-- ----------------------------
BEGIN;
INSERT INTO `t_user_wallet` VALUES (31, '$2a$10$ApWvvBHw0IMFIHCAT5vHxu9dlE3Kw1j0JBmzDTUTJoQQk1UHPKYBO', 392, 392, 0, NULL, NULL, NULL, 14, NULL, '2019-01-15 22:23:31', 0);
INSERT INTO `t_user_wallet` VALUES (36, '', 200, 200, 0, NULL, NULL, NULL, 4, '2018-12-28 12:00:36', '2019-01-15 20:51:44', 1);
INSERT INTO `t_user_wallet` VALUES (37, '', 0, 0, 0, NULL, NULL, NULL, 1, '2019-01-07 19:23:49', NULL, 0);
INSERT INTO `t_user_wallet` VALUES (38, '', 0, 0, 0, NULL, NULL, NULL, 1, '2019-01-07 19:28:25', NULL, 0);
INSERT INTO `t_user_wallet` VALUES (40, '', 0, 0, 0, 0, 0, 0, 1, '2019-01-17 10:30:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Procedure structure for initStatisticsDay
-- ----------------------------
DROP PROCEDURE IF EXISTS `initStatisticsDay`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `initStatisticsDay`(in beginDate datetime, in totalDays int)
BEGIN
	declare days int default 0;
	declare theDate datetime;
	declare hasError integer default 0;
	declare continue handler for sqlexception set hasError = 1;
	start transaction;
		truncate table t_statistics_day;
		while days < totalDays
			do
				set theDate = date_add(beginDate, interval days day);
				insert into t_statistics_day(the_date, am_pm) values(theDate, 'am');
				insert into t_statistics_day(the_date, am_pm) values(theDate, 'pm');
				set days = days + 1;
		end while;
	if hasError = 1 then
		rollback;
	else
		commit;
  end if;
END;
;;
delimiter ;

-- ----------------------------
-- Procedure structure for invite_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `invite_user`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `invite_user`(in pid bigint, in uid bigint)
BEGIN
    -- 如果uid等于pid，表示某个用户自己成为顶级经销商
	declare ancestorId bigint;
	declare num int default 0;
	declare userLevel int default 2;
	declare currentTime datetime default CURRENT_TIMESTAMP;
	declare userPath text;
	declare hasError integer default 0;
	-- 根据直接父id获取其所有祖先id，祖先id按倒序排列，方便得出用户id与祖先id间是多少级关系
	declare ancestorList cursor for
	select t_user_hierarchy.ancestor_id from t_user_hierarchy where t_user_hierarchy.user_id = pid
	order by t_user_hierarchy.ancestor_id desc;
	declare continue handler for sqlexception set hasError = 1;
	declare continue handler for not found set num = 1;
	start transaction;
		if uid != pid then
			open ancestorList;
				fetch ancestorList into ancestorId;
				while num != 1 do
					insert into t_user_hierarchy (ancestor_id, user_id, user_level, create_time) values(ancestorId, uid, userLevel, currentTime);
					-- 祖先id每循环一次，等级加1
					set userLevel = userLevel + 1;
					fetch ancestorList into ancestorId;
				end while;
			close ancestorList;
		end if;
		-- 自己与自己的关系，user_level为1
		insert into t_user_hierarchy (ancestor_id, user_id, user_level) values(uid, uid, 1);
		-- 保存用户层级路径
		if uid != pid then
			select t_user_path.user_path into userPath from t_user_path where t_user_path.user_path like concat('%', pid);
			insert into t_user_path (user_path, create_time) values(concat(userPath, '/', uid), currentTime);
		else
			insert into t_user_path (user_path, create_time) values(uid, currentTime);
		end if;
	if hasError = 1 then
		rollback;
	else
		commit;
  end if;
END;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
