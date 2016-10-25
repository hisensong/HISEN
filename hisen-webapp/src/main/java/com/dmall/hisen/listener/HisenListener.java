package com.dmall.hisen.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/7 18:37
 */
//@WebListener
public class HisenListener implements ServletRequestListener {

    private static final Log LOG = LogFactory.getLog(HisenListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("hisen listener destroy....");
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        boolean flag = true;

        //打印所有请求参数
        try{

            HttpServletRequest req = (HttpServletRequest) event.getServletRequest();
            req.setCharacterEncoding("UTF8");

            //获取请求的所有报文头信息并打印
            Enumeration<String> enumHeader = req.getHeaderNames();
            StringBuffer sbHeader = new StringBuffer();
            sbHeader.append("\n");
            sbHeader.append("##################################################");
            sbHeader.append("\n");
            sbHeader.append("##########hisen应用接收请求,url={"+req.getServletPath()+"}");
            sbHeader.append("\n");
            sbHeader.append("##########hisen应用接收请求,报文头信息={");
            sbHeader.append("\n");
            while(enumHeader.hasMoreElements()){
                String key = enumHeader.nextElement();
                sbHeader.append("["+key+"] = {"+req.getHeader(key)+"}, ");
                sbHeader.append("\n");
            }
            sbHeader.append("}");
            sbHeader.append("\n");

            //获取请求的所有参数信息并打印
            Enumeration<String> enumParam = req.getParameterNames();
            StringBuffer sbParam = new StringBuffer();
            sbParam.append("##########hisen应用接收请求,参数信息={");
            sbParam.append("\n");
            while(enumParam.hasMoreElements()){
                String key = enumParam.nextElement();
                sbParam.append("["+key+"] = {"+req.getParameter(key).replace("\r|\n|\t", "")+"}, ");
                sbParam.append("\n");
            }
            sbParam.append("}");
            sbParam.append("\n");


        }catch(Exception e){
            LOG.info("##########hisen应用接收请求异常,信息={"+e.getMessage()+"}");
        }
    }
}
