package com.dmall.hisen.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Description:限流某个接口的时间窗请求数
 * Author:HisenSong
 * DateTime: 2016/8/31 19:26
 */

public class TestA {

    public static void main(String[] args) throws ExecutionException {
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(15));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));

    }
}
