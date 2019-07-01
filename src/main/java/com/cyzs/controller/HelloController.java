package com.cyzs.controller;

import com.cyzs.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaoH
 * @create 2019-07-01-17:09
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String say(){
        return helloService.say();
    }

    @RequestMapping("/suc")
    public String suc(){
        return "success";
    }
}
