package com.dmall.hisen.mq.rabbit;

import com.dmall.hisen.mq.springrabbit.producer.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/12/29 15:23
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/spring-mq.xml"})
public class SpringRabbitTest {
    @Autowired
    MqProducer mqProducer;

    final String queue_key = "test_queue_key";

    @Test
    public void send(){
        Map<String,Object> msg = new HashMap<>();
        msg.put("data","hello,rabbmitmq!");
        mqProducer.sendDataToQueue(queue_key,msg);
    }

}
