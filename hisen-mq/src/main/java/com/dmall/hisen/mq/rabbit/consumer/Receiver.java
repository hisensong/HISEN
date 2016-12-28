package com.dmall.hisen.mq.rabbit.consumer;

import com.dmall.hisen.mq.rabbit.base.BaseConnector;
import com.dmall.hisen.mq.rabbit.base.MessageInfo;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;

/**
 * Description:接收者
 * Author:HisenSong
 * DateTime: 2016/12/28 16:22
 */

public class Receiver extends BaseConnector implements Runnable,Consumer{

    public Receiver(String queueName) throws Exception{
        super(queueName);
    }

    @Override
    public void run() {
        try {
            //指定消费队列
            channel.basicConsume(queueName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *    当消费者注册完成自动调用
     */
    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer " + consumerTag + " registered");
    }

    /**
     * 当消费者接收到消息会自动调用
     * @param s
     * @param envelope
     * @param basicProperties
     * @param body
     * @throws IOException
     */
    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] body) throws IOException {
        MessageInfo messageInfo = (MessageInfo) SerializationUtils.deserialize(body);
        System.out.println("Message ( "
                + "channel : " + messageInfo.getChannel()
                + " , content : " + messageInfo.getContent()
                + " ) received.");

    }

    //下面这些方法可以暂时不用理会
    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }


}
