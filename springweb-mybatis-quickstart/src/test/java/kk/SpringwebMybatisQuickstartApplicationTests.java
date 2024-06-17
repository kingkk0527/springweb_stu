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
    public void testDelte(){
        int count = empMapper.delete(16);
        System.out.println(count);
    }
    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setUsername("tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println("id = "+ emp.getId());

    }


}
