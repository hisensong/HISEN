package com.hisen.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/10/13 17:25
 */

public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "file:E:\\dev_project\\hisen\\hisen-dubbo\\src\\main\\resources\\spring\\dubbo-consumer.xml");
        context.start();
        IDemoService demoService = (IDemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println(hello);
    }
}
