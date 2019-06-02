# SpringCloud

 这是一个示例项目，包含了Spring Cloud 的常用组件，目前已经更新到配置中心。
 
## 当前已经更新的模块有：
  [1. cloud-common 公共模块](https://github.com/811105717/SpringCloud/tree/master/cloud-common)
  
    公共模块，是所有服务都需要访问的模块，比如放一些公共的工具类，或者问服务的访问接口等 
    
  [2. cloud-provider 服务提供者模块](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-8080)
  
    服务提供者模块，用来模拟向外提供服务的模块，一般情况下该服务是多实例集群
    （请注意，服务提供者同时也有可能是服务消费者，服务之间关系时密切的，并不是无关的）

  [3. cloud-consumer 服务消费者模块](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-80)
  
    服务消费者模块，用来模拟消费者访问其他模块，一般情况下也是多实例集群
    （同样的，消费者也可能是服务提供者被其他服务调用，他们的本质都是一个微服务）
  
  [4  cloud-eureka  服务注册中心模块](https://github.com/811105717/SpringCloud/tree/master/cloud-eureka-7001)
  
    注册中心，用来管理所有的微服务，所有的微服务都要注册到注册中心，同时他们访问其他的
    微服务也要通过注册中心进行查找
  
  [5  cloud-provider-ribbon 负载均衡模块](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-ribbon-81)
  
    在注册中心一般每个微服务都存在多个实例，在很短的一段时间内，可能某一个微服务实例的并发量很大，
    而另一个实例并发；量很小甚至没有访问，为了避免这种情况，就用到了负载均衡模块，有了负载均衡，我
    们可以根据不同的算法，让每一个微服务都被均匀的访问到，尽量避免一个微服务压力过大或者很少访问的
    情况。
  
  [6  cloud-provider-feign 负载均衡模块（高级）](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-feign-82)
  
    这个服务本质上与ribbon没有什么太大的区别，它是将ribbon与RestTemplate封装好，使服务直接通过接口
    进行调用，简化开发方式
  
  [7  cloud-provider-hystrix-8083 服务熔断与降级模块](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-hystrix-8083)

    有些时候可能有一个微服务发生了故障，导致未响应等情况，但是其他微服务并不知道该服务发生异常，
    还继续向该服务发出请求，由于依赖关系，可能导致所有调用该服务的模块都会发生异常（得不到该服务
    的相应可能会一致等待等），在高并发的情况下会很快耗尽系统资源，导致系统崩溃。为了避免这种情况
    的发生，就有了服务熔断机制，当一个服务发生问题时，使用熔断机制快速的返回一个不可用或异常标识，
    其他服务在调用时收到该标识就应该知道该服务出现了问题，就会尽量避免调用该服务。
    
    所谓服务降级是指当系统的资源紧迫时，人为关闭一些不重要的服务，等到系统资源充足时，再启用这些
    服务。 这些被关闭的服务我们称之为 被降级的服务（现在一般都是自动降级）

  [8  cloud-hystrix-dashboard-9090 服务监视模块](https://github.com/811105717/SpringCloud/tree/master/cloud-hystrix-dashboard-9090)
  
    由于分布式系统一般都很庞大，直接监视每一台服务器代价太大，Hystrix-Dsahboard为我们提供了一个
    可视化的服务监控界面，我们只需要知道服务的地址，就可以监控服务当前的状态，比如服务并发压力，调用
    次数，调用成功与失败的次数等等。
  
  [9  cloud-gateway-zuul-1202 网关模块](https://github.com/811105717/SpringCloud/tree/master/cloud-gateway-zuul-1202)

    为了安全和一些其它情况的考虑，我们系统内部是可以直接通过微服务名称或者直接url进行访问的，但是对
    于外部来说，直接暴露微服务或者直接地址是不好的。于是我们可以通过网关进行转发，对外只暴露允许访问
    的接口。同时网关还可以过滤请求。（三大功能：代理+过滤+路由）

  [10 cloud-config-1213 配置中心模块](https://github.com/811105717/SpringCloud/tree/master/cloud-config-1213)
  
    对于分布式的系统来说，每个微服务的实例都是在不同的机器上，或者一台机器跑着多个微服务实例，而每一
    个微服务的实例配置基本相同。当我们需要修改一些配置的时候，需要到每一个实例上进行修改，代价很大，于
    是就有了配置中心这个概念，每一个微服务都需要到配置中心获取自己的配置，而不是在本地进行配置，所有的
    配置文件都可以通过配置中心找到，我们修改只需要在仓库进行修改，配置中心会自动读取分发到微服务。
  
  [11 cloud-config-consumer-83 基于配置中心的服务模块](https://github.com/811105717/SpringCloud/tree/master/cloud-config-consumer-83)
    
    这是一个简单的微服务，用来演示如何使用配置中心进行配置，具体请看该服务的README
    使用配置中心的微服务的启动前提是他所使用的配置中心微服务已经启动并且可以服务。
    
  
  后续我还会继续更新其他相关模块。