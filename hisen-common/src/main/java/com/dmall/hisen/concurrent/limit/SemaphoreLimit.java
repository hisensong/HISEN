package com.dmall.hisen.concurrent.limit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Description:
 * Semaphore 可以很轻松完成信号量控制，
 * Semaphore可以控制某个资源可被同时访问的个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可
 *
 * Semaphore维护了当前访问的个数，提供同步机制，控制同时访问的个数。
 *
 * Author:HisenSong
 * DateTime: 2016/9/2 14:30
 */

public class SemaphoreLimit {
    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index <100; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep(2000L);
                        // 访问完后，释放
                        semp.release();
                        System.out.println("-----------------"+semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }

        // 退出线程池

        exec.shutdown();

    }
}
