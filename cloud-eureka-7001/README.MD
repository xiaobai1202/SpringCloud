# cloud-eureka 
    服务注册中心，所有的服务都将在注册中心进行注册，由注册中心进行管理，其他服务
    进行服务间调用的时候也需要到服务注册中心进行查询可用服务，然后再进行访问
##  这只是一个简单的注册中心示例
    我们首先要在我们的系统中配置主机名映射：
    windows ： C:/windows/system32/drivers/etc 下有一个hosts文件，需要管理员权限打开
    linux/unix： 编辑 /etc/hosts 文件
    
    在文件中加入这样一句话：
    127.0.0.1   eureka7001.com  
    然后保存  
    
    这样做的目的是为了模拟分布式（后面我们会用到），当我们在hosts文件中配置这样一句话以后，我们访问eureka7001.com
    时会自动映射ip地址为 127.0.0.1  （当然如果你有多台服务器或电脑的话，也可以不配置hosts，使用真实的分布式模式，
    利用ip地址进行访问）
    
    哦对了，不要忘记在启动类上标注@EnableEurekaServer注解来启动Eureka服务
    
    若启动成功的话  访问 eureka7001.com:7001 可以看到Eureka的界面
    （仅限本示例项目，你应该访问的是Eureka所在的服务器+端口）
    
>   配置好Eureka的Server端，我们就需要将服务注册进来，所以我们还要对我们的服务进行一些修改

    由于Eureka是 C/S 架构，所以我们需要在服务端加入Eureka客户端的依赖并启动
    若启动成功，我们在Eureka的界面应该可以看到我们注册的服务
    
>   至此，我们的Eureka服务端已经搭建好，并且服务端通过Eureka Client可以进行注册
    其实Eureka中的知识还有很多 例如自我保护模式等 具体请参考  [官方文档](https://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)

