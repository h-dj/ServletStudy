package com.h_dj.servlet.basic.cookieTest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

        req.setCharacterEncoding("UTF-8");
        //设置服务端编码
        resp.setCharacterEncoding("UTF-8");
        //设置响内容
        resp.setContentType("text/html;charset=utf-8");
        //获取输出流
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("/cookieTest/link.html").include(req, resp);
        //获取登陆的用户名和密码
        String userName = req.getParameter("name");
        String password = req.getParameter("password");

        //判断登陆的密码是否有效
        if (password.equals("mypasswd") && userName.equals("admin")) {
            out.print("您已成功登录系统!");
            out.print("<br>欢迎您, " + userName);
            //把登陆的用户写入cookie中
            Cookie ck = new Cookie("name", userName);
            resp.addCookie(ck);
        } else {
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = req.getRequestDispatcher("/cookieTest/login.html");
            rd.include(req, resp);
        }
        out.close();

    }
}
