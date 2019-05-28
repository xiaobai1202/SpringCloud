# cloud-provider
    这是本项目的服务提供者模块（作为一个微服务存在）
    在这个模块中实现了几个接口，用来模拟一个微服务的接口，供外部调用
    该模块模拟的是部门的相关服务
    
####  具体的接口功能请查看DeptController
    @RequestMapping(value = "/list",method = RequestMethod.GET) 查询所有部门
    @RequestMapping(value = "/list/{id}" ,method = RequestMethod.GET) 根据id查一个部门信息
    @PutMapping(value = "/modify") 修改部门信息
    @PostMapping(value = "/add") 添加一个新的部门
    @DeleteMapping(value = "/delete/{id}")  删除一个部门 
    
## 这是一个用来提供接口给别人操作的服务
    这只是一个基本的服务，没有任何生产能力。

# 第二阶段 作为一个微服务注册进Eureka
    进行这一步的前提是我们已经有一个可用的Eureka 服务端供我们注册
   [参考cloud-eureka-7001](https://github.com/811105717/SpringCloud/tree/master/cloud-eureka-7001) 
    
### 配置方式
    1.修改配置文件，在原有依赖的基础上增加Eureka的客户端依赖 
       
    2.修改配置文件，添加关于Eureka的客户端配置
       
    3.在启动类上标注 @EnableEurekaClient 来启动Eureka服务端

## 第三阶段 多个微服务示例共存
    我们知道，为了保证服务的高可用性，实际中不可能一个服务只有一个实例。
    这里我们使用一台主机来模拟多实例
    
    
>   由于我们是模拟分布式搭建（实际都是在一台电脑上完成的），所以我们使用主机映射（不同端口）的模式进行演示
>   ——我们将cloud-provider 复制成三份用来模拟三个服务实例，为了方便我们查看，我将三个模块命名为
>
>   [cloud-provider-8080](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-8080)    
>
>   [cloud-provider-8081](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-8081)
>
>   [cloud-provider-8082](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-8082)
>
>   同时将他们的启动类也更名，加入相应的端口号。

```
注意： 1. 我们每个服务实例之间配置基本相同（理论上也应该是这样的）
      我这里由于是单机演示，所谓需要将每个服务跑在不同的端口上，
      所以我需要配置一下server.port 
      同样的 由于我每个服务使用的是独立的数据库 所以我需要配置
      spring.datasource.url 为需要使用的数据库
      2. 这一点很重要，同一个服务实例的名称必须相同，如果不相同，
      注册中心则会认为这是不同的服务。
```

