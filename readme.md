# 研开后端

### java版本 java23
### 采用mybatis
### 使用@Slf4j注解，log.info()记录日志
### 项目文件结构
```
config springboot配置
controller - service - mapper - entity 结构
复杂的sql、动态sql写在mapper.xml中
template 用于存放导出文件的模板
task 定时任务
util 工具类
dto 用于接受前端传来的数据
vo 用于返回给前端的数据
exception 异常处理
Result 返回给前端的数据格式
```
