package com.dmall.hisen.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/9/8 15:52
 */
@Aspect
public class BaseAop {

    @Around("within(com.dmall.hisen.service..*)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }

}
