package com.dmall.hisen.concurrent.queue;

import com.sun.deploy.net.HttpRequest;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Description:jdk中并发队列
 * Author:HisenSong
 * DateTime: 2016/9/12 14:54
 */

public class JdkQueue {

    public static void main(String[] args){

        ConcurrentLinkedDeque<HttpRequest> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.poll();

    }

}
