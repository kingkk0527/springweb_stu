package com.kk_test.Controller;

import com.kk_test.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * day  5
 *
 * @ requestController :
 * @ Description:  测试请求参数接受
 */

@RestController
public class requestController {
    // 原始方式
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//         // http://localhost:8080/simpleParam?name=Tom&age=10
//        // 请求参数： name=Tom&age=10   （有2个请求参数）
//        // 第1个请求参数： name=Tom   参数名:name，参数值:Tom
//        // 第2个请求参数： age=10     参数名:age , 参数值:10
//
//        String name = request.getParameter("name");//name就是请求参数名
//        String ageStr = request.getParameter("age");//age就是请求参数名
//
//        int age = Integer.parseInt(ageStr);//需要手动进行类型转换
//        System.out.println(name+"  :  "+age);
//        return "OK";
//


    @RequestMapping("/simpleParam")
    // springboot方式
    // http://localhost:8080/simpleParam?name=Tom&age=10
    // 第1个请求参数： name=Tom   参数名:name，参数值:Tom
    // 第2个请求参数： age=10     参数名:age , 参数值:10
    public String simpleParam(String name, Integer age) {//形参名和请求参数名保持一致
        System.out.println(name + "  :  " + age);
        return "OK";
    }

    // http://localhost:8080/simpleParam?name=Tom&age=20
    // 请求参数名：name

    //springboot方式

    @RequestMapping("/simpleParam2")
    // 如果参数名不一致@RequestParam("name")
    public String simpleParam2(@RequestParam("name") String username, Integer age) {//请求参数名和形参名不相同
        System.out.println(username + "  :  " + age);
        return "OK";
    }

    // 3 数组集合参数

    //数组参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }


    // 4 日期时间参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";

    }

    // 5 json参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    //6路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + " : " + name);
        return "OK";
    }


}
