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
