package kk.controller;

import kk.pojo.Emp;
import kk.pojo.PageBean;
import kk.pojo.Result;
import kk.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    /**
     *  查询员工
     * @param page      页数
     * @param pageSize  每页数据数
     * @param name      选择名字
     * @param gender    性别
     * @param begin     开始
     * @param end       结束
     * @return          pageBean对象
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate end

    ){
        log.info("分页查询，第{}页，含{}条员工",page,pageSize);
        // 调用service分页查询
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     *              批量删除员工
     * @param ids   路径传入数组
     * @return      成功信息
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     *              插入员工
     * @param emp   员工类
     * @return      成功信息
     */
    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("新增员工，emp，{}",emp);
        empService.insert(emp);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     * @param id id
     * @return   员工信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工信息，id：{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     * @param emp  更新员工信息
     * @return 成功
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
    log.info("更新员工信息， {}",emp);
    empService.update(emp);
    return Result.success();
    }

}
