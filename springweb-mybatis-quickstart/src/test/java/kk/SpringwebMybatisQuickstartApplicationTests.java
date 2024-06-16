package kk;

import kk.mapper.UserMapper;
import kk.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest  //代表该测试类已经与SpringBoot整合。
class SpringwebMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();

        userList.stream().forEach(user -> {
            System.out.println(user);
        });
        //
        userList.forEach(System.out::println);


    }

}
