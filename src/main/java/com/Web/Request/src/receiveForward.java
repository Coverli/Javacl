package com.Web.Request.src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接收转发请求
 */
@WebServlet("/receiveForward")
public class receiveForward extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取request域数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);

        // 删除request域数据
        request.removeAttribute("msg");
        // System.out.println(msg);

        System.out.println("receiveForward被访问了。。。");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
