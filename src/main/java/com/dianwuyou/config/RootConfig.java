package com.dianwuyou.config;

import com.dianwuyou.service.LoggingService;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by hebowei on 16/6/9.
 */
@Configuration
@ComponentScan(basePackages = "com.dianwuyou",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@EnableAspectJAutoProxy
@EnableAsync
public class RootConfig {

    @Bean
    public LoggingService loggingService(){
        return new LoggingService();
    }
}
