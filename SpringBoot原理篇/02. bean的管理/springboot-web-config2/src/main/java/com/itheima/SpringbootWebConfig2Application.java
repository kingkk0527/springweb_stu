package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan({"com.example","com.itheima"})  //组件扫描、、
//@Import(TokenParser.class) //导入的类会被Spring加载到IOC容器中
//@Import(HeaderConfig.class) //导入配置类
//@Import(MyImportSelector.class) //导入ImportSelector接口实现类
@EnableHeaderConfig  //使用第三方依赖提供的Enable开头的注解
@SpringBootApplication
public class SpringbootWebConfig2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfig2Application.class, args);
    }

//    //声明第三方bean
//    @Bean //将当前方法的返回值对象交给IOC容器管理, 成为IOC容器bean
//    public SAXReader saxReader(){
//        return new SAXReader();
//    }
}
