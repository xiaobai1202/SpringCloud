package com.xiaobai.cloudproviderhystrix8083.dao;



import com.xiaobai.entity.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author xiaobai
 * @date 2019/5/26 21:59
 * @since 1.0
 * 数据操作接口
 * 标注组件注解是为了让业务逻辑层注入不报错（不标注也不影响使用）
 */
@Mapper
@Component
public interface DeptDao {
    /**
     * 添加一个新部门
     * @param dept 被添加的部门信息
     * @return 添加结果
     */
    @Insert("INSERT INTO dept (dname,db_source) VALUES (#{dname},'clouddb01')")
    Integer addDept(Dept dept);
    /**
     * 获取部门列表
     * @return 部门列表
     */
    @Select("SELECT * FROM dept")
    List<Dept> getDeptList();

    /**
     * 根据deptno 获取部门
     * @param id
     * @return 部门
     */
    @Select("SELECT * FROM dept WHERE deptno = #{id}")
    Dept getDeptById(String id);

    /**
     * 修改部门信息
     * @param dept 被修改的部门信息
     * @return 修改结果
     */
    @Update("UPDATE dept SET dname = #{dname} WHERE deptno = #{deptno}")
    Integer modifyDept(Dept dept);

    /**
     * 删除一个部门
     * @param id
     * @return 删除结果
     */
    @Delete("DELETE FROM dept WHERE deptno = #{id}")
    Integer deleteDept(String id);
}
