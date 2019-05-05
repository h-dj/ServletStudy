package cn.h_dj.servlet.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_6
 * @Package com.h_dj.servlet.basic
 * @Description: TODO
 * @date 2018/3/21 22:33
 */
public class Servlet1_6 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("mysql_driver");
        out.print("Driver details is: <b>" + driver+"</b>");
        out.close();

    }
}
