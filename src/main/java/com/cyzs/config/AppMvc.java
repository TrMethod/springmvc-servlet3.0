package com.cyzs.config;

import com.cyzs.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @EnableWebMvc  开启springmvc 配置功能
 * @author xiaoH
 * @create 2019-07-01-17:00
 */
@ComponentScan(value = {"com.cyzs"},includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters=false)
@EnableWebMvc
public class AppMvc extends WebMvcConfigurerAdapter{

    //添加视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    //配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }
}
