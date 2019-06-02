# cloud-gateway-zuul

    该模块是用来进行网关访问的模块，他可以起到代理、过滤和路由等功能，有了他，
    我们就不再需要每次直接访问我们的服务了，而是直接访问网关的一个请求地址，
    由网关进行处理和转发。这样内部的服务对于用户来说是隐藏的。同时，网关还有
    过滤请求等功能。
 
## 配置方式
    1. pom 中添加网关和eureka客户端依赖
    2. 配置yml文件
        第一步：配置eureka注册就不描述了，前面的模块中都有
        第二步： 配置网关：
            zuul:
              ignored-services: "*" #不允许使用服务名访问
              routes:
                dept:
                  path: /dept/** #请求路径前缀 这里的意思是/dept/的所有请求
                  serviceId: cloud-comsumer-fegin  #要转发的服务
              host:  #设置超时时间 如果不设置  会导致访问失败
                connect-timeout-millis: 4000
                socket-timeout-millis: 4000
            ribbon: #设置超时时间  要比 zuul 的大
              ConnectTimeout: 5000
              ReadTimeout: 5000
        第三步：配置启动类
            在启动类上打注解@EnableEurekaClient 启动Eureka客户端
            在启动类上打注解@EnableZuulProxy 启动zuul网关  

