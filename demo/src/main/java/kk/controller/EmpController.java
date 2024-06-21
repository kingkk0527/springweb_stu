package kk.controller;

import kk.pojo.PageBean;
import kk.pojo.Result;
import kk.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ EmpController :
 * @ Description:
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize){
        log.info("分页查询，第{}页，含{}条员工",page,pageSize);
        // 调用service分页查询
        PageBean pageBean = empService.page(page,pageSize);
        return Result.success(pageBean);

    }
}
