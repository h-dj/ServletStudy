package cn.h_dj.servlet.basic;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Servlet1_2
 * @Package com.h_dj.servlet.basic
 * @Description: 通过Servlet接口实现Servlet实例
 * @date 2018/3/21 17:55
 */
public class Servlet1_2 implements Servlet {

    ServletConfig config = null; //Servlet配置类


    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化配置
        config = servletConfig;
        System.out.println("servlet is initialized ");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<html><body>");
        out.print("<div style=\"text-align:center;\"><h2>hello simple servlet by implements Servlet</h2></div>");
        out.print("</body></html>");
    }

    /**
     * 获取servlet信息
     *
     * @return
     */
    public String getServletInfo() {
        return "author h_dj";
    }

    /**
     * 销毁servlet
     */
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
}
