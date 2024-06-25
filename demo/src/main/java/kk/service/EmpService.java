package kk.service;

import kk.pojo.Emp;
import kk.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @ DeptService :
 * @ Description:
 */

//员工业务规则
public interface EmpService {
    /**
     * 分页查询
     *
     * @param page     第几页
     * @param pageSize 每页数量
     * @return 分页查询结果封装类
     */
    PageBean page(Integer page, Integer pageSize,
                         String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除操作
     * @param ids id list
     */
    void delete(List<Integer> ids);
    /**
     *              插入员工
     * @param emp   员工类
     * @return      成功信息
     */
    void insert(Emp emp);
    /**
     * 根据id查询员工信息
     * @param id id
     * @return   员工信息
     */
    Emp getById(Integer id);
    /**
     * 更新员工信息
     * @param emp  更新员工信息
     */
    void update(Emp emp);
    /**
     * 登录
     * @param emp   用户名密码
     * @return      查询员工信息
     */

    Emp login(Emp emp);
}
