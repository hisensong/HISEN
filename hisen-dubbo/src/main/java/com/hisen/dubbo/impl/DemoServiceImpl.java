package com.hisen.dubbo.impl;

import com.hisen.dubbo.IDemoService;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/10/13 15:53
 */

public class DemoServiceImpl implements IDemoService {

    @Override
    public String sayHello(String name) {
        return "hello dubbo :" + name;
    }
}
