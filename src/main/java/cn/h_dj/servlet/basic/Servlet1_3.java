package cn.h_dj.servlet.basic;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_3
 * @Package com.h_dj.servlet.basic
 * @Description: GenericServlet类 创建实例
 * @date 2018/3/21 18:13
 */
public class Servlet1_3 extends GenericServlet {


    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("<div style=\"text-align:center;\"><h2>hello simple servlet by extends GenericServlet</h2></div>");
        out.print("</body></html>");
    }
}
