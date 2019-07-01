package com.cyzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author xiaoH
 * @create 2019-07-01-17:42
 */
@Controller
public class AsyncController {

    //虽然异步处理，响应时间没变，只是及时释放了接收请求的线程
    //
    @ResponseBody
    @RequestMapping("/async")
    public Callable<String> async(){
        System.out.println("主线程开始"+Thread.currentThread());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("副线程开始"+Thread.currentThread());
                Thread.sleep(3000);
                System.out.println("副线程结束"+Thread.currentThread());
                return "异步方法";
            }
        };
        System.out.println("主线程结束"+Thread.currentThread());
        return callable;
    }

    //模拟消息中间件异步调用
    @RequestMapping("/creatOrder")
    @ResponseBody
    public DeferredResult<Object> order(){
        DeferredResult<Object> result = new DeferredResult<Object>(3000L, "create fail");
        DeferredResultQueue.save(result);
        return result;
    }

    @ResponseBody
    @RequestMapping("/order")
    public String getOrder(){
        String s = UUID.randomUUID().toString();
        DeferredResult deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(s);
        return s;
    }

}
