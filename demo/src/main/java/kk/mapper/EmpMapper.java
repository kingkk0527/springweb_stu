package kk.mapper;

import kk.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ DeptMapper :
 * @ Description:
 */

@Mapper
public interface EmpMapper {
    // 查询总记录数 ， 分页查询 原始方法
    @Select("select count(*) from emp")
    public long count();

    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

    // pageHelper 方式
    @Select("select * from emp")
    public List<Emp> list();


}
