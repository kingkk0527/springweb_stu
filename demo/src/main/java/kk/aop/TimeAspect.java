package kk.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ TimeAspect :
 * @ Description:
 */
@Slf4j
@Component
@Aspect // aop类
public class TimeAspect {
    @Around("execution(* kk.service.*.*(..))") //切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1 开始时间
        long begin = System.currentTimeMillis();

        // 2 调用原始方法
        Object result = joinPoint.proceed();

        // 3 记录结束时间 计算耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法耗时：{}ms",end-begin);

        return result;

    }



}
