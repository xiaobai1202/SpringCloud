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
