package com.kk_test.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** d ay  4
 * @ helloController : 请求处理类
 * @ Description:
 */

@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
