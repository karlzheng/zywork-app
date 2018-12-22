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

 Date: 22/12/2018 16:05:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '模块标题',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '模块描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统模块表';

-- ----------------------------
-- Records of t_module
-- ----------------------------
BEGIN;
INSERT INTO `t_module` VALUES (1, '测试模块', NULL, '2018-12-07 19:42:13', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标题',
  `permission` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限字符串',
  `description` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限描述',
  `module_id` bigint(20) NOT NULL COMMENT '所属模块',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, '测试添加', '/test/add', NULL, 1, '2018-12-07 19:42:21', NULL, 0);
INSERT INTO `t_permission` VALUES (2, '测试修改', '/test/edit', NULL, 1, '2018-12-07 19:42:53', NULL, 0);
INSERT INTO `t_permission` VALUES (3, '测试删除', '/test/remove/*', NULL, 1, '2018-12-07 19:43:18', NULL, 0);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'super_sys_admin', '超级系统管理员', 0, '2018-12-07 19:09:45', NULL, 0);
INSERT INTO `t_role` VALUES (2, 'sys_admin', '系统管理员', 0, '2018-12-07 19:09:59', NULL, 0);
INSERT INTO `t_role` VALUES (3, 'normal_user', '普通用户', 1, '2018-12-07 19:10:21', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(20) NOT NULL COMMENT '权限编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色权限关联表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_role_permission` VALUES (1, 1, 1, '2018-12-07 19:43:40', NULL, 0);
INSERT INTO `t_role_permission` VALUES (2, 1, 2, '2018-12-07 19:43:46', NULL, 0);
INSERT INTO `t_role_permission` VALUES (4, 3, 1, '2018-12-07 19:44:09', NULL, 0);
INSERT INTO `t_role_permission` VALUES (5, 3, 2, '2018-12-07 19:44:28', NULL, 0);
INSERT INTO `t_role_permission` VALUES (6, 2, 1, '2018-12-07 19:49:09', NULL, 0);
INSERT INTO `t_role_permission` VALUES (7, 2, 2, '2018-12-07 19:49:15', NULL, 0);
INSERT INTO `t_role_permission` VALUES (10, 3, 3, '2018-12-13 20:49:30', NULL, 0);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统配置表，以JSON格式记录常用配置，如阿里云，微信等';

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_config` VALUES (1, 'aliyun_sms_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\",\n  \"signName\": \"signName\"\n}', '阿里云短信', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\",\n  \"signName\": \"短信签名\"\n}', '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (2, 'aliyun_mail_config', '{\n  \"accessKeyId\": \"yourAccessKeyId\",\n  \"accessKeySecret\": \"yourAccessKeySecret\"\n}', '阿里云邮件推送', '{\n  \"accessKeyId\": \"访问ID\",\n  \"accessKeySecret\": \"访问密钥\"\n}', '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (3, 'weixin_gzh_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"loginRedirectUrl\": \"\"\n}', '微信公众号', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"loginRedirectUrl\": \"服务器端登录回调接口地址\"\n}', '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (4, 'weixin_xcx_config', '{\n  \"appId\": \"appId\",\n  \"appSecret\": \"appSecret\"\n}', '微信小程序', '{\n  \"appId\": \"公众号ID\",\n  \"appSecret\": \"公众号密钥\"\n}', '2018-12-17 22:17:52', NULL, 0);
INSERT INTO `t_sys_config` VALUES (5, 'wx_pay_config', '{\n  \"mchId\": \"mchId\",\n  \"apiSecret\": \"apiSecret\",\n  \"baseUrl\": \"http://www.zywork.top\",\n  \"payNotifyUrl\": \"/byjc/tickeorder/result\"\n}', '微信支付', '{\n  \"mchId\": \"商户ID\",\n  \"apiSecret\": \"商户API密钥\",\n  \"baseUrl\": \"服务器端base url\",\n  \"payNotifyUrl\": \"服务器端支付通知接口\"\n}', '2018-12-17 22:17:52', NULL, 0);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
BEGIN;
INSERT INTO `t_sys_log` VALUES (1, 1, '13672297775', '用户编辑', NULL, 'http://localhost:8088/test/edit', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'edit', '2018-12-18 15:28:26', 13, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:28:25', NULL, 0);
INSERT INTO `t_sys_log` VALUES (2, 1, '13672297775', '用户编辑', NULL, 'http://localhost:8088/test/edit', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'edit', '2018-12-18 15:32:31', 7, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:32:30', NULL, 0);
INSERT INTO `t_sys_log` VALUES (3, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:32:35', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:32:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (4, 1, '847315251@qq.com', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:33:31', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:33:30', NULL, 0);
INSERT INTO `t_sys_log` VALUES (5, 1, '13672297775', '用户删除', NULL, 'http://localhost:8088/test/remove/100', 'GET', '[\"100\"]', 1001, '成功', 'top.zywork.controller.TestController', 'remove', '2018-12-18 15:35:36', 6, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:35:35', NULL, 0);
INSERT INTO `t_sys_log` VALUES (6, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:44:56', 17629, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:45:01', NULL, 0);
INSERT INTO `t_sys_log` VALUES (7, 1, '13672297775', '用户添加', NULL, 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 15:47:33', 4, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 15:47:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (8, 1, '847315251@qq.com', '用户添加', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36', 'http://localhost:8088/test/add', 'POST', '[]', 1001, '成功', 'top.zywork.controller.TestController', 'add', '2018-12-18 17:08:51', 12, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-18 17:08:51', NULL, 0);
INSERT INTO `t_sys_log` VALUES (9, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:46', 17, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:05:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (10, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:55', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:05:54', NULL, 0);
INSERT INTO `t_sys_log` VALUES (11, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:05:57', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:05:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (12, NULL, NULL, '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 13:06:30', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:06:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (13, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:06:45', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:06:45', NULL, 0);
INSERT INTO `t_sys_log` VALUES (14, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:09:16', 21380, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:09:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (15, NULL, NULL, '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1005, '未认证的用户', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:12:21', 17, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:12:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (16, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:22', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:13:21', NULL, 0);
INSERT INTO `t_sys_log` VALUES (17, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456ABC\",null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:37', 1, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:13:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (18, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",null]', 1003, '密码和确认密码不一致', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:49', 0, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:13:48', NULL, 0);
INSERT INTO `t_sys_log` VALUES (19, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:13:57', 137, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:13:56', NULL, 0);
INSERT INTO `t_sys_log` VALUES (20, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:17:16', 25277, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 13:17:16', NULL, 0);
INSERT INTO `t_sys_log` VALUES (21, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"\\\"\\\"\",\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:17:30', 8401, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'password\' not found. Available parameters are [oldPassword, userId, param1, param2]', '0:0:0:0:0:0:0:1', '2018-12-22 13:17:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (22, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\" \",\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 13:20:02', 132058, 1, 'nested exception is org.apache.ibatis.binding.BindingException: Parameter \'password\' not found. Available parameters are [oldPassword, userId, param1, param2]', '0:0:0:0:0:0:0:1', '2018-12-22 13:20:02', NULL, 0);
INSERT INTO `t_sys_log` VALUES (23, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,null,null]', 1003, '密码不符合要求', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:40:38', 6, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 14:40:38', NULL, 0);
INSERT INTO `t_sys_log` VALUES (24, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:40:54', 13, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 14:40:53', NULL, 0);
INSERT INTO `t_sys_log` VALUES (25, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:41:22', 141, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 14:41:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (26, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:50:29', 363448, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 14:50:29', NULL, 0);
INSERT INTO `t_sys_log` VALUES (27, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 14:57:40', 371360, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 14:57:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (28, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abc\",\"123456Abc\",\"123456Abc\"]', 1001, '登录密码更新成功', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:07:13', 294, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:07:13', NULL, 0);
INSERT INTO `t_sys_log` VALUES (29, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[\"123456Abcg\",\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:07:47', 136, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:07:46', NULL, 0);
INSERT INTO `t_sys_log` VALUES (30, 26, 'testcc@126.com', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"testAbc123\",\"testAbc123\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:11:08', 11, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:11:08', NULL, 0);
INSERT INTO `t_sys_log` VALUES (31, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:11:23', 2, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:11:22', NULL, 0);
INSERT INTO `t_sys_log` VALUES (32, 26, 'testcc@126.com', '更新登录密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-login', 'POST', '[null,\"123456Abc\",\"123456Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updateLoginPwd', '2018-12-22 15:12:41', 156, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:12:40', NULL, 0);
INSERT INTO `t_sys_log` VALUES (33, 26, 'testcc@126.com', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"testAbc123\",\"testAbc123\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:12:45', 125, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:12:44', NULL, 0);
INSERT INTO `t_sys_log` VALUES (34, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1003, '原密码错误', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:48:33', 165, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:48:32', NULL, 0);
INSERT INTO `t_sys_log` VALUES (35, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:53:52', 25, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:53:52', NULL, 0);
INSERT INTO `t_sys_log` VALUES (36, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:54:06', 3, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:54:05', NULL, 0);
INSERT INTO `t_sys_log` VALUES (37, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:38', 179, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:55:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (38, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:38', 179, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:55:37', NULL, 0);
INSERT INTO `t_sys_log` VALUES (39, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[null,\"1234Abc\",\"1234Abc\"]', NULL, NULL, 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:40', 4, 1, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:55:39', NULL, 0);
INSERT INTO `t_sys_log` VALUES (40, 31, '13672297775', '更新支付密码', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36', 'http://localhost:8088/pwd/update-pay', 'POST', '[\"1234Abc\",\"1234Abc\",\"1234Abc\"]', 1001, '支付密码更新成功', 'top.zywork.controller.PasswordController', 'updatePayPwd', '2018-12-22 15:55:47', 302, 0, NULL, '0:0:0:0:0:0:0:1', '2018-12-22 15:55:47', NULL, 0);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13672297776', '123456@qq.com', '$2a$10$wok8Kiq3/wCM2uGqGSiFGeYeP9oZ7lKLgmSPXpy9mrkiEg2kWzIe2', NULL, '2018-12-07 18:50:51', NULL, 0);
INSERT INTO `t_user` VALUES (2, NULL, 'wgs@126.com', '$2a$10$NRBlx5wTAV5j6yt3ocqOJuSEI760KmUrvtaP/QcsIsKXLLWNzsyq2', NULL, '2018-12-12 16:29:31', NULL, 0);
INSERT INTO `t_user` VALUES (4, '18888888888', NULL, '$2a$10$xWTNNu3RfrJqnhItrD0cGexQb1vZyfnQxTl/Y5CrHp89HbpKmIYcC', NULL, '2018-12-12 16:31:39', NULL, 0);
INSERT INTO `t_user` VALUES (19, NULL, NULL, '$2a$10$3d/ps2pQ2RQ3Xe4TzpOu7u97m14kUkZVBwHLsjNnw555TrlYNOXF2', NULL, '2018-12-12 17:34:50', NULL, 0);
INSERT INTO `t_user` VALUES (20, NULL, NULL, '$2a$10$SeDwW9A7ft0kgSLgBN698OsKQeY9Sqmf6w5RhXIqeYCXXsUPXRONm', NULL, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user` VALUES (21, NULL, NULL, '$2a$10$ePlfOylmN6DOa0KlkZmtq.4So7dXNimMqHBEdNzrVJLzGMbRg6G7O', NULL, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user` VALUES (22, NULL, 'wggss@126.com', '$2a$10$FeqZqJIQPIAuR5fWM9VDOeDVoYI9AMXK//C1GIRqbTbYNM6LhUIYO', NULL, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user` VALUES (23, '18888888899', NULL, '$2a$10$fb/Yu2tx71cs1AbrVfXjWuJn4Hyhprj5r6biD0d0cXfjFHQ8sGvKK', NULL, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user` VALUES (24, NULL, NULL, '$2a$10$NHv4sQCfTLRg9teU4GG3oOTSoQMcGJ8N2ZM2tJhTHX0jwCU5fEBxO', NULL, '2018-12-18 12:30:27', NULL, 0);
INSERT INTO `t_user` VALUES (26, NULL, 'testcc@126.com', '$2a$10$mMdC9tAosEr5jHXP9ZU4XemA5zbfoJ/lCNwjenVWZ0Vi2A8YiwX0O', NULL, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user` VALUES (27, '13666666666', NULL, NULL, NULL, '2018-12-22 13:41:53', NULL, 0);
INSERT INTO `t_user` VALUES (28, '15888888888', NULL, NULL, NULL, '2018-12-22 13:42:57', NULL, 0);
INSERT INTO `t_user` VALUES (29, '18888888886', NULL, NULL, NULL, '2018-12-22 13:43:59', NULL, 0);
INSERT INTO `t_user` VALUES (31, '13672297775', NULL, '$2a$10$Hr1cJZd8EZDbMAteKvMX3OvglmYiybSZpuHK8OuLs/xame41TKsYC', NULL, '2018-12-22 15:46:43', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail` (
  `id` bigint(20) NOT NULL COMMENT '用户编号',
  `nickname` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `headicon` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `identity` varchar(18) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `real_name` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户扩展信息表';

-- ----------------------------
-- Records of t_user_detail
-- ----------------------------
BEGIN;
INSERT INTO `t_user_detail` VALUES (19, 'nickname', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_detail` VALUES (20, 'nickname', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_detail` VALUES (21, 'nickname', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_detail` VALUES (24, 'nickname', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_detail` VALUES (26, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8V4txJ', '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user_detail` VALUES (31, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'nxrLRk', '2018-12-22 15:46:43', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1, 1, '2018-12-07 19:10:32', NULL, 0);
INSERT INTO `t_user_role` VALUES (2, 1, 2, '2018-12-07 19:10:52', NULL, 0);
INSERT INTO `t_user_role` VALUES (3, 22, 3, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user_role` VALUES (4, 23, 3, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user_role` VALUES (5, 24, 3, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_role` VALUES (6, 26, 3, '2018-12-21 19:45:04', NULL, 0);
INSERT INTO `t_user_role` VALUES (7, 31, 3, '2018-12-22 15:46:43', NULL, 0);
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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '第三方登录绑定时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户第三方登录信息表';

-- ----------------------------
-- Records of t_user_social
-- ----------------------------
BEGIN;
INSERT INTO `t_user_social` VALUES (1, 1, '12345678', NULL, NULL, '微信', '2018-12-07 18:54:34', NULL, 0);
INSERT INTO `t_user_social` VALUES (2, 19, 'openid', NULL, NULL, '微信', '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_social` VALUES (3, 20, 'openid', NULL, NULL, '微信', '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_social` VALUES (4, 21, 'openid', NULL, NULL, '微信', '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_social` VALUES (5, 24, 'openid_wechat', NULL, NULL, '微信', '2018-12-18 12:30:28', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_wallet`;
CREATE TABLE `t_user_wallet` (
  `id` bigint(20) NOT NULL COMMENT '钱包编号',
  `pay_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '支付密码',
  `rmb_balance` bigint(20) DEFAULT '0' COMMENT '人民币余额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT NULL COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户钱包表';

-- ----------------------------
-- Records of t_user_wallet
-- ----------------------------
BEGIN;
INSERT INTO `t_user_wallet` VALUES (31, '$2a$10$f8mTBz3qQdyrKalljtffkOr3vbWfGA8CyinLKbeHOCG/UmDLr1B5y', 0, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
