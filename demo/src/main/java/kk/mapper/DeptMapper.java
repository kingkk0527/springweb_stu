package kk.mapper;

import kk.pojo.Dept;
import org.apache.ibatis.annotations.*;

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
    /**
     * 增加部门
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
    /**
     * 根据id查询部门
     * @param id
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
//@Update("update dept set name = #{name} where id= #{id}")
//    void update(Integer id, String name);
@Update("update dept set name = #{name} where id= #{id}")
    void update(Dept dept);
}
