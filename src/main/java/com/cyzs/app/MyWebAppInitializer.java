package com.cyzs.app;

import com.cyzs.config.AppContext;
import com.cyzs.config.AppMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author xiaoH
 * @create 2019-07-01-16:53
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //获取spring上下文配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppContext.class};
    }
    //获取springMVC配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppMvc.class};
    }
    //DispatcherServlet的映射规则
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
