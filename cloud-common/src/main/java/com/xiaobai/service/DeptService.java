package com.xiaobai.service;

import com.xiaobai.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/29 14:52
 * @since 1.0
 * 用于fegin访问的接口规范
 */
@FeignClient(value = "CLOUD-PROVIDER")
public interface DeptService {
    /**
     * 获取部门列表
     * @return 部门列表
     */
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> list();

    /**
     * 根据部门id获取部门
     * @param id 部门id
     * @return id 对应的部门
     */
    @RequestMapping(value = "/dept/list/{id}" ,method = RequestMethod.GET)
    Dept getDeptById(@PathVariable("id") String id);

    /**
     * 修改部门信息
     * @param dept 修改的部门
     * @return 修改的结果
     */
    @PutMapping(value = "/dept/modify")
    Map<String,Object> modifyDept(Dept dept);

    /**
     * 添加新部门
     * @param dept 部门编号
     * @return 添加结果
     */
    @PostMapping(value = "/dept/add")
    Map<String,Object> addDept(Dept dept);

    /**
     * 删除部门
     * @param id 被删除部门的id
     * @return
     */
    @DeleteMapping(value = "/dept/delete/{id}")
    Map<String,Object> deleteDept(@PathVariable("id") String id);
}
