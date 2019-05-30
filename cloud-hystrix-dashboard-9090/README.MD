# cloud-hystrix-dashboard
    该服务是用于监控其他服务而使用的，他有一个可视化的面板用来监控每一个进行负载均衡和服务熔断机制的服务
    

### 配置方式
    1. pom文件加入hystrix 、 actuator 和 hystrix-dashboard的依赖
    2. 启动类标注上 EnableHystrixDashboard 来启动监视功能
    3. application.yml 文件中配置一下端口即可
    
   联合配置要求进行负载均衡和服务熔断的服务进行一些配置 请参考 [cloud-provider-hystrix-8083](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-hystrix-8083)


   