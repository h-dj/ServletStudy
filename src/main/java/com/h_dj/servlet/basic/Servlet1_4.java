package com.h_dj.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_4
 * @Package com.h_dj.servlet.basic
 * @Description: 获取全部的请求表头
 * @date 2018/3/21 20:23
 */
public class Servlet1_4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Enumeration<String> headerNames = req.getHeaderNames(); //获取请求表头
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement(); //获取头部名称
            String headerValue = req.getHeader(headerName); //获取头部值
            writer.print("<b>" + headerName + "</b>: ");
            writer.println(headerValue + "<br/>");
        }
        writer.close();

    }
}
