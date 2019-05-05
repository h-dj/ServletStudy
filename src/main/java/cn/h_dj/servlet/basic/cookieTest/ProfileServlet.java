package cn.h_dj.servlet.basic.cookieTest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ProfileServlet
 * @Package com.h_dj.servlet.basic.cookieTest
 * @Description: TODO
 * @date 2018/3/21 23:47
 */
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("/cookieTest/link.html").include(request, response);

        //获取全部的coolie
        Cookie ck[] = request.getCookies();
        if (ck != null) {
            String name = ck[1].getValue(); //获取cookie中保存的值
            System.out.println(ck[0].getValue()+":  "+ck[1].getValue());
            if (!name.equals("") || name != null) {
                //如果不为空，则可以访问
                out.print("<b>欢迎您来到个人信息中心</b>");
                out.print("<br>您好, " + name);
            }
        } else {
            //否则，先登陆，才能访问
            out.print("<font style='color:red;'>请先登录!</font>");
            request.getRequestDispatcher("/cookieTest/login.html").include(request, response);
        }
        out.close();
    }
}
