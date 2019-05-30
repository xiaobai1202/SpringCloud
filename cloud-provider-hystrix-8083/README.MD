# cloud-provider-hystrix
    这个是添加了熔断机制的微服务，目的就是当该服务某个功能不可用的时候，并不是未响应或者异常
    而是通过熔断机制熔断该请求，返回一个可以预期的结果。
    说白了就是避免死等耗费资源而导致出现“服务雪崩”问题
    
####  具体的接口功能请查看DeptController
    @RequestMapping(value = "/list",method = RequestMethod.GET) 查询所有部门
    @RequestMapping(value = "/list/{id}" ,method = RequestMethod.GET) 根据id查一个部门信息
    @PutMapping(value = "/modify") 修改部门信息
    @PostMapping(value = "/add") 添加一个新的部门
    @DeleteMapping(value = "/delete/{id}")  删除一个部门
    
    其中还有一个方法exceptionBack 用来进行服务熔断调用 
    
    
##   配置方式
     1.首先在pom文件中引入依赖 pring-cloud-starter-netflix-hystrix
     
     2.然后我们在启动类上面打上注解 @EnableCircuitBreaker 来启用服务熔断机制
     
     3.在对应的服务控制器方法上面打上@HystrixCommand(fallbackMethod = "调用方法名")
       来配置当调用该控制器方法出现问题的时候需要调用的方法。
      （请查看源码，出现错误的时候一定要抛出异常，否则就不起作用了）
     4.编写在服务出错的时候需要调用的方法，注意方法的方法名必须与fallbackMethod 指定的方法名相同
     
## 第二阶段  服务降级
    
    所谓服务降级，其实就是当系统资源不足或不足以支撑太高的并发的时候，将一些暂时不使用或者使用较少的服务
    关闭，若有请求过来，直接返回一个有好的不可访问的提示。
    
    其实我们如果使用服务熔断的方式进行服务降级的话也可以，只是每一个controller中的控制器方法都要对应一个
    fallbackMethod方法，这样做代码比较乱，而且耦合度也比较高。于是，我们这里使用FallBacyFactory接口
    来实现，具体请看源代码 
    
    当然，由于服务降级是实现在接口方法中的，对所有的controller控制器方法都起作用，所以我们将它放在
    cloud-common 公共模块中
   请参考 [cloud-common 公共模块](https://github.com/811105717/SpringCloud/tree/master/cloud-common)
   
####  配置方式
    1. 在公共模块中新建包fallback 在包中新建一个类 DeptFallback 实现FallbackFactory
    2. 在公共模块中的接口包中要降级的服务接口上标注注解@FeignClient 指定微服务的同时也要指定
       降级类（fallbackFactory）
    3. 在消费端修改yml 配置 fegin.hystrix.enabled = true 表示开启服务降级
    4. 这一点很重要！！ 要在我们的客户端启动类上面使用@ComponentScan 扫描FallbackFactory实现
       类所在的包！一定要扫描 否则就会提示注入失败！(注意，一旦我们使用了这个注解，则组合注解
       @SpringBootApplication 注解中的@ComponentScan就失效了，我们需要在我们自己的@ComponentScan
       中加上我们当前项目需要扫描的包！！！)
     
   请注意，这里的演示涉及到 [cloud-common 公共模块](https://github.com/811105717/SpringCloud/tree/master/cloud-common) [cloud-consumer-fegin-82 模块](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-fegin-82) 和 [cloud-provider-hystrix-8083 熔断服务提供者模块](https://github.com/811105717/SpringCloud/tree/master/cloud-provider-hystrix-8083)
   
## 第三阶段 服务监控 
    为了更好地监控每一个服务的健康状态，我们可以使用hystrix自带的服务监控程序，这里我们配置一种最简单的监控程序
#### 配置方式
    1. 在pom文件中加入 actuator 的依赖
    2. 在启动类要启用服务熔断机制 @EnableCircuitBreaker
    3. 我们需要在配置类中配置一个bean 这里我配置在启动类中，具体请查看启动类
    
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
    
    4. 在要启用服务监控的控制器方法上打上@HystrixCommand 注解，当负载均衡访问到这个方法的时候就会qidongjianshi
    
   互相配置依赖请参考 [cloud-hystrix-dashboard-9090](https://github.com/811105717/SpringCloud/tree/master/cloud-hystrix-dashboard-9090)        
