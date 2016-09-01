package com.dmall.hisen.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutionException;

/**
 * Description:限流某个接口的时间窗请求数
 * Author:HisenSong
 * DateTime: 2016/8/31 19:26
 */

public class TestA {

    public static void main(String[] args) throws ExecutionException {

        LoadingCache<String,TempEntity> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, TempEntity>() {
            @Override
            public TempEntity load(String key) throws Exception {
                TempEntity tempEntity = new TempEntity();
                tempEntity.setAge(11);
                tempEntity.setName(key);
                tempEntity.setSex("男");
                return tempEntity;
            }
        });


        System.out.println(cache.get("hisen").toString());
        System.out.println(cache.get("gome").toString());





    }
}
