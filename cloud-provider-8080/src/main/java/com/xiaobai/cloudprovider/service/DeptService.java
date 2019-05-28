package com.xiaobai.cloudprovider.service;


import com.xiaobai.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/26 21:53
 * @since 1.0
 * 业务逻辑方法规范接口
 */
public interface DeptService {
    /**
     * 添加一个新的部门
     * @param dept 新部门
     * @return 添加结果
     */
    Map<String, Object> addDept(Dept dept);
    /**
     * 获取部门列表
     * @return 部门列表（List）
     */
    List<Dept> list();

    /**
     * 根据Id 获取部门
     * @param id 部门id
     * @return 部门
     */
    Dept getById(String id);

    /**
     * 修改部门信息
     * @param dept 部门（新部门信息 id不可变）
     * @return  修改结果
     */
    Map<String, Object> modify(Dept dept);

    /**
     * 删除部门
     * @param id 要删除的部门id
     * @return 结果
     */
    Map<String, Object> delete(String id);
}
