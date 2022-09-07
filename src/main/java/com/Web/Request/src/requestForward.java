package com.Web.Request.src;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 */
@WebServlet("/requestForward")
public class requestForward extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("requestForward被访问了。。。");
        //转发到demo9资源
/*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
        requestDispatcher.forward(request,response);
        */

        //存储数据到request域中
        request.setAttribute("msg","hello");
        //转发到demo9资源
        request.getRequestDispatcher("/requestDemo9").forward(request,response);
        // 只能转发到当前服务器内部资源
        //request.getRequestDispatcher("http://www.itcast.cn").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
