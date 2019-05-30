package com.xiaobai.cloudproviderhystrix8083.service.impl;

import com.xiaobai.cloudproviderhystrix8083.dao.DeptDao;
import com.xiaobai.cloudproviderhystrix8083.service.DeptService;
import com.xiaobai.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/26 21:58
 * @since 1.0
 * 业务逻辑具体实现类
 * 请注意，这种方式是不合理的，业务逻辑层应该对数据进行校验/分页/缓存等等操作
 * 这里为了掩饰简单，就没有进行这些操作。
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public Map<String, Object> addDept(Dept dept) {
        HashMap<String, Object> map = new HashMap<>(16);
        if(0 < deptDao.addDept(dept)){
            map.put("code",0);
            map.put("msg","添加成功！");
        }else {
            map.put("code",-1);
            map.put("msg","添加失败");
        }
        return map;
    }

    @Override
    public List<Dept> list() {
        return deptDao.getDeptList();
    }

    @Override
    public Dept getById(String id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public Map<String, Object> modify(Dept dept) {
        HashMap<String, Object> map = new HashMap<>(16);
        if(0 < deptDao.modifyDept(dept)){
            map.put("code",0);
            map.put("msg","修改成功！");
        }else {
            map.put("code",-1);
            map.put("msg","修改失败");
        }
        return map;
    }

    @Override
    public Map<String, Object> delete(String id) {
        HashMap<String, Object> map = new HashMap<>(16);
        if(0 < deptDao.deleteDept(id)){
            map.put("code",0);
            map.put("msg","删除成功！");
        }else {
            map.put("code",-1);
            map.put("msg","删除失败");
        }
        return map;
    }
}
