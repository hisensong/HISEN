package com.dmall.hisen.mq.springrabbit.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.utils.SerializationUtils;

/**
 * Description:定义监听器
 * Author:HisenSong
 * DateTime: 2016/12/29 15:13
 */
public class QueueListenter implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        try{
            System.out.println(msg.toString());
            System.out.println("=====" + new String(msg.getBody()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
