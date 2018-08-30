package com.neuedu.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//基于注解
//确切路径匹配http://localhost:8080/business/mng/hello
//@WebServlet("/mng/hello")
//确切路径匹配>模糊路径匹配>扩展名匹配>缺省的servlet
//模糊路径匹配
@WebServlet("/hello")//匹配任意路径/basic/*就不是任意了，必须是basic路径下的任意字符

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
        request.setAttribute("username","admin");
        //请求分派
//        request.getRequestDispatcher("login.jsp").forward(request,response);
      /*
      servlet作用域：请求域，  会话域，  全局域
       */
      //会话域
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("username","admin");
        //统计访问Helloservlet的次数
        ServletContext application=this.getServletContext();
        Object count=application.getAttribute("count");
        if(count==null){
            application.setAttribute("count",1);
        }else{
            int _count=(int)count;
            application.setAttribute("count",++_count);
        }
        System.out.println("访问次数"+application.getAttribute("count"));
//      request.setAttribute("username","admin");
//      //往请求域存放数据key-value形式存放
        //重定向
        response.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("===========destroy===========");
    }
}
