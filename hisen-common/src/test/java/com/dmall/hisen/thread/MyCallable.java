package com.dmall.hisen.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author:HisenSong
 * DateTime: 2016/8/31 18:13
 */

public class MyCallable implements Callable<Object> {
    private  AtomicInteger atomicInteger;

    public MyCallable(int initNum) {
        atomicInteger = new AtomicInteger(initNum);
    }

    @Override
    public Object call() throws Exception {
        return atomicInteger.incrementAndGet();
    }
}
