package kk.controller;

import kk.pojo.Dept;
import kk.pojo.Result;
import kk.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ DeptController :
 * @ Description:
 */
@Slf4j
@RestController
@RequestMapping ("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)

    /**
     * @return 查询全部部门数据
     */
    @GetMapping  // 上面的简写 限制为GET
    public Result list() {
        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        // 调用service
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        // 调用service
        deptService.add(dept);
        return Result.success();
    };
    @GetMapping("/{id}")  // 上面的简写 限制为GET
    public Result getById(@PathVariable Integer id) {
        log.info("查询id为{}部门数据",id);
        // 调用service查询部门数据
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping()
//    public Result update( Integer id , String name){
//        log.info("修改部门：{}",id);
//        // 调用service
//        deptService.update(id,name);
//        return Result.success();
//    }
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        // 调用service
        deptService.update(dept);
        return Result.success();
    }

}