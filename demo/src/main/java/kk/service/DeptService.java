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
}
