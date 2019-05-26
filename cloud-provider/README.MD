#cloud-provider
    这是本项目的服务提供者模块（作为一个微服务存在）
    在这个模块中实现了几个接口，用来模拟一个微服务的接口，供外部调用
    该模块模拟的是部门的相关服务
    
####  具体的接口功能请查看DeptController
    @RequestMapping(value = "/list",method = RequestMethod.GET) 查询所有部门
    @RequestMapping(value = "/list/{id}" ,method = RequestMethod.GET) 根据id查一个部门信息
    @PutMapping(value = "/modify") 修改部门信息
    @PostMapping(value = "/add") 添加一个新的部门
    @DeleteMapping(value = "/delete/{id}")  删除一个部门 
    