package kk.Filter;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kk.pojo.Result;
import kk.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @ demoFilter :
 * @ Description:
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class loginCheckFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转换
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 1获取url
        String url = req.getRequestURI();
        log.info("请求URL：{}", url);

        // 2 判断是否包含login
        if (url.contains("login")) {
            log.info("登录操作，放行。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
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
            return;
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
            return;
        }
        // 放行
        log.info("放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
