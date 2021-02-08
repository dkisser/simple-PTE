## 使用时需要在application.yml中添加dubbo配置，如下为示例

#### Provider配置
server:
  port: 8081 #http服务端口

spring:
  application:
    name: pte-test-provider

dubbo:
  protocol:
    name: dubbo #暴露服务的协议
    port: 20880 #dubbo服务端口
  registry:
    address: zookeeper://127.0.0.1:2181 #注册中心地址
    timeout: 10000  #注册中心超时事件
  scan:
    base-packages: org.wc.test.provider #dubbo扫描包路径（实现类的路径）

#### Consumer配置
server:
  port: 8082 #http服务端口

spring:
  application:
    name: pte-test-consumer

dubbo:
  registry:
    address: zookeeper://127.0.0.1:2181 #注册中心地址
    timeout: 10000  #注册中心超时事件
  consumer:
    check: false #启动时是否检测有provider可用（没有provider可用会报错）
  scan:
    base-packages: org.wc.test.common.dubbo #dubbo扫描包路径（接口的路径）