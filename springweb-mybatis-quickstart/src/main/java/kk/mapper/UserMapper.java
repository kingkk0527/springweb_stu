package kk.mapper;

import kk.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ UserMapper :
 * @ Description:这是一个持久层接口  Mybatis的持久层接口规范一般都叫 XxxMapper
 */

@Mapper  // 程序运行时：框架会自动生成接口的实现类对象(代理对象)，并给交Spring的IOC容器管理
public interface UserMapper {
    @Select("select id,name,age,gender,phone from user")
    public List<User> list();
}
