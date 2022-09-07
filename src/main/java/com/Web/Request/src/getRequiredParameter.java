package com.Web.Request.src;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/getRequiredParameter")
public class getRequiredParameter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数

        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        //post 获取请求参数

        //根据参数名称获取参数值
        String username = request.getParameter("username");
       /* System.out.println("post");
        System.out.println(username);*/

       //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        /*for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        //获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }*/

        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset) {

            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }

            System.out.println("-----------------");
        }


        // 设置流的编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数username
        String username1 = request.getParameter("username");
        System.out.println(username1);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get 获取请求参数
        /**
            以下获取请求参数的方法post和get通用
            String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
			String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
			Enumeration<String> getParameterNames():获取所有请求的参数名称
			Map<String,String[]> getParameterMap():获取所有参数的map集合
         */
        this.doPost(request,response);
    }
}
