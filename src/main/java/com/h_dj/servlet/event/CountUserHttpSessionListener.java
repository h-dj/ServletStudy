package com.h_dj.servlet.event;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author h_dj
 * @version V1.0
 * @Title: CountUserHttpSessionListener
 * @Package com.h_dj.servlet.event
 * @Description: 记录登陆人数的监听器
 * @date 2018/3/22 14:23
 */
public class CountUserHttpSessionListener implements HttpSessionListener {

    /**
     * 总登陆人数
     */
    private int total;
    /**
     * 当前登录人数
     */
    private int current;

    /**
     * 会话创建时调用
     *
     * @param httpSessionEvent
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        total++;
        current++;
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        context.setAttribute("totalUsers", total);
        context.setAttribute("currentUsers", current);
    }

    /**
     * 会话销毁时，调用
     *
     * @param httpSessionEvent
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        current--;
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        context.setAttribute("currentUsers", current);
    }
}
