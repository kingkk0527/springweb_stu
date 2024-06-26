package kk.controller;

import kk.pojo.Emp;
import kk.pojo.Result;
import kk.service.EmpService;
import kk.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ loginController : 登录接口
 * @ Description:
 */

@Slf4j
@RestController
public class loginController {
    @Autowired
    private EmpService empService;

    /**
     * 登录
     * @param emp   用户名密码
     * @return      成功或失败信息
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e =  empService.login(emp);
        // 用户名密码正确
        if (e != null){
            Map<String,Object> clamis = new HashMap<>();
            clamis.put("id",e.getId());
            clamis.put("name",e.getName());
            clamis.put("username",e.getUsername());
            //生成jwt令牌
            String jwt = JwtUtils.generateJwt(clamis);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

}
