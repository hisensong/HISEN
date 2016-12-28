package com.dmall.hisen.mq.rabbit.producer;

import com.dmall.hisen.mq.rabbit.base.BaseConnector;
import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/28 16:01
 */

public class Sender extends BaseConnector {

    public Sender(String queueName) throws Exception {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws Exception {
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }

}
