package com.dmall.hisen.mq.springrabbit.producer;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/29 14:57
 */

public interface MqProducer {
    /**
     * 发送消息到指定队列
     * @param queueKey
     * @param object
     */
    public void sendDataToQueue(String queueKey, Object object);
}
