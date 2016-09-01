package com.dmall.hisen.concurrent.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Description:从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值
 * Author:HisenSong
 * DateTime: 2016/9/1 14:22
 */

public class LocalCache {


    public static void main(String[] args) throws Exception {
        cacheLoader();
        cacheCallback();
    }


    /**
     * cacheloader的定义比较宽泛，是针对整个cache定义的
     * 统一的根据key值load value的方法
     */
    private static void cacheLoader() throws ExecutionException {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "你好:" + key;
            }
        });
        System.out.println(cache.get("hisen"));
        System.out.println(cache.get("gome"));
    }

    /**
     * 而callable的方式较为灵活，允许你在get的时候指定。
     *
     */
    private static void cacheCallback() throws ExecutionException {

       Cache<String,String> cache =  CacheBuilder.newBuilder().maximumSize(1000).build();

        String resultVal = cache.get("hisen", new Callable<String>() {
            @Override
            public String call() throws Exception {
                String value = "你好" + "hisen!";
                return value;
            }
        });

        System.out.println("resultVal====" + resultVal);

    }

}
