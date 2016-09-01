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

        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "你好:" + key;
            }
        });

        System.out.println(cache.get("hisen"));
        System.out.println(cache.get("gome"));

    }
}
