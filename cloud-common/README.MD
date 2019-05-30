#cloud-common
    这是本项目的公共部分，用来保存项目中其他模块需要用到的诸如实体类、工具类、甚至调用接口等。
    
    我们应该使用这种方式：将大家共同使用的实体或工具放在这个模块中，这样可以做到一次创建多处使用，
    而不是每个服务都要创建属于自己的实体类或者工具类（浪费大量的时间，依赖关系也不好整理）。
    
## 目前该模块中存在的实体类或工具类：
    clouddb01.sql  
    clouddb02.sql  
    clouddb03.sql  当前项目使用的数据库（.sql文件) 三个服务使用三个不同的数据库
   1. com.xiaobai.entity.Dept  ———— 由IDEA 的数据库插件自动生成的实体类 对应dept表
   2. com.xiaobai.service.DeptService 接口  用于Fegin的请求使用，Fegin通过这个
       接口对微服务进行调用, 请参考 [cloud-consumer-fegin-82](https://github.com/811105717/SpringCloud/tree/master/cloud-consumer-fegin-82)
   
   3. com.xiaobai.fallback.DeptFallback 类   用于实现服务降级的备选返回类
