# zywork-app

*王振宇*

zywork-app是基于SpringBoot，SpringCloud，SpringSecurity，MyBatis的快速开发系统。

建议使用IntellijIDEA集成开发工具。

zywork-app依赖于zywork-common（[https://github.com/gz-zywork/zywork-common](https://github.com/gz-zywork/zywork-common)）项目，zywork-common需要自行mvn install。

zywork-common项目依赖了zywork-sdk（[https://github.com/gz-zywork/zywork-sdk](https://github.com/gz-zywork/zywork-sdk)）中的微信支付SDK，微信支付SDK需要自行mvn install。

#### 使用的技术
1. Maven
2. SpringBoot
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
```http://localhost:8088/druid/index.html``` 请修改成自己配置的端口号

#### API接口测试
```http://localhost:8088/swagger-ui.html``` 请修改成自己配置的端口号

#### 第三方SDK说明
微信支付SDK，阿里云短信，阿里云邮件推送相关配置请自行修改

#### 目前已实现并测试的功能

1. 基于SpringSecurity与JWT的用户认证及权限验证，适配任何前端
2. 基于自定义注解```@SysLog```的系统详细日志记录
3. 使用JSON的系统配置存储，如API相关配置等
3. 用户邮箱加邮箱验证码注册，用户手机号加手机验证码注册
4. 用户邮箱或手机号加密码登录，用户手机号加手机验证码登录，微信授权登录
5. 用户登录密码和支付密码的邮箱重置、手机验证码重置
6. 用户登录密码和支付密码更新
7. 用户详情信息，用户角色信息，用户第三方登录信息
8. 用户银行卡管理，根据卡号判断银行卡是否合法及获取银行卡相关信息
8. 用户钱包信息，用户充值，用户提现申请、审核、人工完成提现（暂未对接第三方支付系统提现）

#### 支持与赞赏
![支持与赞赏](documents/wxpay.jpg)

