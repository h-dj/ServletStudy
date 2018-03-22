package com.h_dj.servlet.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyServletContextListener
 * @Package com.h_dj.servlet.event
 * @Description: 监听链接数据库
 * @date 2018/3/22 11:10
 */
public class MyServletContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent event) {

        String jdbcDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost/testdb";

        // Database credentials
        String dbUser = "root";
        final String passwd = "1234";
        try {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbURL,dbUser,passwd);
            // storing connection object as an attribute in ServletContext
            ServletContext ctx = event.getServletContext();
            ctx.setAttribute("mycon", con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Servlet has contextDestroyed...");
        ServletContext ctx = event.getServletContext();
        ctx.setAttribute("mycon", null);
    }

}
