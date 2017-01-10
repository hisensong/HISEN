package com.dmall.hisen.dubbo.service.api;

import com.dmall.hisen.dubbo.service.api.entity.DemoEntity;

/**
 * Description:demo服务API
 * Author:HisenSong
 * DateTime: 2017/1/10 18:36
 */

public interface DemoApi {

    String demoQuery(DemoEntity demoEntity);

}
