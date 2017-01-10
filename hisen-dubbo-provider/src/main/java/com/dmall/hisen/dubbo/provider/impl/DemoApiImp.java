package com.dmall.hisen.dubbo.provider.impl;

import com.dmall.hisen.dubbo.service.api.DemoApi;
import com.dmall.hisen.dubbo.service.api.entity.DemoEntity;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2017/1/10 18:46
 */

public class DemoApiImp implements DemoApi{

    @Override
    public String demoQuery(DemoEntity demoEntity) {
        return demoEntity.toString();
    }
}
