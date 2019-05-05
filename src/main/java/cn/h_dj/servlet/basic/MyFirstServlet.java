package cn.h_dj.servlet.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: h_dj
 * @Date: 2019/4/12 15:55
 * @Description:
 */
public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servelt : doGet");
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        //获取输出流
        PrintWriter out = resp.getWriter();
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyFirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet MyFirstServlet at " + req.getContextPath() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servelt : doPost");
        super.doPost(req, resp);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servelt : service");
        super.service(req, resp);

    }

    @Override
    public void destroy() {
        System.out.println("Servelt : destroy");
        super.destroy();

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servelt : init" + config);
        super.init(config);

    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servelt : init");
        super.init();

    }
}
