package cn.h_dj.servlet.basic.cookieTest;

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
 * @Description: 注销的Servlet
 * @date 2018/3/21 20:44
 */
public class LogoutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //设置服务端编码
        resp.setCharacterEncoding("UTF-8");
        //设置响内容
        resp.setContentType("text/html;charset=utf-8");
        //获取输出流
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("/cookieTest/link.html").include(req, resp);

        //移除cookie
        Cookie ck = new Cookie("name", "");
        ck.setMaxAge(0);
        resp.addCookie(ck);

        out.print("您已成功注销!");
    }
}
