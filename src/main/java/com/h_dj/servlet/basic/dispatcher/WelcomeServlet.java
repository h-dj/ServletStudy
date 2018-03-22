package com.h_dj.servlet.basic.dispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: WelcomeServlet
 * @Package com.h_dj.servlet.basic.dispatcher
 * @Description: 欢迎页
 * @date 2018/3/21 20:51
 */
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置服务器端编码
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("userName");
        if (name == null || name == "") {
            name = "";
        }
        PrintWriter out = resp.getWriter();
        //String chset = response.getCharacterEncoding();
        out.print("<!DOCTYPE html>\r\n" +
                "<html>\r\n" +
                "<head>\r\n" +
                "<meta charset=\"UTF-8\">\r\n" +
                "<title>登录成功</title>\r\n" +
                "</head>\r\n" +
                "<body>");
        out.print("<b>登录成功啦lala  ~ </b><hr/>");
        out.print("Welcome, " + name);
        out.close();
    }
}
