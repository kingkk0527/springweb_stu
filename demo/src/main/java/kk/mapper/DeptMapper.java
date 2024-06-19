package kk.mapper;

import kk.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ DeptMapper :
 * @ Description:
 */
@Mapper
public interface DeptMapper {

    /**
     * @return 查询全部部门数据
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete  from dept where id = #{id}")
    void deleteById(Integer id);
}
