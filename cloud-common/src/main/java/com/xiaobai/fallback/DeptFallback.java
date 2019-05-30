package com.xiaobai.fallback;

import com.xiaobai.entity.Dept;
import com.xiaobai.service.DeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/30 10:45
 * @since 1.0
 * 用于服务降级的类
 */
@Component
public class DeptFallback implements FallbackFactory<DeptService> {
    public DeptService create(Throwable throwable) {
        return
                new DeptService() {
                    public List<Dept> list() {
                        ArrayList<Dept> list = new ArrayList<Dept>(16);
                        Dept dept = new Dept();
                        dept.setDname("抱歉，服务处于降级模式，暂时不能对外提供服务！");
                        list.add(dept);
                        return list;
                    }

                    public Dept getDeptById(String id) {
                        Dept dept = new Dept();
                        dept.setDname("抱歉，服务处于降级模式，暂时不能对外提供服务！");
                        return dept;
                    }

                    public Map<String, Object> modifyDept(Dept dept) {
                        return message();
                    }

                    public Map<String, Object> addDept(Dept dept) {
                        return message();
                    }

                    public Map<String, Object> deleteDept(String id) {

                        return message();
                    }

                    /**
                     * 用于返回 Map类型的消息 由于要写三次 抽成方法 写一次 调用三次
                     * @return Map结果
                     */
                    private Map<String,Object> message(){
                        HashMap<String, Object> map = new HashMap<String, Object>(16);
                        map.put("code",-1);
                        map.put("msg","抱歉，服务处于降级模式，暂时不能对外提供服务！");
                        return map;
                    }
                };
    }
}
