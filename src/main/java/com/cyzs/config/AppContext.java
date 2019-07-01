package com.cyzs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author xiaoH
 * @create 2019-07-01-17:00
 */
@ComponentScan(value = {"com.cyzs"},excludeFilters ={
        @ComponentScan.Filter(type = FilterType.ANNOTATION
                ,classes = {Controller.class})
} )
public class AppContext {

}
