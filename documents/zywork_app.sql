/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : zywork_app

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 16/03/2019 19:11:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_account_detail`;
CREATE TABLE `t_account_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账目编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NULL DEFAULT NULL COMMENT '金额',
  `integral` bigint(20) NULL DEFAULT NULL COMMENT '积分',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '收入或支出',
  `sub_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收支类型',
  `pay_type` tinyint(4) NULL DEFAULT NULL COMMENT '支付方式',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户账目明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `category_id` bigint(20) NOT NULL COMMENT '类别编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `cover_img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '封面图片',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章摘要',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章内容',
  `view_count` int(11) NULL DEFAULT 0 COMMENT '阅读量',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人编号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 1 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article_category
-- ----------------------------
DROP TABLE IF EXISTS `t_article_category`;
CREATE TABLE `t_article_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类别名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 1 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_article_comment`;
CREATE TABLE `t_article_comment`  (
  `id` bigint(20) NOT NULL COMMENT '评论编号',
  `article_id` bigint(20) NOT NULL COMMENT '文章编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论标题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论详情',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 1 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_frezee
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_frezee`;
CREATE TABLE `t_funds_frezee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '冻结编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `frezee_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `frezee_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金冻结与解冻记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_recharge
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_recharge`;
CREATE TABLE `t_funds_recharge`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '充值金额',
  `recharge_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值类型',
  `is_success` tinyint(4) NULL DEFAULT 0 COMMENT '是否成功',
  `out_trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户订单号',
  `trade_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付系统订单号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金充值记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_transfer`;
CREATE TABLE `t_funds_transfer`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转账编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `amount` bigint(20) NOT NULL COMMENT '金额',
  `from_user_id` bigint(20) NULL DEFAULT NULL COMMENT 'FROM',
  `to_user_id` bigint(20) NULL DEFAULT NULL COMMENT 'TO',
  `transfer_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `transfer_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金转入与转出记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw`;
CREATE TABLE `t_funds_withdraw`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `amount` bigint(20) NOT NULL COMMENT '提现金额',
  `bankcard_id` bigint(20) NOT NULL COMMENT '提现银行卡',
  `withdraw_status` tinyint(4) NULL DEFAULT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) NULL DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `complete_time` datetime(0) NULL DEFAULT NULL COMMENT '完成时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金提现记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_funds_withdraw_check
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw_check`;
CREATE TABLE `t_funds_withdraw_check`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '提现审核编号',
  `withdraw_id` bigint(20) NOT NULL COMMENT '提现编号',
  `transaction_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '交易编号',
  `withdraw_status` tinyint(4) NOT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) NOT NULL COMMENT '审核人编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户资金提现审核历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute`;
CREATE TABLE `t_goods_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性编号',
  `attr_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `attr_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性代码',
  `attr_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据类型',
  `attr_length` int(11) NOT NULL COMMENT '数据长度',
  `attr_required` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否必填',
  `attr_display` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否前端显示',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品属性信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attribute_value`;
CREATE TABLE `t_goods_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品属性值编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU属性及属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_cart`;
CREATE TABLE `t_goods_cart`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车信息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_category
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类目描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_category_attribute`;
CREATE TABLE `t_goods_category_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目属性编号',
  `category_id` bigint(20) NOT NULL COMMENT '商品类目编号',
  `attr_id` bigint(20) NOT NULL COMMENT '属性编号',
  `attr_order` int(11) NOT NULL DEFAULT 1000 COMMENT '属性排序',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类目属性信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment`;
CREATE TABLE `t_goods_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品评论编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `comments` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论详情',
  `append_comment` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '追加评论',
  `reply` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复详情',
  `stick_status` tinyint(4) NULL DEFAULT 0 COMMENT '置顶状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_comment_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comment_pic`;
CREATE TABLE `t_goods_comment_pic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论图片编号',
  `comment_id` bigint(20) NOT NULL COMMENT '评论编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论图片表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_coupon`;
CREATE TABLE `t_goods_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠券编号',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品类目编号',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品SKU编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '优惠券标题',
  `use_min_amount` bigint(20) NULL DEFAULT NULL COMMENT '最小消费金额',
  `discount_amount` bigint(20) NULL DEFAULT NULL COMMENT '满减优惠金额',
  `discount_percent` double(3, 0) NULL DEFAULT NULL COMMENT '满减折扣',
  `integral_amount` int(11) NULL DEFAULT NULL COMMENT '赠送积分',
  `total_count` int(11) NOT NULL COMMENT '优惠券总量',
  `coupon_usable_range` tinyint(4) NOT NULL COMMENT '优惠券使用范围',
  `coupon_type` tinyint(4) NOT NULL COMMENT '优惠券类型',
  `start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `due_time` datetime(0) NULL DEFAULT NULL COMMENT '到期时间',
  `valid_days` int(11) NULL DEFAULT NULL COMMENT '有效时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品优惠券信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_info`;
CREATE TABLE `t_goods_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图文详情',
  `shelf_status` tinyint(4) NULL DEFAULT 0 COMMENT '上架状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品记录表，包含多个商品SKU' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order`;
CREATE TABLE `t_goods_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '订单号',
  `total_amount` bigint(20) NOT NULL COMMENT '订单金额',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '赠送积分',
  `express_fee` bigint(20) NULL DEFAULT 0 COMMENT '运费',
  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` tinyint(4) NULL DEFAULT NULL COMMENT '支付方式',
  `transaction_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付订单号',
  `pay_success` tinyint(4) NULL DEFAULT NULL COMMENT '是否支付成功',
  `deliver_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `deal_time` datetime(0) NULL DEFAULT NULL COMMENT '成交时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表，一个订单包含多个订单条目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_coupon`;
CREATE TABLE `t_goods_order_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用券编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单优惠券使用记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_item`;
CREATE TABLE `t_goods_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `order_id` bigint(20) NOT NULL COMMENT '订单编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `goods_sku_id` bigint(20) NOT NULL COMMENT 'SKU编号',
  `sku_pic_id` bigint(20) NOT NULL COMMENT 'SKU图片编号',
  `sku_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '售卖标题',
  `sku_info` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'SKU属性JSON',
  `quantity` int(11) NOT NULL COMMENT '购买数量',
  `pay_amount` bigint(20) NOT NULL COMMENT '实付金额',
  `discount_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '优惠金额',
  `integral_amount` bigint(20) NOT NULL DEFAULT 0 COMMENT '赠送积分',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单详情信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_order_logistics
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_order_logistics`;
CREATE TABLE `t_goods_order_logistics`  (
  `id` bigint(20) NOT NULL COMMENT '订单编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_deliver` tinyint(4) NULL DEFAULT 0 COMMENT '是否已发货',
  `logistics_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流公司名称',
  `logistics_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流公司编码',
  `logistics_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单物流信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_pic
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_pic`;
CREATE TABLE `t_goods_pic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品图片编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `pic_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图片URL',
  `pic_order` int(11) NULL DEFAULT 1000 COMMENT '图片顺序',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品图片信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop`;
CREATE TABLE `t_goods_shop`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `category_id` bigint(20) NOT NULL COMMENT '类目编号',
  `subject_type` tinyint(4) NOT NULL COMMENT '主体类型',
  `logo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺Logo',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺标题',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '店铺简介',
  `level` tinyint(4) NULL DEFAULT 1 COMMENT '店铺等级',
  `check_status` tinyint(4) NULL DEFAULT 0 COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) NULL DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_certification`;
CREATE TABLE `t_goods_shop_certification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺认证编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `detail` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '认证详情JSON',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺认证信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_shop_check
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_shop_check`;
CREATE TABLE `t_goods_shop_check`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺审核编号',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺编号',
  `check_status` tinyint(4) NULL DEFAULT 0 COMMENT '审核状态',
  `check_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核描述',
  `checked_user_id` tinyint(4) NULL DEFAULT NULL COMMENT '审核人编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺审核历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'SKU编号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `pic_id` bigint(20) NULL DEFAULT NULL COMMENT '商品图片编号',
  `shelf_status` tinyint(4) NULL DEFAULT 0 COMMENT '上架状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品SKU信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_goods_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_user_coupon`;
CREATE TABLE `t_goods_user_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `coupon_id` bigint(20) NOT NULL COMMENT '优惠券编号',
  `coupon_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '优惠券状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品优惠券用户领券信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '消息内容',
  `message_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息类型',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告摘要',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告内容',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '截止时间',
  `stick_status` tinyint(4) NULL DEFAULT 0 COMMENT '置顶状态',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '组织编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '组织名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组织描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '组织或部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `module_id` bigint(20) NOT NULL COMMENT '所属模块',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标题',
  `permission` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_process
-- ----------------------------
DROP TABLE IF EXISTS `t_process`;
CREATE TABLE `t_process`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程编号',
  `process_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程Name',
  `process_key` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程Key',
  `file_path` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程文件路径',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程描述',
  `is_deploy` tinyint(4) NULL DEFAULT 0 COMMENT '是否部署',
  `deploy_time` datetime(0) NULL DEFAULT NULL COMMENT '部署时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标题',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `is_default` tinyint(4) NULL DEFAULT 0 COMMENT '是否默认角色',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `t_scheduler`;
CREATE TABLE `t_scheduler`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业名称',
  `class_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '完整类名',
  `cron_expression` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `group_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业组名称',
  `trigger_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '触发器名称',
  `trigger_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '触发器组',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业描述',
  `job_status` tinyint(4) NULL DEFAULT 0 COMMENT '作业状态',
  `job_status_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '状态更新时间',
  `auto_start` tinyint(4) NULL DEFAULT 0 COMMENT '自动启动',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作业调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shipping_address
-- ----------------------------
DROP TABLE IF EXISTS `t_shipping_address`;
CREATE TABLE `t_shipping_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '地址编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '市',
  `district` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区/县',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '详细地址',
  `is_default` tinyint(4) NULL DEFAULT 0 COMMENT '是否默认',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_statistics_dau
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_dau`;
CREATE TABLE `t_statistics_dau`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'DAU编号',
  `dau` bigint(20) NOT NULL COMMENT 'DAU',
  `statistics_time` datetime(0) NOT NULL COMMENT '统计时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日活用户统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_statistics_day
-- ----------------------------
DROP TABLE IF EXISTS `t_statistics_day`;
CREATE TABLE `t_statistics_day`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日期编号',
  `the_date` datetime(0) NOT NULL COMMENT '日期字符串',
  `am_pm` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '上午或下午',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用于数据统计的日期信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置名称',
  `value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置内容(JSON)',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中文说明',
  `comment` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置注释',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表，以JSON格式记录常用配置，如阿里云，微信等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `user_account` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行说明',
  `user_agent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'User-Agent',
  `request_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求URL',
  `request_method` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式',
  `request_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `response_code` int(11) NULL DEFAULT NULL COMMENT '响应编码',
  `response_msg` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '响应消息',
  `execute_class` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '完整类名',
  `execute_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名称',
  `execute_time` datetime(0) NULL DEFAULT NULL COMMENT '开始执行时间',
  `execute_cost_time` bigint(20) NULL DEFAULT NULL COMMENT '执行耗时(ms)',
  `has_exception` tinyint(4) NULL DEFAULT 0 COMMENT '是否异常',
  `exception_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '异常消息',
  `execute_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密盐值',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户基本信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_bankcard
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bankcard`;
CREATE TABLE `t_user_bankcard`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `account_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '持卡人姓名',
  `bank_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行代码',
  `bank_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行名称',
  `bankcard_no` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户银行卡记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_certification
-- ----------------------------
DROP TABLE IF EXISTS `t_user_certification`;
CREATE TABLE `t_user_certification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '认证编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `identity` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号',
  `real_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名',
  `valid_date` date NULL DEFAULT NULL COMMENT '身份证有效期',
  `idcard_front` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证正面',
  `idcard_reverse` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证反面',
  `idcard_hand` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手持身份证',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户实名认证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail`  (
  `id` bigint(20) NOT NULL COMMENT '用户编号',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `headicon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `gender` tinyint(4) NULL DEFAULT 0 COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `qq_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ二维码',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `wechat_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信二维码',
  `alipay` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝账号',
  `alipay_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝二维码',
  `share_code` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分享码',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户扩展信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_hierarchy
-- ----------------------------
DROP TABLE IF EXISTS `t_user_hierarchy`;
CREATE TABLE `t_user_hierarchy`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系编号',
  `ancestor_id` bigint(20) NOT NULL COMMENT '祖先编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_level` int(11) NOT NULL COMMENT '用户级别',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_message
-- ----------------------------
DROP TABLE IF EXISTS `t_user_message`;
CREATE TABLE `t_user_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息发送编号',
  `message_id` bigint(20) NOT NULL COMMENT '消息编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `is_read` tinyint(4) NULL DEFAULT 0 COMMENT '是否已读',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_user_organization`;
CREATE TABLE `t_user_organization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户组织编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `organization_id` bigint(20) NOT NULL COMMENT '组织编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户组织部门信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_path
-- ----------------------------
DROP TABLE IF EXISTS `t_user_path`;
CREATE TABLE `t_user_path`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '路径编号',
  `user_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户路径',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `idx_user_path`(`user_path`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户关系路径表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_social
-- ----------------------------
DROP TABLE IF EXISTS `t_user_social`;
CREATE TABLE `t_user_social`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '第三方登录编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `openid` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'openid',
  `union_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'unionid',
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'AccessToken',
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'SessionKey',
  `refresh_token` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '刷新Token',
  `social_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第三方登录类型',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '第三方登录绑定时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户第三方登录信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_wallet`;
CREATE TABLE `t_user_wallet`  (
  `id` bigint(20) NOT NULL COMMENT '钱包编号',
  `pay_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '支付密码',
  `rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '人民币余额',
  `usable_rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '可用余额',
  `frozen_rmb_balance` bigint(20) NULL DEFAULT 0 COMMENT '冻结余额',
  `integral` bigint(20) NULL DEFAULT 0 COMMENT '总积分',
  `usable_integral` bigint(20) NULL DEFAULT 0 COMMENT '可用积分',
  `frozen_integral` bigint(20) NULL DEFAULT 0 COMMENT '冻结积分',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) NULL DEFAULT 0 COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户钱包表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for initStatisticsDay
-- ----------------------------
DROP PROCEDURE IF EXISTS `initStatisticsDay`;
delimiter ;;
CREATE PROCEDURE `initStatisticsDay`(in beginDate datetime, in totalDays int)
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
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for invite_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `invite_user`;
delimiter ;;
CREATE PROCEDURE `invite_user`(in pid bigint, in uid bigint)
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
	order by t_user_hierarchy.user_level asc;
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
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
