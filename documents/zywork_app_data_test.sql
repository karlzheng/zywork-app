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

 Date: 25/12/2018 15:30:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_account_detail`;
CREATE TABLE `t_account_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '账目编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `type` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账目类型',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='账目明细表';

-- ----------------------------
-- Table structure for t_funds_frezee
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_frezee`;
CREATE TABLE `t_funds_frezee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `frezee_type` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `frezee_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资金冻结与解冻记录表';

-- ----------------------------
-- Table structure for t_funds_recharge
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_recharge`;
CREATE TABLE `t_funds_recharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '充值金额',
  `recharge_type` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '充值类型',
  `is_success` tinyint(4) DEFAULT '0' COMMENT '是否成功',
  `out_trade_no` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商户订单号',
  `trade_no` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付系统订单号',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资金充值记录表';

-- ----------------------------
-- Records of t_funds_recharge
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_recharge` VALUES (1, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 13:06:57', NULL, 0);
INSERT INTO `t_funds_recharge` VALUES (2, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 13:08:11', NULL, 0);
INSERT INTO `t_funds_recharge` VALUES (3, 31, 134, '人工充值', 0, NULL, NULL, 1, '2018-12-23 14:06:48', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_funds_transfer
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_transfer`;
CREATE TABLE `t_funds_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `amount` bigint(20) DEFAULT NULL COMMENT '金额',
  `from_user_id` bigint(20) DEFAULT NULL COMMENT 'FROM',
  `to_user_id` bigint(20) DEFAULT NULL COMMENT 'TO',
  `transfer_type` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  `transfer_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资金转入与转出记录表';

-- ----------------------------
-- Table structure for t_funds_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `t_funds_withdraw`;
CREATE TABLE `t_funds_withdraw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `withdraw_no` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '提现单号',
  `amount` bigint(20) DEFAULT NULL COMMENT '提现金额',
  `bankcard_id` bigint(20) DEFAULT NULL COMMENT '提现银行卡',
  `withdraw_status` tinyint(4) DEFAULT NULL COMMENT '提现状态',
  `withdraw_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '提现描述',
  `checked_user_id` bigint(20) DEFAULT NULL COMMENT '审核人编号',
  `checked_time` datetime DEFAULT NULL COMMENT '审核时间',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='资金提现记录表';

-- ----------------------------
-- Records of t_funds_withdraw
-- ----------------------------
BEGIN;
INSERT INTO `t_funds_withdraw` VALUES (5, 31, '3ea854cde3b842338cc7a0fb3fd49bcb', 100, 1, 2, '不能提现', 31, '2018-12-23 18:47:53', '2018-12-23 18:47:53', 1, '2018-12-23 18:43:49', '2018-12-23 18:47:53', 0);
INSERT INTO `t_funds_withdraw` VALUES (6, 31, '77d07a5d6d2b4a7280e9ecff229d4888', 100, 1, 4, NULL, 31, '2018-12-23 20:56:16', '2018-12-23 21:05:20', 1, '2018-12-23 18:49:38', '2018-12-23 21:05:20', 0);
INSERT INTO `t_funds_withdraw` VALUES (7, 31, '399a929dc59a48f0af9498a534252792', 100, 1, 4, NULL, 31, '2018-12-25 15:04:57', '2018-12-25 15:22:34', 4, '2018-12-23 22:25:54', '2018-12-25 15:22:34', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块标题',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统模块表';

-- ----------------------------
-- Records of t_module
-- ----------------------------
BEGIN;
INSERT INTO `t_module` VALUES (1, '测试模块', NULL, 1, '2018-12-07 19:42:13', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `module_id` bigint(20) NOT NULL COMMENT '所属模块',
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标题',
  `permission` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, 1, '测试添加', '/test/add', NULL, 1, '2018-12-07 19:42:21', NULL, 0);
INSERT INTO `t_permission` VALUES (2, 1, '测试修改', '/test/edit', NULL, 1, '2018-12-07 19:42:53', NULL, 0);
INSERT INTO `t_permission` VALUES (3, 1, '测试删除', '/test/remove/*', NULL, 1, '2018-12-07 19:43:18', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_process
-- ----------------------------
DROP TABLE IF EXISTS `t_process`;
CREATE TABLE `t_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程编号',
  `name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程标题',
  `file_path` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '流程文件路径',
  `description` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '流程描述',
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
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标题',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `is_default` tinyint(4) DEFAULT '0' COMMENT '是否默认角色',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'super_sys_admin', '超级系统管理员', 0, 1, '2018-12-07 19:09:45', NULL, 0);
INSERT INTO `t_role` VALUES (2, 'sys_admin', '系统管理员', 0, 1, '2018-12-07 19:09:59', NULL, 0);
INSERT INTO `t_role` VALUES (3, 'normal_user', '普通用户', 1, 1, '2018-12-07 19:10:21', NULL, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_role_permission` VALUES (1, 1, 1, 1, '2018-12-07 19:43:40', NULL, 0);
INSERT INTO `t_role_permission` VALUES (2, 1, 2, 1, '2018-12-07 19:43:46', NULL, 0);
INSERT INTO `t_role_permission` VALUES (4, 3, 1, 1, '2018-12-07 19:44:09', NULL, 0);
INSERT INTO `t_role_permission` VALUES (5, 3, 2, 1, '2018-12-07 19:44:28', NULL, 0);
INSERT INTO `t_role_permission` VALUES (6, 2, 1, 1, '2018-12-07 19:49:09', NULL, 0);
INSERT INTO `t_role_permission` VALUES (7, 2, 2, 1, '2018-12-07 19:49:15', NULL, 0);
INSERT INTO `t_role_permission` VALUES (10, 3, 3, 1, '2018-12-13 20:49:30', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_scheduler
-- ----------------------------
DROP TABLE IF EXISTS `t_scheduler`;
CREATE TABLE `t_scheduler` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '作业名称',
  `class_name` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '完整类名',
  `cron_expression` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `group_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业组名称',
  `trigger_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '触发器名称',
  `trigger_group` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '触发器组',
  `description` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '作业描述',
  `job_status` tinyint(4) DEFAULT NULL COMMENT '作业状态',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='作业调度表';

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配置编号',
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配置名称',
  `value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配置内容(JSON)',
  `description` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '中文说明',
  `comment` varchar(5000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '配置注释',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统配置表，以JSON格式记录常用配置，如阿里云，微信等';

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_config` VALUES (1, 'aliyun_sms_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\",\n  \"signName\": \"signName\"\n}', '阿里云短信', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\",\n  \"signName\": \"短信签名\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (2, 'aliyun_mail_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\"\n}', '阿里云邮件推送', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (3, 'weixin_gzh_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"loginRedirectUrl\": \"\"\n}', '微信公众号', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"loginRedirectUrl\": \"服务器端登录回调接口地址\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (4, 'weixin_xcx_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\"\n}', '微信小程序', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (5, 'wx_pay_config', '{\n  \"mchId\": \"mchId\",\n  \"apiSecret\": \"apiSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"payNotifyUrl\": \"/byjc/tickeorder/result\"\n}', '微信支付', '{\n  \"mchId\": \"商户ID\",\n  \"apiSecret\": \"商户API密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"payNotifyUrl\": \"服务器端支付通知接口\"\n}', 1, '2018-12-17 22:17:52', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `user_account` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户账号',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '执行说明',
  `user_agent` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'User-Agent',
  `request_url` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求URL',
  `request_method` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方式',
  `request_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求参数',
  `response_code` int(11) DEFAULT NULL COMMENT '响应编码',
  `response_msg` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '响应消息',
  `execute_class` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '完整类名',
  `execute_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '方法名称',
  `execute_time` datetime DEFAULT NULL COMMENT '开始执行时间',
  `execute_cost_time` bigint(20) DEFAULT NULL COMMENT '执行耗时(ms)',
  `has_exception` tinyint(4) DEFAULT '0' COMMENT '是否异常',
  `exception_msg` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '异常消息',
  `execute_ip` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IP地址',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';

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
  `salt` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密盐值',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13672297776', '123456@qq.com', '$2a$10$wok8Kiq3/wCM2uGqGSiFGeYeP9oZ7lKLgmSPXpy9mrkiEg2kWzIe2', NULL, 1, '2018-12-07 18:50:51', NULL, 0);
INSERT INTO `t_user` VALUES (2, NULL, 'wgs@126.com', '$2a$10$NRBlx5wTAV5j6yt3ocqOJuSEI760KmUrvtaP/QcsIsKXLLWNzsyq2', NULL, 1, '2018-12-12 16:29:31', NULL, 0);
INSERT INTO `t_user` VALUES (4, '13366666666', 'abc@126.com', '$2a$10$xWTNNu3RfrJqnhItrD0cGexQb1vZyfnQxTl/Y5CrHp89HbpKmIYcC', NULL, 6, '2018-12-12 16:31:39', '2018-12-25 13:17:53', 0);
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
COMMIT;

-- ----------------------------
-- Table structure for t_user_bankcard
-- ----------------------------
DROP TABLE IF EXISTS `t_user_bankcard`;
CREATE TABLE `t_user_bankcard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '银行卡编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `account_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '持卡人姓名',
  `bank_code` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '银行代码',
  `bank_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '银行名称',
  `bankcard_no` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '银行卡号',
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
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `identity` varchar(18) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
  `valid_date` date DEFAULT NULL COMMENT '身份证有效期',
  `idcard_front` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证正面',
  `idcard_reverse` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证反面',
  `idcard_hand` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手持身份证',
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
  `nickname` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `headicon` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `gender` tinyint(4) DEFAULT '0' COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `qq` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'QQ号',
  `qq_qrcode` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'QQ二维码',
  `wechat` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信号',
  `wechat_qrcode` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信二维码',
  `alipay` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付宝账号',
  `alipay_qrcode` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '支付宝二维码',
  `share_code` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分享码',
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1, 1, 1, '2018-12-07 19:10:32', NULL, 0);
INSERT INTO `t_user_role` VALUES (2, 1, 2, 1, '2018-12-07 19:10:52', NULL, 0);
INSERT INTO `t_user_role` VALUES (3, 22, 3, 1, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user_role` VALUES (4, 23, 3, 1, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user_role` VALUES (5, 24, 3, 1, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_role` VALUES (6, 26, 3, 1, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user_role` VALUES (7, 31, 3, 1, '2018-12-22 15:46:43', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_social
-- ----------------------------
DROP TABLE IF EXISTS `t_user_social`;
CREATE TABLE `t_user_social` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '第三方登录编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `openid` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第三方登录OAuth openid',
  `union_id` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第三方登录OAuth unionid',
  `refresh_token` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '刷新Token',
  `social_type` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第三方登录类型',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '第三方登录绑定时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户第三方登录信息表';

-- ----------------------------
-- Records of t_user_social
-- ----------------------------
BEGIN;
INSERT INTO `t_user_social` VALUES (1, 1, '12345678', NULL, NULL, '微信', 1, '2018-12-07 18:54:34', NULL, 0);
INSERT INTO `t_user_social` VALUES (2, 19, 'openid', NULL, NULL, '微信', 1, '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_social` VALUES (3, 20, 'openid', NULL, NULL, '微信', 1, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_social` VALUES (4, 21, 'openid', NULL, NULL, '微信', 1, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_social` VALUES (5, 24, 'openid_wechat', NULL, NULL, '微信', 1, '2018-12-18 12:30:28', NULL, 0);
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
INSERT INTO `t_user_wallet` VALUES (31, '$2a$10$ApWvvBHw0IMFIHCAT5vHxu9dlE3Kw1j0JBmzDTUTJoQQk1UHPKYBO', 202, 202, 0, 5, NULL, '2018-12-25 15:22:56', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
