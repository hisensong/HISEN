package com.dmall.hisen.mq.springrabbit.producer.impl;

import com.dmall.hisen.mq.springrabbit.producer.MqProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/29 14:58
 */
@Service("MqProducer")
public class MqProducerImpl implements MqProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;


    /**
     * 将Java对象转换为消息发送到匹配Key的交换机中Exchange，由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式
     * @param queueKey
     * @param object
     */
    @Override
    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
             e.printStackTrace();
        }

    }
}
