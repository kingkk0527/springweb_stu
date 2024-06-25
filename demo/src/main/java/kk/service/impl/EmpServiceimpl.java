package kk.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import kk.mapper.EmpMapper;
import kk.pojo.Emp;
import kk.pojo.PageBean;
import kk.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ DeptServiceimpl :
 * @ Description:
 */
//员工业务实现类
@Slf4j
@Service
public class EmpServiceimpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * @param page      第几页
     * @param pageSize  每页数量
     * @return 获取pageBean对象
     */
    @Override
    public PageBean page(Integer page, Integer pageSize,
    String name, Short gender, LocalDate begin, LocalDate end) {
//        // 获取总记录数 原始方式
//        Long count =  empMapper.count();
//        // 分页查询获得列表数据
//        Integer start = (page-1) * pageSize;
//        List list = empMapper.page(start,pageSize);

        // 设置分页数 pageHelper 方式、
        PageHelper.startPage(page,pageSize);
        // 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        // 封装pageBean对象
//        PageBean pageBean = new PageBean(count,list);
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
    /**
     * 批量删除操作
     * @param ids id list
     */
    @Override
    public void delete(List<Integer> ids) {
    empMapper.delete(ids);
    }

    /**
     *              插入员工
     * @param emp   员工类
     * @return      成功信息
     */
    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
    /**
     * 根据id查询员工信息
     * @param id id
     * @return   员工信息
     */
    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }
    /**
     * 更新员工信息
     * @param emp  更新员工信息
     */
    @Override
    public void update(Emp emp) {
        // 补充信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    /**
     * 登录
     * @param emp   用户名密码
     * @return      查询员工信息
     */

    @Override
    public Emp login(Emp emp) {

        return empMapper.getByUsernameAndPassword(emp);
    }
}
