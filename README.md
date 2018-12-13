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

#### API接口测试
```http://localhost:8088/swagger-ui.html``` 请修改成自己配置的端口号地址

#### 第三方SDK说明
微信支付SDK，阿里云短信，阿里云邮件推送相关配置请自行修改

