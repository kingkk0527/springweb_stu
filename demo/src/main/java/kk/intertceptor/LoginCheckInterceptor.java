package kk.intertceptor;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kk.pojo.Result;
import kk.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ LoginCheckInterceptor :
 * @ Description:
 */

//自定义拦截器
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    //目标资源方法执行前执行。 返回true：放行    返回false：不放行
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {


        // 1获取url
        String url = req.getRequestURI();
        log.info("请求URL：{}", url);

        // 2 判断是否包含login
        if (url.contains("login")) {
            log.info("登录操作，放行。。");
            return true; //true表示放行
        }

        // 3 获取请求头中令牌（token）
        String jwt = req.getHeader("token");

        // 4 判断令牌是否存在
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            // 转换 对象 -》json ----》阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false; // 返回false：不放行
        }

        // 5 解析token
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            // 转换 对象 -》json ----》阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;  // 返回false：不放行
        }
        // 放行
        log.info("放行");
        return true; //true表示放行
    }

    //目标资源方法执行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ... ");
    }

    //视图渲染完毕后执行，最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion .... ");
    }
}