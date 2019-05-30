package com.xiaobai.cloudproviderhystrix8083.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xiaobai.cloudproviderhystrix8083.service.DeptService;
import com.xiaobai.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/26 21:52
 * @since 1.0
 * 访问控制类controller
 * 这是服务端的controller
 */
@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> deptList(){
        return deptService.list();
    }

    /**
     * 通过id查找系部的控制器方法
     * 该方法绑定了熔断机制 @HystrixCommand(fallbackMethod = "exceptionBack") 的意思就是说当方法出现异常或错误时
     * 会去调用exceptionBack 方法，而不是崩溃或未响应
     * @param id 被查询的系部id
     * @return 查找到的系部
     */
//    @HystrixCommand(fallbackMethod = "exceptionBack")
    @RequestMapping(value = "/list/{id}" ,method = RequestMethod.GET)
    public Dept findDeptById(@PathVariable("id") String id){
        Dept dept = deptService.getById(id);
        if(null == dept){
            throw new RuntimeException("未找到对象");
        }
        return dept;
    }

    /**
     * 用于服务熔断的方法！
     * @param id 系部id
     * @return 可预期的结果
     */
    @SuppressWarnings("all")
    public Dept exceptionBack(@PathVariable("id")String id){
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("抱歉，没有查询到"+id+"所对应的系部！");
        return dept;
    }

    @PutMapping(value = "/modify")
    public Map<String,Object> modifyDept(Dept dept){
        System.out.println(dept);
        return deptService.modify(dept);
    }

    @PostMapping(value = "/add")
    public Map<String,Object> addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Map<String,Object> deleteDept(@PathVariable("id") String id){
        return deptService.delete(id);
    }
}
