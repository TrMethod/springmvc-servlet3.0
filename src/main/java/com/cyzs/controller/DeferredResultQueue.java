package com.cyzs.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xiaoH
 * @create 2019-07-01-18:29
 */
public class DeferredResultQueue {
    public static Queue<DeferredResult<Object>> queue =
            new ConcurrentLinkedQueue<DeferredResult<Object>>();

    public static void save(DeferredResult<Object> d){
        queue.add(d);
    }

    public static DeferredResult get(){
        return queue.poll();
    }
}
