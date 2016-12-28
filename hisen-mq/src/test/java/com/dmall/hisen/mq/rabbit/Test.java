package com.dmall.hisen.mq.rabbit;

import com.dmall.hisen.mq.rabbit.base.MessageInfo;
import com.dmall.hisen.mq.rabbit.consumer.Receiver;
import com.dmall.hisen.mq.rabbit.producer.Sender;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/28 16:32
 */

public class Test {

    public static void main(String[] args) throws Exception{
        Receiver receiver = new Receiver("testQueue");
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
        Sender sender = new Sender("testQueue");
        for (int i = 0; i < 5; i++) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.setChannel("hisen");
            messageInfo.setContent("msg" + i);
            sender.sendMessage(messageInfo);
        }
    }
}
