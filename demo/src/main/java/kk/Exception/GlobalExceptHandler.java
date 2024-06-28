package kk.Exception;

import kk.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ GlobalExceptHandler :
 * @ Description: 全局异常处理器
 */

@RestControllerAdvice
public class GlobalExceptHandler {
    @ExceptionHandler(Exception.class)// 捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败，请联系服务员");
    }
}
