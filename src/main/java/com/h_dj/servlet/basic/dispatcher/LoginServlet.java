package com.h_dj.servlet.basic.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: LoginServlet
 * @Package com.h_dj.servlet.basic.dispatcher
 * @Description: 登陆的Servlet
 * @date 2018/3/21 20:44
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //设置服务端编码
        resp.setCharacterEncoding("UTF-8");
        //设置响内容
        resp.setContentType("text/html");
        //获取输出流
        PrintWriter writer = resp.getWriter();

        //获取登陆的用户名和密码
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        //判断登陆的密码是否有效
        if (password.equals("mypasswd") && userName.equals("admin")) {
            RequestDispatcher rd = req.getRequestDispatcher("WelcomeServlet"); //通过请求路径获取请求转发的对象
            System.out.println("Username is : " + userName);
            rd.forward(req, resp);
        } else {
            writer.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, resp);
        }


    }
}
