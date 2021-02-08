## 使用须知
#### 1.需要在application.yml中添加数据库配置，如下为示例
spring:
  datasource:
      #数据库链接配置
      url: jdbc:mysql://localhost:3306/eshop?useUnicode=true&characterEncoding=utf-8
      username: root
      password: 123456
      driver-class-name: com.mysql.cj.jdbc.Driver
      #数据库连接池配置
      type: com.alibaba.druid.pool.DruidDataSource
      initialSize:  5
      minIdle:  5 #最小空闲链接
      maxActive:  20  #最大活跃链接
      maxWait:  60000 #获取连接等待超时的时间
      timeBetweenEvictionRunsMillis:  60000 #间隔多久才进行一次检测，检测需要关闭的空闲连接
      minEvictableIdleTimeMillis: 300000  #一个连接在池中最小生存的时间
      validationQuery:  SELECT 'x'
      testWhileIdle:  true
      testOnBorrow: true
      testOnReturn: true
      druid:
        remove-abandoned: true
        remove-abandoned-timeout-millis: 1800
        log-abandoned: false
        
mybatis:
  --设置mybatis的mapper文件扫描路径
  mapper-locations: classpath*:mybatis/**/*.xml
  --设置打印sql
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

#### 2.添加maven插件
<plugin>
<groupId>org.mybatis.generator</groupId>
<artifactId>mybatis-generator-maven-plugin</artifactId>
</plugin>

#### 3.将mybatis的xml文件打包到jar中
（使用maven的compile插件需要添加下面配置，而使用springboot的compile插件则不需要加）
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <includes>
            <include>**/*.*</include>
        </includes>
    </resource>
</resources>

## 常见报错
#### Invalid bound statement (not found)
> 原因：这个是没有将mapper和xml绑定关系找到报的错

> 解决方法：1.检查有没有配置mapper扫描xml的路径2.检查@MapperScan是否扫描到了dao3.检查xml与dao是否能对上