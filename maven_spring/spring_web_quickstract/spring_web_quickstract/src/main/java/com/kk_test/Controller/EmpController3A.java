package com.kk_test.Controller;

import com.kk_test.pojo.Emp;
import com.kk_test.pojo.Result;
import com.kk_test.service.EmpService;
import com.kk_test.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ EmpController :
 * @ Description:
 */

@RestController
public class EmpController3A {
    @Autowired //运行时,从IOC容器中获取该类型对象,赋值给该变量
    private EmpService empService ;
    @RequestMapping("listEmp")
    public Result list(){
        //1.调用service获取数据
        List<Emp> empList = empService.listEmp();
        // 3.dao 响应数据
        return Result.success(empList);
    }
}
