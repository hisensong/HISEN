package com.dmall.hisen.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/7 18:37
 */
//@WebListener
public class HisenListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("hisen listener destroy....");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("hisen listener init....");

        servletRequestEvent.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) servletRequestEvent.getServletRequest();
        try {
            req.setCharacterEncoding("UTF-8");
          //  System.out.println("req.getSession().getId()====" + req.getSession().getId());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
