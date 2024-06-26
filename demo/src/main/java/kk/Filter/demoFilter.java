package kk.Filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @ demoFilter :
 * @ Description:
 */

//@WebFilter(urlPatterns = "/*")
public class demoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("放行后");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
