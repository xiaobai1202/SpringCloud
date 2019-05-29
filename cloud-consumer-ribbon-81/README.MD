# cloud-consumer-ribbon
    
### 带有负载均衡的客户端  
    这是本服务的第二阶段，在这个阶段中，我们已经将所有的微服务全部注册进的Eureka注册中心
    我们知道，对于每一个微服务都不是仅仅只有一个实例存在的，而是多个实例同时存在来应对高并
    发和高吞吐量，那么就需要一个工具来进行负载均衡（即分配每一个请求到每一个实例，保证每个
    实例既不空闲，也不会由于请求太多而压力太大）。我们的Ribbon就是进行负载均衡的一个技术
    
>   使用Ribbon 的前提是服务已经全部注册进Eureka注册中心
>   
>   具体请参考阶段一的 [cloud-provider-8080](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-8080) 是怎么注册进Eureka的
>
>   同理也要求我们的服务消费端也要注册到相同的注册中心中（否则我们是无法找
    到其他服务的）。请参考 [cloud-consumer-80](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-80) 的注册方式
    
####   配置方式
    1. 首先 要求我们的服务和我们需要使用的服务在同一个注册中心注册
    2. 我们要在启动类上面标注@RibbonClient("服务名称")来指定我们要使用的服务（可以多个）
    3. 我们在使用RestTepmlate 进行访问的时候要访问服务名称而不是服务的地址（很重要）
    
    如果我们配置正确的话，在访问时，就可以看到负载均衡的结果
    （我这里每个服务是不同的数据库，可以看到查询出来的数据是来自不同的数据库的）
    
### 负载均衡算法
    Ribbon 为我们定义了7个负载均衡算法，我们可以直接使用，也可以修改定义好的负载均衡
    算法，实现我们自定义的算法。下面先说一下这7个算法所在的类：
    1. RoundRibbonRule ： 轮询算法   按顺序依次访问 头尾相接
    2. RandomRule ： 随机算法  从可用微服务中随机选择一个微服务调用
    3. AvailabilityFilterRule： 过滤掉高并发和故障的服务后 从剩下的进行轮询
    4. WeightedResponseTimeRule：根据平均响应时间计算权重 权重较大的被访问的概率较高
    5. RetryRule： 先轮询，如果失败则重试
    6. BestAvailableRule： 过滤掉高并发和故障的，然后选择并发最小的
    7. ZoneAvoidanceRule： 默认方式 复合判断server所在的区域性能和可用性
    
   具体源码请看这里：[IRule源码](https://github.com/Netflix/ribbon/tree/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer)
   
    配置方式：在客户端启动类或者配置类中，new一个IRule的Bean交给spring容器即可
   
   自定义轮询路由规则：
    
    自定义轮询规则也很简单——我们只需要自定义一个类，然后让这个类继承 AbstractLoadBalancerRule
    并重写其中的 public Server choose(ILoadBalancer lb, Object key) 方法，加上我们自己的
    定义即可。
    
    不过使用自定义均衡规则有几点需要注意的注意事项：
        1. 该类一定不要在@ComponentScan能扫描的包下，如果在其能扫描的包下的话，就会被用作全局规则
        2. 一定要继承AbstractLoadBalancerRule 类 而不是IRule
        3. 配置类的返回值是IRule  而不是 AbstractLoadBalancerRule
        请参考包 ribbon 
        