package kk;

import kk.mapper.EmpMapper;
import kk.mapper.UserMapper;
import kk.pojo.Emp;
import kk.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@SpringBootTest  //代表该测试类已经与SpringBoot整合。
class SpringwebMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();

        userList.stream().forEach(user -> {
            System.out.println(user);
        });
        //
        userList.forEach(System.out::println);
    }

    @Test
    public void testDelte() {
        int count = empMapper.delete(16);
        System.out.println(count);
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> ids = Arrays.asList(11, 12, 13);
        empMapper.deleteByIds(ids);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println("id = " + emp.getId());

    }

    //修改的员工信息
    @Test
    public void testUpdate() {
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(3);
        emp.setUsername("song");
        emp.setName("老宋");
        emp.setGender((short) 2);
//        emp.setImage("2.jpg");
//        emp.setPassword(null);
//        emp.setJob((short)2);
//        emp.setEntrydate(LocalDate.of(2012,1,1));
//        emp.setCreateTime(null);
//        emp.setDeptId(2);
        emp.setUpdateTime(LocalDateTime.now());
        //调用方法，修改员工数据
//        empMapper.update(emp);
        empMapper.update2(emp);
    }

    // select 查询员工
    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(1);
        System.out.println(emp);
    }

    // 动态select 查询员工
    @Test
    public void testList() {
//        List<Emp> list = empMapper.slectList("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 12, 12));
        //动态sql
//        List<Emp> list = empMapper.slectList("张", null, null, null);
        List<Emp> list = empMapper.slectList(null, (short) 1, null, null);
        System.out.println(list);
    }


}
