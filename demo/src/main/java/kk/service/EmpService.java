package kk.service;

import kk.pojo.PageBean;

/**
 * @ DeptService :
 * @ Description:
 */

//员工业务规则
public interface EmpService {
    /**
     * 分页查询
     * @param page      第几页
     * @param pageSize  每页数量
     * @return          分页查询结果封装类
     */
    public PageBean page(Integer page, Integer pageSize);
}
