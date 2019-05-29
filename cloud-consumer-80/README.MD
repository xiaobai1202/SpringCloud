# cloud-consumer
    这是本项目的服务消费者模块（作为一个微服务存在）
    目的是为了模拟服务间的调用关系和对外接口的调用关系
    该模块模拟的是服务间的调用和外部调用
    （由于是演示消费者，所以这里比较懒 直接在controller里面调用其他服务 当然这是不合理的）
####  具体的接口功能请查看DeptController
    @GetMapping("/list")  部门列表  调用provider 接口获取
    @GetMapping("list/{id}") 根据id 查部门  调用provider 接口获取
    @PostMapping("/add")  添加新部门 调用provider 接口获取
    @PutMapping("/modify")  修改部门  调用provider 接口获取
    @DeleteMapping("/delete/{id}") 删除部门 调用provider接口获取 
    
## 该部分主要使用的RestTemplate进行服务调用，演示了如何通过RestTemplate进行服务间的调用
   这是一个基本的服务，仅作为演示使用。没有任何生产能力

#  第二阶段 将消费者作为一个服务注册进Eureka 
    请注意，我们这里指的消费者并不是终极消费者——他有可能是其他服务的服务提供者
    也就是说，它在作为消费者的同时，还有可能是其他服务的服务提供者，只是我们这
    里的示例项目看起来像是该服务仅仅作为消费者存在。
    
>   进行这一步的前提是我们已经有一个可用的Eureka 服务端供我们注册
>   
>   [参考cloud-eureka-7001](https://github.com/811105717/SpringCloud/tree/master/cloud-eureka-7001) 
        
### 配置方式
        1.修改配置文件，在原有依赖的基础上增加Eureka的客户端依赖 
           
        2.修改配置文件，添加关于Eureka的客户端配置
           
        3.在启动类上标注 @EnableEurekaClient 来启动Eureka服务端
>   请注意：这时我们只是配置了服务注册进入eureka，并不能通过服务名称进行访问。
>
>   早期的SpringCloud Eureka 是允许注册后直接进行访问的，但最新版本为了更好的服务架构考虑，不允许我们不经过负载均衡就
>   对服务进行访问（当然也有一些安全原因），如果你现在直接通过服务名进行访问，那么很有可能会遇到 ``` java.net.UnknownHostException 异常 ```

   我们应该通过  [带有负载均衡的客户端](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-ribbon-81) 进行访问