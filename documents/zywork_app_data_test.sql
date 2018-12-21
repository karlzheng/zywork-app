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

 Date: 21/12/2018 19:48:55
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';

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
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '加密盐值',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '0' COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户基本信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13672297775', '847315251@qq.com', '$2a$10$wok8Kiq3/wCM2uGqGSiFGeYeP9oZ7lKLgmSPXpy9mrkiEg2kWzIe2', NULL, '2018-12-07 18:50:51', NULL, 0);
INSERT INTO `t_user` VALUES (2, NULL, 'wgssmarter@126.com', '$2a$10$NRBlx5wTAV5j6yt3ocqOJuSEI760KmUrvtaP/QcsIsKXLLWNzsyq2', NULL, '2018-12-12 16:29:31', NULL, 0);
INSERT INTO `t_user` VALUES (4, '18888888888', NULL, '$2a$10$xWTNNu3RfrJqnhItrD0cGexQb1vZyfnQxTl/Y5CrHp89HbpKmIYcC', NULL, '2018-12-12 16:31:39', NULL, 0);
INSERT INTO `t_user` VALUES (19, NULL, NULL, '$2a$10$3d/ps2pQ2RQ3Xe4TzpOu7u97m14kUkZVBwHLsjNnw555TrlYNOXF2', NULL, '2018-12-12 17:34:50', NULL, 0);
INSERT INTO `t_user` VALUES (20, NULL, NULL, '$2a$10$SeDwW9A7ft0kgSLgBN698OsKQeY9Sqmf6w5RhXIqeYCXXsUPXRONm', NULL, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user` VALUES (21, NULL, NULL, '$2a$10$ePlfOylmN6DOa0KlkZmtq.4So7dXNimMqHBEdNzrVJLzGMbRg6G7O', NULL, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user` VALUES (22, NULL, 'wgssmart@126.com', '$2a$10$FeqZqJIQPIAuR5fWM9VDOeDVoYI9AMXK//C1GIRqbTbYNM6LhUIYO', NULL, '2018-12-18 12:28:45', NULL, 0);
INSERT INTO `t_user` VALUES (23, '18888888899', NULL, '$2a$10$fb/Yu2tx71cs1AbrVfXjWuJn4Hyhprj5r6biD0d0cXfjFHQ8sGvKK', NULL, '2018-12-18 12:30:17', NULL, 0);
INSERT INTO `t_user` VALUES (24, NULL, NULL, '$2a$10$NHv4sQCfTLRg9teU4GG3oOTSoQMcGJ8N2ZM2tJhTHX0jwCU5fEBxO', NULL, '2018-12-18 12:30:27', NULL, 0);
INSERT INTO `t_user` VALUES (26, NULL, 'testcc@126.com', '$2a$10$0Uj1vGNT9G8aRRk9NT7x0OT.os/aX877us/936n/YItA39fY4kOla', NULL, '2018-12-21 19:45:04', NULL, 0);
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
INSERT INTO `t_user_detail` VALUES (19, 'wgssmarter@126.com', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:34:51', NULL, 0);
INSERT INTO `t_user_detail` VALUES (20, 'wgssmarter@126.com', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:36:19', NULL, 0);
INSERT INTO `t_user_detail` VALUES (21, 'wgssmarter@126.com', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-12 17:37:09', NULL, 0);
INSERT INTO `t_user_detail` VALUES (24, 'wgssmarter@126.com', 'headicon', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2018-12-18 12:30:28', NULL, 0);
INSERT INTO `t_user_detail` VALUES (26, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8V4txJ', '2018-12-21 19:45:04', NULL, 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色表';

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

SET FOREIGN_KEY_CHECKS = 1;
