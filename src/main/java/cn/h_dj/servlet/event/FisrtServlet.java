package cn.h_dj.servlet.event;

import javax.servlet.ServletContext;
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
 * @Title: FisrtServlet
 * @Package com.h_dj.servlet.event
 * @Description: 查看登陆人数及登陆的Servlet
 * @date 2018/3/22 14:32
 */
public class FisrtServlet extends HttpServlet {

    // 显示用户数
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 获取ServletContext
        ServletContext ctx = getServletContext();
        int t = (Integer) ctx.getAttribute("totalusers");
        int c = (Integer) ctx.getAttribute("currentusers");
        out.print("<br>用户总数： " + t);
        out.print("<br>当前用户数： " + c);
        out.print("<br><a href='logout'>注销</a>");
        out.close();
    }

    // 执行用户登录
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        // 假设输入密码为：123456时，此用户登录成功
        if (password == null) {
            password = "";
        }
        if (password.equals("123456")) {
            out.print("您好, " + n);
            session.setAttribute("uname", n);
        } else {
            out.print("登陆失败 ~");
        }
        // retrieving data from ServletContext object
        ServletContext ctx = request.getSession().getServletContext();
        int t = (Integer) ctx.getAttribute("totalUsers");
        int c = (Integer) ctx.getAttribute("currentUsers");
        out.print("<br>用户总数： " + t);
        out.print("<br>当前用户数： " + c);
        out.print("<br><a href='logout'>注销</a>");
        out.close();
    }


}
