package com.zfcgdbinterface.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zht
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "CorsFilter")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("===========================================chulaile=======================================");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String curOrigin = request.getHeader("Origin");

        //指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", curOrigin == null ? "true" : curOrigin);
        //是否允许用户发送、处理cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //真实请求允许的方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        //服务器允许使用的字段
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}

