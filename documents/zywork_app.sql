create table t_module
(
	id bigint auto_increment comment '模块编号'
		primary key,
	title varchar(50) not null comment '模块标题',
	description varchar(200) null comment '模块描述',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '系统模块表'
;

create table t_permission
(
	id bigint auto_increment comment '权限编号'
		primary key,
	title varchar(50) not null comment '权限标题',
	permission varchar(200) not null comment '权限字符串',
	description varchar(200) null comment '权限描述',
	module_id bigint not null comment '所属模块',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活',
	constraint fk_permission_module_id
	foreign key (module_id) references t_module (id)
)
	comment '系统权限表'
;

create index fk_permission_module_id
	on t_permission (module_id)
;

create table t_process
(
	id bigint auto_increment comment '流程编号'
		primary key,
	name varchar(200) not null comment '流程标题',
	file_path varchar(500) not null comment '流程文件路径',
	description varchar(500) null comment '流程描述',
	is_deploy tinyint default '0' null comment '是否部署',
	deploy_time datetime null comment '部署时间',
	create_time datetime default CURRENT_TIMESTAMP null comment '上传时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '流程信息表'
;

create table t_role
(
	id bigint auto_increment comment '角色编号'
		primary key,
	title varchar(50) not null comment '角色标题',
	description varchar(200) null comment '角色描述',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '系统角色表'
;

create table t_role_permission
(
	id bigint auto_increment comment '编号'
		primary key,
	role_id bigint not null comment '角色编号',
	permission_id bigint not null comment '权限编号',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活',
	constraint fk_role_permission_rold_id
	foreign key (role_id) references t_role (id),
	constraint fk_role_permission_per_id
	foreign key (permission_id) references t_permission (id)
)
	comment '角色权限关联表'
;

create index fk_role_permission_per_id
	on t_role_permission (permission_id)
;

create index fk_role_permission_rold_id
	on t_role_permission (role_id)
;

create table t_scheduler
(
	id bigint auto_increment comment '作业编号'
		primary key,
	name varchar(50) not null comment '作业名称',
	class_name varchar(200) not null comment '完整类名',
	cron_expression varchar(50) not null comment 'cron表达式',
	group_name varchar(50) null comment '作业组名称',
	trigger_name varchar(50) null comment '触发器名称',
	trigger_group varchar(50) null comment '触发器组',
	description varchar(500) null comment '作业描述',
	job_status tinyint null comment '作业状态',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '作业调度表'
;

create table t_social_type
(
	id bigint not null comment '类型编号'
		primary key,
	title varchar(20) not null comment '登录类型',
	description varchar(200) null comment '类型描述',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '第三方登录类型表'
;

create table t_sys_log
(
	id bigint auto_increment comment '日志编号'
		primary key,
	user_id bigint null comment '用户编号',
	user_account varchar(100) null comment '用户账号',
	description varchar(200) null comment '执行说明',
	execute_class varchar(500) null comment '完整类名',
	execute_method varchar(100) null comment '方法名称',
	execute_time datetime null comment '开始执行时间',
	execute_cost_time bigint null comment '执行耗时(ms)',
	request_method varchar(20) null comment '请求方式',
	request_params text null comment '请求参数',
	response_code int null comment '响应编码',
	response_msg text null comment '响应消息',
	has_exception tinyint default '0' null comment '是否异常',
	exception_msg varchar(500) null comment '异常消息',
	execute_ip varchar(100) null comment 'IP地址',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '系统操作日志表'
;

create index t_sys_log_user_id
	on t_sys_log (user_id)
;

create table t_user
(
	id bigint auto_increment comment '用户编号'
		primary key,
	email varchar(100) null comment '用户邮箱',
	phone varchar(11) null comment '手机号',
	account_name varchar(20) null comment '账户名',
	password varchar(100) not null comment '登录密码',
	salt varchar(200) null comment '加密盐值',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活'
)
	comment '用户基本信息表'
;

alter table t_sys_log
	add constraint t_sys_log_user_id
foreign key (user_id) references t_user (id)
;

create table t_user_detail
(
	id bigint not null comment '用户编号'
		primary key,
	nickname varchar(20) null comment '昵称',
	headicon varchar(500) null comment '头像地址',
	identity varchar(18) null comment '身份证号',
	real_name varchar(10) null comment '真实姓名',
	gender tinyint default '0' null comment '性别',
	birthday date null comment '生日',
	age int null comment '年龄',
	qq varchar(20) null comment 'QQ号',
	wechat varchar(50) null comment '微信号',
	alipay varchar(100) null comment '支付宝账号',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活',
	constraint fk_user_detail_id
	foreign key (id) references t_user (id)
)
	comment '用户扩展信息表'
;

create table t_user_role
(
	id bigint auto_increment comment '编号'
		primary key,
	user_id bigint not null comment '用户编号',
	role_id bigint not null comment '角色编号',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活',
	constraint fk_user_role_user_id
	foreign key (user_id) references t_user (id),
	constraint fk_user_role_rold_id
	foreign key (role_id) references t_role (id)
)
	comment '用户角色表'
;

create index fk_user_role_rold_id
	on t_user_role (role_id)
;

create index fk_user_role_user_id
	on t_user_role (user_id)
;

create table t_user_social
(
	id bigint auto_increment comment '第三方登录编号'
		primary key,
	user_id bigint null comment '用户编号',
	openid varchar(200) null comment '第三方登录OAuth openid',
	refresh_token varchar(200) null comment '刷新Token',
	social_type_id bigint null comment '第三方登录类型编号',
	create_time datetime default CURRENT_TIMESTAMP null comment '第三方登录绑定时间',
	update_time datetime null comment '更新时间',
	is_active tinyint default '0' null comment '是否激活',
	constraint fk_user_social_id
	foreign key (user_id) references t_user (id),
	constraint fk_user_social_type_id
	foreign key (social_type_id) references t_social_type (id)
)
	comment '用户第三方登录信息表'
;

create index fk_user_social_id_idx
	on t_user_social (user_id)
;

create index fk_user_social_type_id_idx
	on t_user_social (social_type_id)
;

