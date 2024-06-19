package kk.controller;

import kk.pojo.Dept;
import kk.pojo.Result;
import kk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ DeptController :
 * @ Description:
 */
@Slf4j
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)

    /**
     * @return 查询全部部门数据
     */
    @GetMapping("/depts")  // 上面的简写 限制为GET
    public Result lidt() {
        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        // 调用service
        deptService.delete(id);
        return Result.success();
    }
}
