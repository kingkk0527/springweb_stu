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
    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数 原始方式
//        Long count =  empMapper.count();
//        // 分页查询获得列表数据
//        Integer start = (page-1) * pageSize;
//        List list = empMapper.page(start,pageSize);

        // 设置分页数 pageHelper 方式、
        PageHelper.startPage(page,pageSize);
        // 执行查询
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        // 封装pageBean对象
//        PageBean pageBean = new PageBean(count,list);
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
