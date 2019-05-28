package com.xiaobai.cloudcomsumer.controller;

import com.xiaobai.entity.Dept;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

/**
 * @author xiaobai
 * @date 2019/5/26 22:36
 * @since 1.0
 * 客户端服务 用来调用服务端
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    /**
     * 服务地址
     *
     * 第一阶段的RestTemplate 由于没有使用Eureka注册中心  直接IP访问
     * private static final String PREFIX = "http://127.0.0.1:8080/dept";
     * 第二阶段的RestTemplate 使用Eureka注册中心  直接通过服务名进行访问
     */
    private static final String PREFIX = "http://cloud-provider/dept";
    /**
     * 拿到Restmplate  官方文档中有提到，容器中没有为我们配置任何一个RestTemplate 需要我们自己配置或者builder
     * 这里我们直接使用builder build出来一个使用，具体的配置方式与其他个性化配置基本相似 这里不再描述
     * 具体请参考： https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/htmlsingle/#boot-features-resttemplate
     */

    private final RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/list")
    @SuppressWarnings("unchecked")
    public List<Dept> listDept(){
        return restTemplate.getForObject(PREFIX+"/list",List.class);
    }

    @GetMapping("list/{id}")
    public Dept getDeptById(@PathVariable("id") String id){
        return  restTemplate.getForObject(PREFIX+"/list/"+id,Dept.class);
    }

    @PostMapping("/add")
    @SuppressWarnings("unchecked")
    public Map<String,Object> addDept(Dept dept){
        return  restTemplate.postForObject(PREFIX+"/add",dept,Map.class);
    }
    /**
     * 这里需要说一下  restTemplate 的  put 和 delete 方法是没有返回值的
     * 如果需要返回值 可以使用exchange方法 见下方删除方法
     * @param dept 要修改的部门信息
     */
    @PutMapping("/modify")
    public void modifyById(Dept dept){
//       注意 这里面不知道为什么使用request 直接传对象过去映射不上，只能靠拼接url的方式
        restTemplate.put(PREFIX+"/modify?dname={1}&deptno={2}",null,dept.getDname(),dept.getDeptno());
    }

    @DeleteMapping("/delete/{id}")
    @SuppressWarnings("unchecked")
    public Map<String,Object> deleteDept(@PathVariable("id") String id){
        ResponseEntity<Map> responseEntity = restTemplate.exchange(PREFIX+"/delete/"+id,
                HttpMethod.DELETE,null,Map.class);
        if(null != responseEntity){
            return  responseEntity.getBody();
        }
        return null;
    }
}
