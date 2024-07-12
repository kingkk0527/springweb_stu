package kk.aop;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import kk.mapper.OperateLogMapper;
import kk.pojo.OperateLog;
import kk.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @ LogAspect :
 * @ Description:
 */

@Slf4j
@Component
@Aspect  // 切面类
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(kk.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人id
        // 获取请求头jwt令牌，解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUserId = (Integer) claims.get("id");
//操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作方法名
        String methodName = joinPoint.getSignature().getName();
        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        // 开始时间
        long begin = System.currentTimeMillis();

        // 调用原始方法
        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            //方法返回值
            String returnValue = JSONObject.toJSONString(result);

            // 记录结束时间 计算耗时
            long end = System.currentTimeMillis();
            Long cost = end - begin;
            log.info(joinPoint.getSignature() + "方法耗时：{}ms", cost);

            //操作日志记录
            OperateLog operateLog = new OperateLog(null, operateUserId, operateTime, className, methodName, methodParams, returnValue, cost);
            operateLogMapper.insert(operateLog);

            log.info("aop记录操作日志:{}", operateLog);


        }
        return result;


    }

}
