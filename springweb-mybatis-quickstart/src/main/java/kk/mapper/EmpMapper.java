package kk.mapper;

import kk.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EmpMapper {

    // 根据id删除数据
    @Delete("delete from emp where id = #{id}")
//    public void delete (Integer id);  // 无返回值
    public int delete (Integer id);  // 默认返回删除数

    // 新增员工
    @Options(useGeneratedKeys = true,keyProperty = "id")  // 把产生id封装进emp
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
