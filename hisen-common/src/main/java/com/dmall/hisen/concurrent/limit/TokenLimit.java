package com.dmall.hisen.concurrent.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 利用令牌桶算法实现限流--平滑突发限流和平滑预热限流
 * Created by : Hisensong
 * Created time:  2016/8/31.
 */
public class TokenLimit {

    public static void main(String[] args) throws Exception {
      //  smoothBursty();
        smoothWarmingUp();
    }


    /**
     * 平滑突发限流
     * @throws InterruptedException
     */
    public static void smoothBursty() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());

    }

    /**
     * 平滑预热限流
     * @throws InterruptedException
     */
    public static void smoothWarmingUp() throws InterruptedException {
        /**
         * RateLimiter.create(doublepermitsPerSecond, long warmupPeriod, TimeUnit unit)
         *permitsPerSecond表示每秒新增的令牌数，warmupPeriod表示在从冷启动速率过渡到平均速率的时间间隔。
         */
        RateLimiter limiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);
        for(int i = 1; i < 5;i++) {
            Thread.sleep(1000L);
            System.out.println("limiter.tryAcquire()==="+limiter.tryAcquire());
            System.out.println(limiter.acquire());
        }

        for(int i = 1; i < 10;i++) {
            System.out.println(limiter.acquire());

        }
    }

    public void demo(){
        //官网例子
       /* final RateLimiter rateLimiter = RateLimiter.create(2.0);
        void submitTasks(List<Runnable> tasks, Executor executor) {
            for (Runnable task : tasks) {
                rateLimiter.acquire(); // may wait
                executor.execute(task);
            }
        }*/

        //可以使用非阻塞的形式达到降级运行的目的,即使用非阻塞的tryAcquire()方法:
       /* if(limiter.tryAcquire()) { //未请求到limiter则立即返回false
            doSomething();
        }else{
            doSomethingElse();
        }*/
    }
}
