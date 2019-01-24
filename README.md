# zywork-app

*王振宇*

zywork-app是基于SpringBoot，SpringCloud，SpringSecurity，MyBatis，Druid，Redis的快速开发系统，并使用SpringBoot Admin Server进行项目监控。

建议使用IntellijIDEA集成开发工具。

zywork-app依赖于zywork-common（[https://github.com/gz-zywork/zywork-common](https://github.com/gz-zywork/zywork-common)）项目，zywork-common需要自行mvn install。

zywork-common项目依赖了zywork-sdk（[https://github.com/gz-zywork/zywork-sdk](https://github.com/gz-zywork/zywork-sdk)）中的微信支付SDK，微信支付SDK需要自行mvn install。

#### 官方网站及在线体验
[赣州智悦科技-zywork.top](http://zywork.top)

#### 使用的技术
1. Maven
2. SpringBoot
3. SpringBoot Admin
4. SpringCloud
3. SpringSecurity
4. JWT
5. MyBatis
6. Druid
7. MySQL
8. Redis
9. Slf4j & Logback
10. Swagger2
11. 微信支付SDK
12. 阿里云短信API
13. 阿里云邮件推送API

#### 需要的服务器
1. MySQL8
2. Redis5

#### 数据库脚本
```documents/zywork_app.sql``` 只包含数据库结构 

```documents/zywork_app_data_test.sql``` 包含有数据库结构和测试数据

#### Druid数据监控
```http://localhost:8088/druid/index.html```

#### API接口测试
```http://localhost:8088/swagger-ui.html```

#### SpringActuator系统监控及SpringBoot Admin
```http://localhost:8088/actuator/*``` *部分请自行替换

```http://localhost:8086``` clone并运行zywork-app-admin项目

#### 第三方SDK说明
微信支付SDK，阿里云短信，阿里云邮件推送相关配置请自行修改

#### 目前已实现并测试的功能

1. 基于SpringSecurity与JWT的用户认证及权限验证，适配任何前端，可支持多个端同时登录同一账号
2. 实现了使用JWT注册登录的新增用户统计与日活跃用户统计功能，并可保存日活数据到数据库中
2. 基于自定义注解```@SysLog```的系统详细日志记录
3. Redis缓存的后台界面管理，如查询缓存，删除缓存
4. 定时任务管理，与SpringBoot整合，通过后台页面启动，暂停，恢复，停止或删除定时任务
4. SpringBoot Admin Server项目监控
3. 使用JSON的系统配置存储，如API相关配置等
4. 数据表增加```version```版本号字段，使用乐观锁机制解决高并发情况下更新表记录时数据一致性问题
3. 用户邮箱加邮箱验证码注册，用户手机号加手机验证码注册，可选填注册邀请码
4. 用户邮箱或手机号加密码登录，用户手机号加手机验证码登录
5. ```微信公众号```授权登录，```微信小程序```授权登录并获取绑定手机号
5. 用户登录密码和支付密码的邮箱重置、手机验证码重置
6. 用户登录密码和支付密码更新
7. 组织部门管理，用户隶属于指定的组织机构，用户组织部门查询
7. 用户详情信息，用户角色信息，用户第三方登录信息
8. 系统模块管理，模块权限管理，角色权限管理及分配，支持导入、导出角色信息，支持导入、导出角色权限配置信息
8. 用户银行卡管理，根据卡号判断银行卡是否合法及获取银行卡相关信息，绑定银行卡，解除绑定银行卡
8. 用户钱包信息，用户充值及充值记录，用户提现申请及提现记录、提现审核、人工完成提现（暂未对接第三方支付系统提现），用户转账及转账记录
9. 余额支付，微信公众号支付，微信小程序支付，微信公众号发送红包
9. 用户账目详情，记录每一笔资金变更
10. 用户收货地址管理，添加、删除、设置默认收货地址，查询收货地址等
10. 用户注册邀请二维码和邀请链接生成，通过邀请二维码或邀请链接注册时可自动填写邀请码。可生成```带logo图片的二维码```
11. 用户注册时，若填写了正确的邀请码，则记录用户层级关系及用户路径。如果是普通用户，可用于邀请注册时按分销模式发放邀请奖励
12. 实现了部分分销代码，可支持```N级分销```，并可配置。功能包括获取顶级分销商，获取指定分销商的上下K级分销商，获取指定用户所在的用户路径等
13. 系统消息管理（消息发送给指定的用户），用户消息查询，系统公告管理（所有用户可看）
14. 文件上传工具类及文件上传示例，可支持图片压缩

#### zywork-app在线体验发布日志
1. V1.0.0，2019-01-22 22:45

#### 支持与赞赏
![支持与赞赏](documents/wxpay.jpg)

