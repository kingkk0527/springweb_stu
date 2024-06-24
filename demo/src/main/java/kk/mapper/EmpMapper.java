package kk.mapper;

import kk.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
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
//    @Select("select * from emp")
    // 换成动态查询 xml文件
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
    /**
     *              插入员工
     * @param emp   员工类
     */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    void insert(Emp emp);
    /**
     * 根据id查询员工信息
     * @param id id
     * @return   员工信息
     */
    @Select("select * from emp where id = #{id};")
    Emp getById(Integer id);
    /**
     * 更新员工信息
     * @param emp  更新员工信息
     */
    void update(Emp emp);
}
