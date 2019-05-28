package com.xiaobai.cloudprovider.controller;

import com.xiaobai.cloudprovider.service.DeptService;
import com.xiaobai.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/list/{id}" ,method = RequestMethod.GET)
    public Dept findDeptById(@PathVariable("id") String id){
        return deptService.getById(id);
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
