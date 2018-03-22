package com.h_dj.servlet.event;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: SecondServlet
 * @Package com.h_dj.servlet.event
 * @Description: 注销Servelt
 * @date 2018/3/22 14:34
 */
public class SecondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //从请求中获取Session,不会新创建
        HttpSession session = request.getSession(false);
        session.invalidate();// 使Session无效

        out.print("You are successfully logged out");

        out.close();

    }


}
