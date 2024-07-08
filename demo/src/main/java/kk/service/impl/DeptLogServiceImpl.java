package kk.service.impl;

import kk.mapper.DeptLogMapper;
import kk.pojo.DeptLog;
import kk.service.DeptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @ DeptLogServiceImpl :
 * @ Description:
 */

@Slf4j
@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 开始一个新实务
    @Override
    public void insert(Integer id) {
        DeptLog deptLog = new DeptLog();
        deptLog.setCreateTime(LocalDateTime.now());
        deptLog.setDescription("解散" + id + "号部门");
        deptLogMapper.insert(deptLog);


    }
}
