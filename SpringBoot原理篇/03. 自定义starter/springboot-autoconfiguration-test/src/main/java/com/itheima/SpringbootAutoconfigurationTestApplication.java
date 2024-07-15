package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.aliyun.oss","com.itheima"})  //组件扫描、、
public class SpringbootAutoconfigurationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAutoconfigurationTestApplication.class, args);
    }

}
