# cloud-consumer-feign
    fegin是用来进行服务调用的组件，他会自动帮我们配置RestTemplate和Ribbon，进行负载均衡
    的服务调用，当然我们也可以自定义RestTemplate和Ribbon的负载均衡算法
    
    当然使用Fegin的前提是将服务注册到注册中心（以后所有的服务都应该是被注册到注册中心的）
#### 一些说明
    
    这里我使用的是公共接口模式，也就是说每个微服务都要在 cloud-common 服务下有一个服务接口，
    接口内定义的就是该服务向外暴露的全部接口，feign只需要通过调用这个接口内规定的方法，就可以
    访问对应的服务接口。
### 配置
    1. 首先，我们需要在cloud-common的pom文件中引入Fegin的依赖
       然后，在cloud-common模块中新建一个包，包中新建一个接口（这个接口每个方法上需要有一个@RequestMapping
       注解，用来指定访问的微服务请求接口（注意是微服务请求接口））。
       在接口上面我们也需要打一个注解@FeignClient(value = "服务名") 来将这个接口与服务进行绑定
    
    2. 在我们的服务消费端主启动类上面标注@EnableFeignClients注解来启用Fegin，同时我们需要制定一下
        Fegin扫描接口的包名（只有指定了包名，Fegin才能找到该使用的接口）
    
    3. 如果我们需要自定义Irule规则或者RestTemplate的话，就在启动类中@Bean或者自己编写一个配置类来生成Bean
        （我这里使用的是自定义配置类生成Bean）

###  测试

    我们在Controller中注入一个预定接口（即cloud-common中定义的接口），通过调用接口的方法，
    就可以访问我们的微服务了。
   具体请参看该模块源码和 [cloud-common 公共模块源码](https://github.com/811105717/SpringCloud/tree/master/cloud-common) 中的service包
          
      