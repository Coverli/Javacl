package com.Web.Filter.src;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器快速入门程序
 */
//访问所有资源之前，都会执行该过滤器
//@WebFilter("/*")
public class simpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo1被执行了....");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
