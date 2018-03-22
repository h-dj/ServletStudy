package com.h_dj.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_1
 * @Package com.h_dj.servlet.basic
 * @Description: Servlet入门程序
 * 创建servlet有三种不同的方法
 * - 通过实现Servlet接口
 * - 扩展GenericServlet类
 * - 通过扩展HttpServlet类
 * @date 2018/3/21 17:16
 */
public class Servlet1_1 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  //设置响应内容类型
        PrintWriter out = response.getWriter(); //获取输出流
        out.println("<html><body>");
        out.println("<h2 style='text-align:center'>Hello Servlet ~</h2>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
