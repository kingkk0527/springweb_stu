package kk.service.impl;

import kk.mapper.DeptMapper;
import kk.pojo.Dept;
import kk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return deptmapper.list();
    }

    /**
     * 删除部门
     */
    @Override
    public void delete(Integer id) {
        deptmapper.deleteById(id);
    }
}
