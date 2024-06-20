package kk.service.impl;

import kk.mapper.DeptMapper;
import kk.pojo.Dept;
import kk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public void delete(Integer id) {
        deptmapper.deleteById(id);
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
