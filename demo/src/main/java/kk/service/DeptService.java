package kk.service;

import kk.pojo.Dept;

import java.util.List;

/**
 * @ DeptService :
 * @ Description:
 */

// 部门业务规则
public interface DeptService {
    /**
     * @return 查询全部部门数据
     */
    public List<Dept> list()

    ;

    /**
     * 删除部门
     */
    void delete(Integer id);
    /**
     * 新增部门
     */
    void add(Dept dept);
    /**
     * 根据id查询部门数据
     */
    Dept getById(Integer id);
    /**
     * 修改部门
     */
    void update(Dept dept);
//    void update(Integer id,String name);



}
