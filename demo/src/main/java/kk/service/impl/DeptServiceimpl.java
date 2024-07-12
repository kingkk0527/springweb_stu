package kk.service.impl;

import kk.mapper.DeptMapper;
import kk.mapper.EmpMapper;
import kk.pojo.Dept;
import kk.service.DeptLogService;
import kk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ DeptServiceimpl :
 * @ Description:
 */
//部门业务实现类
@Slf4j
@Service
public class DeptServiceimpl implements DeptService {
    @Autowired
    private DeptMapper deptmapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;
    /**
     * @return 查询全部部门数据
     */
    @Override
    public List<Dept> list() {
        // 调用mapper
        return deptmapper.list();
    }

    /**
     * 删除部门
     */
    @Transactional(rollbackFor = Exception.class) //事务管理  所有异常都回滚
    @Override
    public void deleteById(Integer id) throws Exception {

        try {
            deptmapper.deleteById(id); //根据id删除部门
            int i = 1/0 ;  // 模拟异常
//        if(true){ throw new Exception("出错啦。。。。");}
            empMapper.deleteByDeptId(id);// 删除部门所有员工
        } finally { // 无论上面是否执行 finally都执行
            deptLogService.insert(id); // 添加日志
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 调用mapper
        deptmapper.insert(dept);
    }
    @Override
    public Dept getById(Integer id) {
        // 调用mapper、
        return deptmapper.getById(id);
    }

    @Override
//    public void update(Integer id, String name) {
//        // 调用mapper、
////        Dept dept = deptmapper.getById(id);
////        dept.setName(name);
////        dept.setUpdateTime(LocalDateTime.now());
////        deptmapper.update(dept);
//        deptmapper.update(id,name);
//
//    }
    public void update(Dept dept) {

        deptmapper.update(dept);

    }
}
