package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//基于注解
public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("======构造方法===hello  servlet============");
    }
    //初始化
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("======init===============");

    }
    /*
    request：请求的信息都封装在HttpServletRequest里面
    响应的信息都存在HttpServletResponse中
    request.getParameter（s:"username"）获取post的值,这个值是一个字符串
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("=========do post============");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===========do get===========");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("===========destroy===========");
    }
}
