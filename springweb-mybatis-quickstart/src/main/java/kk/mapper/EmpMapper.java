package kk.mapper;

import kk.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

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
    /**
     * 根据id修改员工信息
     */
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, " +
            "entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);
    // 动态更新员工
    public void update2(Emp emp);



    // 查询员工
    //
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp where id=#{id}")
    public Emp getById(Integer id);

    // 当未配置mybatis驼峰命名自动映射开关 tb_emp  -> tbEmp 无法映射
//    手动结果映射：通过 @Results及@Result 进行手动结果映射
//    起别名：在SQL语句中，对不一样的列名起别名，别名和实体类属性名一样
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id AS deptId, create_time AS createTime, update_time AS updateTime " +
//            "from emp " +
//            "where id=#{id}")
//    public Emp getById(Integer id);

    // 条件查询 （解决SQL注入风险）
    //使用MySQL提供的字符串拼接函数：concat('%' , '关键字' , '%')
//    @Select("select * from emp " +
//            "where name like concat('%',#{name},'%') " +
//            "and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} " +
//            "order by update_time desc")
//    public List<Emp> slectList(String name, Short gender, LocalDate begin, LocalDate end);

    // sql xml文件
    public List<Emp> slectList(String name, Short gender, LocalDate begin, LocalDate end);

//批量删除
    public void deleteByIds(List<Integer> ids);

}
