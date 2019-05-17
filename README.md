# shardingjdbc 写分离实现（中间层Sharding-JDBC）实现
   
## 引入maven依赖
```
<dependency>
    <groupId>org.apache.shardingsphere</groupId>
    <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
    <version>LATEST</version>
</dependency>
```
## Spring Boot配置
```
spring:
  main:
    # 允许覆盖注册
    allow-bean-definition-overriding: true
  shardingsphere:
    props:
      sql:
        show: true
    datasource:
      # 数据源名称，多数据源以逗号分隔
      names: ds-master-0,ds-master-0-slave-0,ds-master-0-slave-1
      ds-master-0:
        # 数据库连接池类名称
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://192.168.3.10:3306/demo?useSSL=false&serverTimezone=Asia/Shanghai
        username: root
        password: root
      ds-master-0-slave-0:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://192.168.3.11:3306/demo?useSSL=false&serverTimezone=Asia/Shanghai
        username: root
        password: root
      ds-master-0-slave-1:
        type: com.zaxxer.hikari.HikariDataSource
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://192.168.3.12:3306/demo?useSSL=false&serverTimezone=Asia/Shanghai
        username: root
        password: root
    # 读写分离配置
    masterslave:
      # 负载均衡 可选值：ROUND_ROBIN，RANDOM
      load-balance-algorithm-type: round_robin
      name: ds_ms
      master-data-source-name: ds-master-0
      slave-data-source-names: ds-master-0-slave-0,ds-master-0-slave-1
```
