package com.kk_test.Controller;

import com.kk_test.pojo.Emp;
import com.kk_test.pojo.Result;
import com.kk_test.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ EmpController :
 * @ Description:
 */

@RestController
public class EmpController {
//    @RequestMapping("listEmp")
//    public Result list(){
//        //1.controller 加载并解析emp.xml
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//        //2.service 对数据进行转换处理 - gender, job
//        empList.stream().forEach(emp -> {
//            //处理 gender 1: 男, 2: 女
//            String gender = emp.getGender();
//            if ("1".equals(gender)){
//                emp.setGender("男");
//            }else if ("2".equals(gender)){
//                emp.setGender("女");
//            }
//            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            }else if("2".equals(job)){
//                emp.setJob("班主任");
//            }else if("3".equals(job)){
//                emp.setJob("就业指导");
//            }
//        });
        // 3.dao 响应数据
//        return Result.success(empList);
//    }
}
