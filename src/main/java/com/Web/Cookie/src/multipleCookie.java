package com.Web.Cookie.src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Cookie快速入门
 *
 */

@WebServlet("/multipleCookie")
public class multipleCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg","hello");
        Cookie c2 = new Cookie("name","zhangsan");
        //2.发送Cookie
        response.addCookie(c1);
        response.addCookie(c2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
