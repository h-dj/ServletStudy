package com.h_dj.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_5
 * @Package com.h_dj.servlet.basic
 * @Description: 请求重定向
 * @date 2018/3/21 21:22
 */
public class Servlet1_5 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("utf-8");
        resp.setContentType("text/html");
        String wd = req.getParameter("wd");
        if (wd != null) {
            resp.sendRedirect("https://www.baidu.com/s?wd=" + wd);
        }
        //https://www.baidu.com/s?wd=12
    }
}
