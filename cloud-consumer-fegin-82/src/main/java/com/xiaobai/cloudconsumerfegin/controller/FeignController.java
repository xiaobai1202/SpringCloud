package com.xiaobai.cloudconsumerfegin.controller;

import com.xiaobai.entity.Dept;
import com.xiaobai.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/29 14:47
 * @since 1.0
 * 用来进行服务调用的Controller
 */
@RestController
@RequestMapping("/fegin")
public class FeignController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/list/{id}")
    public Dept getById(@PathVariable("id") String id){
        return deptService.getDeptById(id);
    }
/**
 * 请注意  由于我们没有配置RestTemplate 模板 导致对象映射失败 所以下面复杂对象的请求应该是不成功的
 */
//    @PutMapping("/modify")
//    public Map<String,Object> modify(Dept dept){
//        return deptService.modifyDept(dept);
//    }
//
//    @PostMapping("/add")
//    public Map<String,Object> add(Dept dept){
//        return deptService.addDept(dept);
//    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id")String id){
        return deptService.deleteDept(id);
    }

}
