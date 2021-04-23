package com.zhang.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2020/10/07/19:41
 */
@Configuration
public class DefaultView extends WebMvcAutoConfiguration {

    @Bean
    WebMvcConfigurer getWebMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("").setViewName("/static/index");
            }
            /**
             * 指定静态资源的位置 非前后端分离项目需要注册
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                /*静态资源的位置*/
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
            }

            /**
             * 注册拦截器
             *
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {


                //放行路径
                List<String> jwtExcludePatterns = new ArrayList();
                //druid
                jwtExcludePatterns.add("/druid/**");
                //swagger
                jwtExcludePatterns.add("/webjars/**");
                jwtExcludePatterns.add("/swagger/**");
                jwtExcludePatterns.add("/v2/**");
                jwtExcludePatterns.add("/swagger-ui.html/**");
                jwtExcludePatterns.add("/swagger-resources/**");
                //系统静态资源的放行  前后端分离项目不用考虑静态资源的放行，只需要验权即可
                jwtExcludePatterns.add("/");
                jwtExcludePatterns.add("/index.html");
                jwtExcludePatterns.add("/css/**");
                jwtExcludePatterns.add("/js/**");
                //需要放行的接口
                jwtExcludePatterns.add("/sys/login");
                jwtExcludePatterns.add("/login");
                jwtExcludePatterns.add("//test/**");

            }
        };
        return webMvcConfigurer;
    }
}
