package kk.mapper;

import kk.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ DeptLogMapper :
 * @ Description:
 */
@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log (create_time, description) values (#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
