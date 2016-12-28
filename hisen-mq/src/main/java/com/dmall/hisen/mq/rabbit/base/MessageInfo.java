package com.dmall.hisen.mq.rabbit.base;

import java.io.Serializable;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/28 16:21
 */

public class MessageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //渠道
    private String channel;
    //来源
    private String content;
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
