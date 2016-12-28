package com.dmall.hisen.mq.rabbit.base;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * Description:基础连接类
 * Author:HisenSong
 * DateTime: 2016/12/28 15:48
 */

public class BaseConnector {
    protected Channel channel;
    protected Connection connection;
    protected String queueName;
    private String host;

    public BaseConnector() {
    }

    public BaseConnector(String queueName) throws Exception{
        this.queueName = queueName;
        //打开连接和创建频道
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名 127.0.0.1即localhost
        factory.setHost(this.host);
        //创建连接
        connection = factory.newConnection();
        //创建频道
        channel = connection.createChannel();
        //声明创建队列
        channel.queueDeclare(queueName, false, false, false, null);
    }

    public void setHost(String host) {
        this.host = host;
    }

}
