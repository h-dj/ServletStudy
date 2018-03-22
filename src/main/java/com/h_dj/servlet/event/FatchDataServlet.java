package com.h_dj.servlet.event;



import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author h_dj
 * @version V1.0
 * @Title: FatchDataServlet
 * @Package com.h_dj.servlet.event
 * @Description: 链接数据库，打印表内容
 * @date 2018/3/22 11:30
 */
public class FatchDataServlet extends HttpServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try{
            // 获取数据库连接对象
            ServletContext ctx = getServletContext();
            Connection con = (Connection) ctx.getAttribute("mycon");
            if(con==null) {
                System.out.println("获取数据库连接异常~！");
            }
            // retieving data from emp32 table
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.print("<br>" + rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.close();
    }



}
